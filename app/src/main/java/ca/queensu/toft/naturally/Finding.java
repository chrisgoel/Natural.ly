package ca.queensu.toft.naturally;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
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
        final float lat = intent.getFloatExtra("latitude", 0);
        final float lng = intent.getFloatExtra("longitude", 0);
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
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);
        final Date time = guess.getTimestamp();
        certaintyView.setText(df.format(100 * guess.getCertainty()) + "% certainty");
        Button suggestionButton = findViewById(R.id.button);
        Button overrideButton = findViewById(R.id.newName);
        final EditText customName = findViewById(R.id.editText);
        final String name = guess.getSpecies();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        suggestionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DatabaseReference myref = database.getReference("message");
                String id = myref.push().getKey();
                Marker marker = new Marker(id, lat, lng, name, time);
                myref.child(id).setValue(marker);
                Toast.makeText(Finding.this, "Added into the Database", Toast.LENGTH_SHORT ).show();
                Intent i = new Intent(getApplicationContext(), Maps.class);
                startActivity(i);
            }
        });

        overrideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference myref = database.getReference("message");
                String id = myref.push().getKey();
                Marker marker = new Marker(id, lat, lng, customName.getText().toString(),time);
                myref.child(id).setValue(marker);
                Toast.makeText(Finding.this, "Added into the Database", Toast.LENGTH_SHORT ).show();
                Intent i = new Intent(getApplicationContext(), Maps.class);
                startActivity(i);
            }
        });
    }
}
