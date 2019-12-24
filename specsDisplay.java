package com.example.cs478project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class specsDisplay extends AppCompatActivity {

    String[] RAM_sizes = {"2GB", "3GB", "1GB", "4GB", "1GB", "4GB"};
    String[] Storage_sizes = {"32GB", "32GB", "16GB/32GB/64GB/128GB", "64GB", "8GB", "64GB"};
    String[] Prices = {"$130", "$250", "$350/$400/$450", "$250", "$76", "$400"};
    String[] Resolutions = {"720x1520", "720x1560", "750x1334", "1440x2880", "720x1720", "1080x2160"};

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specs_display);

        Bundle b = getIntent().getExtras();
        if (b != null)
        {
            pos = b.getInt("pos");
        }

        TextView ramView = (TextView)findViewById(R.id.RAM);
        ramView.setText(RAM_sizes[pos]);
        TextView storeView = (TextView)findViewById(R.id.Storage);
        storeView.setText(Storage_sizes[pos]);
        TextView priceView = (TextView)findViewById(R.id.Price);
        priceView.setText(Prices[pos]);
        TextView resView = (TextView)findViewById(R.id.Resolution);
        resView.setText(Resolutions[pos]);

    }


}
