package ca.queensu.toft.naturally;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.Date;

public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private Context context;
    private Bitmap bitmap;
    private double lat;
    private double lng;
    private String animal;
    private Date time;

    public MyInfoWindowAdapter(Context context) {
        this.context = context.getApplicationContext();
    }

    public MyInfoWindowAdapter(Context context, Bitmap bitmap) {
        this.context = context.getApplicationContext();
        this.bitmap = bitmap;
    }

    public MyInfoWindowAdapter(Context context, double lat, double lng,
                               String animal, Date time) {
        this.context = context.getApplicationContext();
        this.lat = lat;
        this.lng = lng;
        this.animal = animal;
        this.time = time;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v =  inflater.inflate(R.layout.bird_window, null);
//        if (bitmap != null) {
//            ImageView imageView = (ImageView)v.findViewById(R.id.imageView);
//            imageView.setImageBitmap(bitmap);
//        }
        TextView animalName = v.findViewById(R.id.textView5);
        TextView timeStamp = v.findViewById(R.id.textView8);
        animalName.setText(animal);
        timeStamp.setText(time.toString());
        return v;
    }
}
