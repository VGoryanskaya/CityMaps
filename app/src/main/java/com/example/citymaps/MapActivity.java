package com.example.citymaps;

import static com.example.citymaps.MainListActivity.hotels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.geometry.Geo;
import com.yandex.runtime.image.ImageProvider;

public class MapActivity extends AppCompatActivity {
    private MapView mapView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_map);

        Bundle arguments = getIntent().getExtras();
        Sight sight = (Sight) arguments.getParcelable("Sight");

        TextView textView = (TextView) findViewById(R.id.description);
        String recommendation = "";
        int hotelIndexMinDistace = 0;

        if (hotels.size() > 0) {
            int i = 0;
            double minDistance = Geo.distance(sight.getCoordinates(), hotels.get(i).getCoordinates());
            for (i = 1; i < hotels.size(); i++) {
                double distance = Geo.distance(sight.getCoordinates(), hotels.get(i).getCoordinates());
                if (distance < minDistance) {
                    minDistance = distance;
                    hotelIndexMinDistace = i;
                }
            }
            recommendation = String.format("\n\nRecommended hotel: %s Price: %d Distance: %f km",
                    hotels.get(hotelIndexMinDistace).getName(),
                    hotels.get(hotelIndexMinDistace).getPrice(),
                    minDistance/1000);
        }

        textView.setText(sight.getDescription() + recommendation);

        mapView = (MapView) findViewById(R.id.mapview);

        mapView.getMap().move(
                new CameraPosition(sight.getCoordinates(), 15.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 5),
                null);

        ImageProvider poiImageProvider = ImageProvider.fromResource(this, R.drawable.poi);
        mapView.getMap().getMapObjects().addPlacemark(sight.getCoordinates(),poiImageProvider);

        if (hotels.size() > 0){
            ImageProvider hotelImageProvider = ImageProvider.fromResource(this, R.drawable.hotel);
            mapView.getMap().getMapObjects().addPlacemark(hotels.get(hotelIndexMinDistace).getCoordinates(),hotelImageProvider);
        }
    }

    @Override
    protected void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }
}
