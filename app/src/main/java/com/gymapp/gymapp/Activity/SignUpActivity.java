package com.gymapp.gymapp.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.gymapp.gymapp.Model.Business.AccountBus;
import com.gymapp.gymapp.Model.Exception.EmptyStringException;
import com.gymapp.gymapp.Model.Exception.Feedback;
import com.gymapp.gymapp.Model.Exception.InvalidException;
import com.gymapp.gymapp.R;

public class SignUpActivity extends AppCompatActivity {

    //<editor-fold desc="Control">
    EditText editTextEmail;
    EditText editTextPassword;
    TextView textViewSignIn;
    Button buttonSignUp;
//</editor-fold>


    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    void initControl() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignIn = (TextView) findViewById(R.id.textViewSignIn);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
    }


    void initEvent() {
        textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khi nhấn nút Đã có tài khoản đăng nhập tại đây thì mở activity đăng nhập để đăng nhập
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Đưa vào 1 đối tượng AccountBus để kiểm tra nghiệp vụ xem dữ liệu người dùng có hợp lệ chưa
                    AccountBus accountBus = new AccountBus(editTextEmail.getText().toString(), editTextPassword.getText().toString());
                    // Xuất dialog chờ đăng nhập
                    final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
                    progressDialog.setMessage("Vui lòng chờ..");
                    progressDialog.show();
                    // Đăng ký đối tượng accountBus trên firebase
                    accountBus.SignUp(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                // Neu dang ky thanh cong
                                finish();
                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                            } else {
                                try {
                                    throw task.getException();
                                } catch (FirebaseNetworkException e) {
                                    Toast.makeText(SignUpActivity.this, "Không có kết nối mạng!", Toast.LENGTH_SHORT).show();
                                } catch (FirebaseAuthUserCollisionException e) {
                                    Toast.makeText(SignUpActivity.this, "Tài khoản đã tồn tại!", Toast.LENGTH_SHORT).show();
                                }
                                catch (FirebaseAuthInvalidCredentialsException e){
                                    Toast.makeText(SignUpActivity.this, "Dữ liệu nhập không hợp lệ!", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Toast.makeText(SignUpActivity.this, "Đã có lỗi xảy ra! Đã gửi feedback, sẽ khắc phục sớm", Toast.LENGTH_SHORT).show();
                                    Feedback.getInstance().setFeedBackString(e.getClass().toString()+"_"+e.getMessage());
                                }

                                //  Toast.makeText(SignUpActivity.this,task.getException().getClass().toString(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } catch (Exception e) {
                    //Nếu dữ liệu không hợp lệ thì xuất thông báo ra màn hình để người dùng biết
                    Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initControl();
        initEvent();
    }
}
