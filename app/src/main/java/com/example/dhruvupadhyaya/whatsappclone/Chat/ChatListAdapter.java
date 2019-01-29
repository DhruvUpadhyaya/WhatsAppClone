package com.example.dhruvupadhyaya.whatsappclone.Chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dhruvupadhyaya.whatsappclone.ChatActivity;
import com.example.dhruvupadhyaya.whatsappclone.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatListViewHolder> {

    ArrayList<ChatObject> chatList;

    public ChatListAdapter(ArrayList<ChatObject> chatList){
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public ChatListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_chat,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        ChatListViewHolder rcv = new ChatListViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull final ChatListViewHolder chatListViewHolder, int i) {

        chatListViewHolder.mTitle.setText(chatList.get(i).getChatId());


        //TODO:
        // Creating chat
        chatListViewHolder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),ChatActivity.class);
                intent.putExtra("chatObject",chatList.get(chatListViewHolder.getAdapterPosition()));
                v.getContext().startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }




    public class ChatListViewHolder extends RecyclerView.ViewHolder{

        public TextView mTitle;
        public LinearLayout mLayout;
        public ChatListViewHolder(View view){
            super(view);

            mTitle = view.findViewById(R.id.title);

            mLayout = view.findViewById(R.id.layout);
        }
    }
}
