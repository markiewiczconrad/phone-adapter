package com.example.cs478project2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs478project2.R;

public class PhoneAdapter extends BaseAdapter {
    private final Activity context;
    private final Integer[] images;
    private final String[] names;
    private final String[] descriptions;

    public PhoneAdapter(Activity src_context, Integer[] src_images, String[] src_names, String[] src_descriptions)
    {
        this.context = src_context;
        this.images = src_images;
        this.names = src_names;
        this.descriptions = src_descriptions;
    }

    public View getView(int pos, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(R.layout.row, null, true);
        ImageView imageField = (ImageView)row.findViewById(R.id.Image);
        TextView nameField = (TextView)row.findViewById(R.id.Name);
        TextView descField = (TextView)row.findViewById(R.id.Description);
        imageField.setImageResource(images[pos]);
        nameField.setText(names[pos]);
        descField.setText(descriptions[pos]);

        return row;
    }

    @Override
    public int getCount() { return images.length; }

    @Override
    public Object getItem(int position) { return images[position]; }

    @Override
    public long getItemId(int position) { return images[position]; }

}
