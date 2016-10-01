package com.gymapp.gymapp.Model.Business;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.gymapp.gymapp.Model.Exception.EmptyStringException;
import com.gymapp.gymapp.Model.Exception.InvalidException;

import java.util.concurrent.ExecutionException;

/**
 * Created by hungbin on 9/23/2016.
 */
public final class AccountBus {
    String email,password;

    public AccountBus() throws EmptyStringException, InvalidException {
        String email = "", password="";
        setEmail(email);
        setPassword(password);
    }


    /**
     * @return Người dùng được lưu sau lần đăng nhập trước.
     * Nếu mới bắt đầu sử dụng hoặc tài khoản được lưu đã logout thì nó sẽ bằng null
     */
    static FirebaseUser getCurrentFirebaseUser(){
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    /**
     * Tạo đối tượng account mới với email và password
     * @param email: đối tượng email cần kiểm tra tính hợp lệ
     * @param password: đối tượng password cần kiểm tra tính hợp lệ
     * @throws EmptyStringException khi email trống
     * @throws InvalidException khi email không hợp lệ như thiếu @ hoặc .
     */
    public AccountBus(String email,String password) throws EmptyStringException, InvalidException{
        setEmail(email);
        setPassword(password);
    }


    /**
     * Kiểm tra tính hợp lệ của email trước khi đưa email đó vào đối tượng
     * @param email đối tượng email cần kiểm tra tính hợp lệ
     * @throws EmptyStringException khi email trống
     * @throws InvalidException khi email không hợp lệ như thiếu @ hoặc .
     */
    public void setEmail(String email) throws EmptyStringException, InvalidException {
        //check email is empty
        if(email.isEmpty()){
            throw new EmptyStringException("Email không được để trống");
        }
        //check email is invalid
        if(email.indexOf("@")==-1){
            throw new InvalidException("Email không hợp lệ");
        }
        this.email = email;
    }

    /**
     * Kiểm tra tính hợp lệ của password trước khi đưa email đó vào đối tượng
     * @param password đối tượng email cần kiểm tra tính hợp lệ
     * @throws EmptyStringException khi password trống
     * @throws InvalidException khi password không hợp lệ như thiếu @ hoặc .
     */
    public void setPassword(String password) throws EmptyStringException, InvalidException{
        //check password is empty
        if(password.isEmpty()){
            throw new EmptyStringException("Password không được để trống");
        }
        //check password is invalid

        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }



    public void SignIn(Activity activity,@NonNull OnCompleteListener<AuthResult> var1){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(getEmail(),getPassword()).addOnCompleteListener(activity,var1);
    }


    public void SignUp(Activity activity,@NonNull OnCompleteListener<AuthResult> var1){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(getEmail(), getPassword()).addOnCompleteListener(activity,var1);
    }

}
