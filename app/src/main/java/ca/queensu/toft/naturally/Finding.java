package ca.queensu.toft.naturally;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import ca.queensu.toft.naturally.Model.Guess;

public class Finding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding);
        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");
//        float latitude = intent.getFloatExtra("latitude", 0.0f);
//        float longitude = intent.getFloatExtra("longitude", 0.0f);
        float latitude = 4.4f;
        float longitude = 50.1f;
        PictureRecognizor pr = new PictureRecognizor();
        Guess guess = pr.guess(bitmap, latitude, longitude);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        TextView guessView = (TextView)findViewById(R.id.textView2);
        TextView certaintyView = (TextView)findViewById(R.id.textView3);
        imageView.setImageBitmap(bitmap);
        guessView.setText(guess.getSpecies());
        certaintyView.setText(Float.toString(guess.getCertainty()));

    }
}
