package ca.queensu.toft.naturally;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button loginButton;
        Button signupButton;
        loginButton = (Button)findViewById(R.id.login_button);
        signupButton = (Button)findViewById(R.id.sign_up_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignUp.class);
                startActivity(i);
            }
        });

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Path path = new Path();
//            path.arcTo(0f, 0f, 1000f, 1000f, 270f, -180f, true);
//            ObjectAnimator animator = ObjectAnimator.ofFloat(loginButton, View.X, View.Y, path);
//            animator.setDuration(2000);
//            animator.start();
//        } else {
//            // Create animator without using curved path
//        }
    }
}
