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

public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private Context context;
    private Bitmap bitmap;

    public MyInfoWindowAdapter(Context context) {
        this.context = context.getApplicationContext();
    }

    public MyInfoWindowAdapter(Context context, Bitmap bitmap) {
        this.context = context.getApplicationContext();
        this.bitmap = bitmap;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v =  inflater.inflate(R.layout.bird_window, null);
        if (bitmap != null) {
            ImageView imageView = (ImageView)v.findViewById(R.id.imageView);
            imageView.setImageBitmap(bitmap);
        }
        return v;
    }
}
