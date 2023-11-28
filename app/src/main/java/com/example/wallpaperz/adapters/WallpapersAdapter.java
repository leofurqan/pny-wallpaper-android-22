package com.example.wallpaperz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.wallpaperz.R;

import java.util.ArrayList;

public class WallpapersAdapter extends RecyclerView.Adapter<WallpapersAdapter.ViewHolder>{
    private Context context;
    private ArrayList<String> url;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgWallpaper;
        public ViewHolder(View view) {
            super(view);

            imgWallpaper = view.findViewById(R.id.img_wallpaper);
        }

        public ImageView getImgWallpaper() {
            return imgWallpaper;
        }
    }

    public WallpapersAdapter(Context context, ArrayList<String> url) {
        this.context = context;
        this.url = url;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_wallpaper, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String image = url.get(position);

        Glide
                .with(context)
                .load(image)
                .thumbnail(Glide.with(context).load(R.raw.loading))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.drawable.error)
                .into(holder.getImgWallpaper());
    }

    @Override
    public int getItemCount() {
        return url.size();
    }
}
