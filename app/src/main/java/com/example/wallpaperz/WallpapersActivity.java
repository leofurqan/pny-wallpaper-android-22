package com.example.wallpaperz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.wallpaperz.adapters.WallpapersAdapter;
import com.example.wallpaperz.data.AppData;

import java.util.ArrayList;

public class WallpapersActivity extends AppCompatActivity {

    ArrayList<String> url;
    RecyclerView rvWallpapers;
    WallpapersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpapers);

        rvWallpapers = findViewById(R.id.rv_wallpapers);

        url = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            url.add(AppData.url + i + ".jpg");
        }

        adapter = new WallpapersAdapter(this, url);
        rvWallpapers.setAdapter(adapter);
        rvWallpapers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}