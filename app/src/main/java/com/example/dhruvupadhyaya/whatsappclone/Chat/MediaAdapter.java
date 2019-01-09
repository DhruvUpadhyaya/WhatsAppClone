package com.example.dhruvupadhyaya.whatsappclone.Chat;



import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dhruvupadhyaya.whatsappclone.R;

import java.util.ArrayList;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MediaViewHolder>{
    ArrayList<String> mediaList;
    Context context;

    public MediaAdapter(Context context, ArrayList<String> mediaList){
        this.context = context;
        this.mediaList = mediaList;
    }

    @NonNull
    @Override
    public MediaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_media,null,false);
        MediaViewHolder mediaViewHolder = new MediaViewHolder(layoutView);
        return mediaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MediaViewHolder mediaViewHolder, int i) {


        Glide.with(context).load(Uri.parse(mediaList.get(i))).into(mediaViewHolder.mMedia);

    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }

    public class MediaViewHolder extends RecyclerView.ViewHolder{

        ImageView mMedia;
        public MediaViewHolder(@NonNull View itemView) {
            super(itemView);
            mMedia = itemView.findViewById(R.id.media);
        }
    }
}
