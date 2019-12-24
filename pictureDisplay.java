package com.example.cs478project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class pictureDisplay extends AppCompatActivity {

    Integer[] images = {R.drawable.a10, R.drawable.a20, R.drawable.iphone6, R.drawable.v30, R.drawable.blu, R.drawable.pixel3a};

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_display);

        Bundle b = getIntent().getExtras();
        if (b != null)
        {
            pos = b.getInt("pos");
        }

        ImageView image = (ImageView)findViewById(R.id.phone_image);
        image.setImageResource(images[pos]);
    }
}
