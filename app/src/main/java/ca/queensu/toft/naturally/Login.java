package ca.queensu.toft.naturally;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.database.Cursor;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A login screen that offers login via email/password.
 */
public class Login extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    TextView email, password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.email_sign_in_button);

        firebaseAuth = FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String finalEmail = email.getText().toString();
                String finalPassword= password.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(finalEmail, finalPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(Login.this, "IT FRIGGEN WORKED", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), Maps.class);
                        startActivity(i);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Https("6474674739", "IT WORKED BRUDER");
                        Toast.makeText(Login.this, "IT DID NOT WORK :( ", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    public void Https(String tel1, String message){
        OkHttpClient client = new OkHttpClient();
        String url = "https://Shred13.lib.id/tester@dev/sequence/?tel1="+tel1+"&message="+message;
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Toast.makeText(Login.this, "rip in bois", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                }
            }
        });
    }
}


