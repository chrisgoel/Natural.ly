package ca.queensu.toft.naturally;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button loginButton;
        Button signupButton;
        ImageView treeView;
        loginButton = (Button)findViewById(R.id.login_button);
        signupButton = (Button)findViewById(R.id.sign_up_button);
        treeView = (ImageView)findViewById(R.id.tree);
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Path path = new Path();
//            path.arcTo(0f, 1000f, 0f, 0f, 0f, 0f, true);
            float treeX = 10f;
            float treeY = 1000f;
            treeView.setY(treeY);
            ObjectAnimator animator = ObjectAnimator.ofFloat(treeView, "translationY", 8f);
            animator.setDuration(2000);
            animator.start();
            treeView = (ImageView) findViewById(R.id.tree2);
            treeView.setY(treeY);
            treeX += 330;
            treeView.setX(treeX);
            animator = ObjectAnimator.ofFloat(treeView, "translationY", 8f);
            animator.setStartDelay(1000);
            animator.setDuration(2000);
            animator.start();
            treeView = (ImageView) findViewById(R.id.tree3);
            treeView.setY(treeY);
            treeX += 350;
            treeView.setX(treeX);
            animator = ObjectAnimator.ofFloat(treeView, "translationY", 8f);
            animator.setStartDelay(2000);
            animator.setDuration(2000);
            animator.start();
            ImageView sunView = (ImageView) findViewById(R.id.sun);
            sunView.setY(-2000f);
            sunView.setX(0);
            animator = ObjectAnimator.ofFloat(sunView, "translationY", -1000f);
            animator.setDuration(2000);
            animator.start();
        } else {
            // Create animator without using curved path
        }
    }
}
