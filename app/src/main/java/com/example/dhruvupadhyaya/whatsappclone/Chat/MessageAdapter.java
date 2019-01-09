package com.example.dhruvupadhyaya.whatsappclone.Chat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dhruvupadhyaya.whatsappclone.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    ArrayList<MessageObject> messageList;

    public MessageAdapter(ArrayList<MessageObject> messageList){
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        MessageViewHolder rcv = new MessageViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int i) {

        messageViewHolder.mMessage.setText(messageList.get(i).getMessage());
        messageViewHolder.mSender.setText(messageList.get(i).getSenderId());

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }




     class MessageViewHolder extends RecyclerView.ViewHolder{


        TextView mMessage,
                 mSender;
       // LinearLayout mLayout;

         MessageViewHolder(View view){
            super(view);
            // mLayout = view.findViewById(R.id.layout);
             mMessage = view.findViewById(R.id.message);
             mSender = view.findViewById(R.id.sender);


        }
    }
}
