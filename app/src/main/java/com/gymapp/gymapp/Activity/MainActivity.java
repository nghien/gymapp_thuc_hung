package com.gymapp.gymapp.Activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.gymapp.gymapp.Adapter.ViewPagerAdapter;
import com.gymapp.gymapp.R;

public class MainActivity extends AppCompatActivity
        implements GoogleApiClient.OnConnectionFailedListener,AppBarLayout.OnOffsetChangedListener {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ExpandableListView expandableListView;
    //PresenterLogicXuLyMenu logicXuLyMenu;
    String tennguoidung = "";
    //AccessToken accessToken;
    Menu menu;
    //ModelDangNhap modelDangNhap;
    MenuItem itemDangNhap,menuITDangXuat;
    GoogleApiClient mGoogleApiClient;
  //  GoogleSignInResult googleSignInResult;
    CollapsingToolbarLayout collapsingToolbarLayout;
    AppBarLayout appBarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
       // expandableListView = (ExpandableListView) findViewById(R.id.epMenu);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

       // logicXuLyMenu = new PresenterLogicXuLyMenu(this);
     //   modelDangNhap = new ModelDangNhap();

       // logicXuLyMenu.LayDanhSachMenu();

      //  mGoogleApiClient = modelDangNhap.LayGoogleApiClient(this,this);

        appBarLayout.addOnOffsetChangedListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        this.menu = menu;

        itemDangNhap = menu.findItem(R.id.itDangNhap);
        menuITDangXuat = menu.findItem(R.id.itDangXuat);

    //    accessToken = logicXuLyMenu.LayTokenDungFacebook();
      //  googleSignInResult = modelDangNhap.LayThongDangNhapGoogle(mGoogleApiClient);

//        if(accessToken != null){
//            GraphRequest graphRequest = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
//                @Override
//                public void onCompleted(JSONObject object, GraphResponse response) {
//                    try {
//                        tennguoidung = object.getString("name");
//
//                        itemDangNhap.setTitle(tennguoidung);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//            Bundle parameter = new Bundle();
//            parameter.putString("fields","name");
//
//            graphRequest.setParameters(parameter);
//            graphRequest.executeAsync();
//        }
//
//
//        if(googleSignInResult != null){
//            itemDangNhap.setTitle(googleSignInResult.getSignInAccount().getDisplayName());
//            Log.d("goo",googleSignInResult.getSignInAccount().getDisplayName());
//        }
//
//        String tennv = modelDangNhap.LayCachedDangNhap(this);
//        if(!tennv.equals("")){
//            itemDangNhap.setTitle(tennv);
//        }
//
//
//        if(accessToken != null || googleSignInResult != null || !tennv .equals("")){
//            menuITDangXuat.setVisible(true);
//        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        int id = item.getItemId();
        switch (id){
//            case R.id.itDangNhap:
//                if(accessToken == null && googleSignInResult == null && modelDangNhap.LayCachedDangNhap(this).equals("")){
//                    Intent iDangNhap = new Intent(this, DangNhapActivity.class);
//                    startActivity(iDangNhap);
//                };break;
//
//            case R.id.itDangXuat:
//                if(accessToken != null){
//                    LoginManager.getInstance().logOut();
//                    this.menu.clear();
//                    this.onCreateOptionsMenu(this.menu);
//                }
//
//                if(googleSignInResult != null){
//                    Auth.GoogleSignInApi.signOut(mGoogleApiClient);
//                    this.menu.clear();
//                    this.onCreateOptionsMenu(this.menu);
//
//                }
//
//                if(!modelDangNhap.LayCachedDangNhap(this).equals("")){
//                    modelDangNhap.CapNhatCachedDangNhap(this,"");
//                    this.menu.clear();
//                    this.onCreateOptionsMenu(this.menu);
//                }
        }

        return true;
    }

//    @Override
//    public void HienThiDanhSachMenu(List<Category> loaiSanPhamList) {
//        ExpandAdater expandAdater = new ExpandAdater(this,loaiSanPhamList);
//        expandableListView.setAdapter(expandAdater);
//        expandAdater.notifyDataSetChanged();
//    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

        if(collapsingToolbarLayout.getHeight() + verticalOffset <=  1.5 * ViewCompat.getMinimumHeight(collapsingToolbarLayout)){
            LinearLayout linearLayout = (LinearLayout) appBarLayout.findViewById(R.id.lnSearch);
            linearLayout.animate().alpha(0).setDuration(200);
        }else{
            LinearLayout linearLayout = (LinearLayout) appBarLayout.findViewById(R.id.lnSearch);
            linearLayout.animate().alpha(1).setDuration(200);
        }
    }


}
