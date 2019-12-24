package com.example.cs478project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class piclinkDisplay extends AppCompatActivity {

    Integer[] images = {R.drawable.a10, R.drawable.a20, R.drawable.iphone6, R.drawable.v30, R.drawable.blu, R.drawable.pixel3a};
    String[] sites = {"https://www.samsung.com/in/smartphones/galaxy-a10-a105f/SM-A105FZKGINS/", "https://www.samsung.com/us/mobile/phones/galaxy-a/galaxy-a20-t-mobile-sm-a205uzkatmb/", "https://www.apple.com/iphone/", "https://www.lg.com/us/cell-phones/lg-US998-Unlocked-v30", "https://bluproducts.com/android-phones/", "https://store.google.com/product/pixel_3a"};

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piclink_display);

        Bundle b = getIntent().getExtras();
        if (b != null)
        {
            pos = b.getInt("pos");
        }

        ImageView image = (ImageView)findViewById(R.id.Picture);
        image.setImageResource(images[pos]);
        image.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                openURL();
            }
        });
    }

    public void openURL()
    {
        Uri dest = Uri.parse(sites[pos]);
        Intent i = new Intent(Intent.ACTION_VIEW, dest);
        startActivity(i);
    }
}
