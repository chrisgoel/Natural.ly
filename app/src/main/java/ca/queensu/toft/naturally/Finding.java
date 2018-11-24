package ca.queensu.toft.naturally;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.Objects;

import ca.queensu.toft.naturally.Model.Guess;

import static ca.queensu.toft.naturally.PictureRecognizor.finding;

public class Finding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding);
        Intent intent = getIntent();
        final Bitmap bitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");
//        float latitude = intent.getFloatExtra("latitude", 0.0f);
//        float longitude = intent.getFloatExtra("longitude", 0.0f);
        float lat = intent.getFloatExtra("latitude", 0);
        float lng = intent.getFloatExtra("longitude", 0);
        System.out.println("latitude INTENT: " + lat);
        System.out.println("longitude INTENT: " + lng);
        PictureRecognizor pr = new PictureRecognizor();
        pr.guess(bitmap, lat, lng);

//        PictureRecognizor pr = new PictureRecognizor();
//        Guess guess = pr.guess(bitmap, latitude, longitude);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        TextView guessView = (TextView)findViewById(R.id.textView3);
        TextView certaintyView = (TextView)findViewById(R.id.textView4);
        imageView.setImageBitmap(bitmap);

        while (pr.getGuess() == null) {
        }
        Guess guess = pr.getGuess();
        guessView.setText(guess.getSpecies());
        certaintyView.setText(Float.toString(guess.getCertainty()));
    }
}
