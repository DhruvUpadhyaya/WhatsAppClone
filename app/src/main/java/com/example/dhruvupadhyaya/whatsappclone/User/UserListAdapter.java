package com.example.dhruvupadhyaya.whatsappclone.User;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dhruvupadhyaya.whatsappclone.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder> {

    ArrayList<UserObject> userList;

    public UserListAdapter(ArrayList<UserObject> userList){
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        UserListViewHolder rcv = new UserListViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull final UserListViewHolder userListViewHolder, final int i) {

        userListViewHolder.mName.setText(userList.get(i).getName());
        userListViewHolder.mPhone.setText(userList.get(i).getPhone());

        // Creating chat
        userListViewHolder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createChat(userListViewHolder.getAdapterPosition());




            }
        });

    }

    private void createChat(int i){
        String key = FirebaseDatabase.getInstance().getReference().child("chat").push().getKey();


        HashMap newChatMap = new HashMap();
        newChatMap.put("id",key);
        newChatMap.put("users/"+FirebaseAuth.getInstance().getUid(),true);
        newChatMap.put("users/"+userList.get(i).getUid(),true);

        DatabaseReference chatInfoDb = FirebaseDatabase.getInstance().getReference().child("chat").child(key).child("info");
        chatInfoDb.updateChildren(newChatMap);



        DatabaseReference mUserDb = FirebaseDatabase.getInstance().getReference().child("user");
        mUserDb.child(FirebaseAuth.getInstance().getUid()).child("chat").child(key).setValue(true);
        mUserDb.child(userList.get(i).getUid()).child("chat").child(key).setValue(true);
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }




    public class UserListViewHolder extends RecyclerView.ViewHolder{

        public TextView mName,mPhone;
        public LinearLayout mLayout;
        public UserListViewHolder(View view){
            super(view);

            mName = view.findViewById(R.id.name);
            mPhone = view.findViewById(R.id.phone);
            mLayout = view.findViewById(R.id.layout);
        }
    }
}
