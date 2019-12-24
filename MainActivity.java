package com.example.cs478project2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] phones = {"Samsung Galaxy A10", "Samsung Galaxy A20", "Apple iPhone 6", "LG V30", "BLU Advance 5.2 HD", "Google Pixel 3a"};
    String[] descriptions = {"6.5\", Starting at $130", "6.4\", starting at $250", "4.7\", starting at $350", "6\", $250", "5.2\", $76", "5.6\", $400"};
    Integer[] images = {R.drawable.a10small, R.drawable.a20small, R.drawable.iphone6small, R.drawable.v30small, R.drawable.blusmall, R.drawable.pixel3asmall};
    String[] sites = {"http://www.samsung.com", "http://www.samsung.com", "http://www.apple.com", "http://www.lg.com", "http://bluproducts.com", "http://www.google.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new PhoneAdapter(this, images, phones, descriptions));

        ListView lv = getListView();

        registerForContextMenu(lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showPicture(position);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, v.getId(), 0, "Specs");
        menu.add(0, v.getId(), 0, "Image");
        menu.add(0, v.getId(), 0, "Site");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        if (item.getTitle().equals("Specs"))
        {
            showSpecs(info.position);
        }
        else if (item.getTitle().equals("Image"))
        {
            showBigPicture(info.position);
        }
        else if (item.getTitle().equals("Site"))
        {
            showSite(info.position);
        }
        else
        {
            return false;
        }
        return true;
    }

    public void showPicture(int pos)
    {
        Intent i = new Intent(this, piclinkDisplay.class);
        i.putExtra("pos", pos);
        startActivity(i);
    }

    public void showSpecs(int pos)
    {
        Intent i = new Intent(this, specsDisplay.class);
        i.putExtra("pos", pos);
        startActivity(i);
    }

    public void showBigPicture(int pos)
    {
        Intent i = new Intent(this, pictureDisplay.class);
        i.putExtra("pos", pos);
        startActivity(i);
    }

    public void showSite(int pos)
    {
        Uri dest = Uri.parse(sites[pos]);
        Intent i = new Intent(Intent.ACTION_VIEW, dest);
        startActivity(i);
    }
}
