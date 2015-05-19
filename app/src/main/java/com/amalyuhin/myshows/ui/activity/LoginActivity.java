package com.amalyuhin.myshows.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amalyuhin.myshows.MyShowsClient;
import com.amalyuhin.myshows.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A login screen that offers login via email/password.

 */
public class LoginActivity extends Activity {

    private Button loginBtn;
    private EditText username;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.sign_in_button);
        username = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
    }

    public void loginClick(View v) {
        String p = md5(pass.getText().toString());
        MyShowsClient.getApiService()
                .login(username.getText().toString(), p)
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Response>() {
                    @Override
                    public void call(Response response) {
                        Log.i("LOGIN RES", response.getBody().toString());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        if (throwable instanceof RetrofitError) {
                            int status = ((RetrofitError) throwable).getResponse().getStatus();

                            Toast.makeText(LoginActivity.this, "Error code: " + status, Toast.LENGTH_SHORT);
                            Log.w("MyShows", "Error code: " + status);
                        } else {
                            Log.w("MyShows", throwable.getMessage());
                            Toast.makeText(LoginActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT);
                        }
                    }
                });
    }

    private static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}



