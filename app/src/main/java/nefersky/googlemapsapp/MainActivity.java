package nefersky.googlemapsapp;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCheckedPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rgrPlaces);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                mCheckedPlace = checkedId;
            }
        });
    }

    private String getUri(){
        String geoString;
        switch(mCheckedPlace){
            case R.id.rbAfrica:
                geoString = "geo:0,10?z=2";
                break;
            case R.id.rbHimki:
                geoString = "geo:55.869555,37.503964?z=15";
                break;
            case R.id.rbBelgium:
                geoString = "geo:0,0?q=Belgium";
                break;
            case R.id.rbDIvuarCat:
                geoString = "geo:0,0?q=Кот Д'Ивуар&z=8";
                break;
            case R.id.rbCoffeeShops:
                geoString = "geo:0,0?q=Coffee Shops near Paris, France";
                break;
            case R.id.rbCatsTheatre:
                geoString = "geo:0,0?q=Москва+театр+кошек&z=8";
                break;
            case R.id.rbGrib:
                geoString = "google.streetview:cbll=59.939448,30.328264&cbp=1,99.56,,1,2.0&mz=19";
                break;
            default: geoString = "geo:0,0?z=2";
        }
        return geoString;
    }

    public void onClickMaps(View view) {
        String geoUriString = getUri();
        Uri geoUri = Uri.parse(geoUriString);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);
        startActivity(mapIntent);
    }
}
