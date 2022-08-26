package com.example.spaceplato;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder>{


    ArrayList<BookmarkModel> list;
    Context context;
    public static class BookmarkViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textView;
        public Button delete;
        public BookmarkViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.bkmk_img);
            textView = itemView.findViewById(R.id.bkmk_title);
            delete = itemView.findViewById(R.id.deletebtn);
        }
    }

    public BookmarkAdapter(ArrayList<BookmarkModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bookmark_item_layout, parent,false);
        return new BookmarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
        int pos = position;
        BookmarkModel model = list.get(position);
        holder.imageView.setImageResource(Integer.parseInt(model.getImage()));
        holder.textView.setText(model.getName());
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference()
                .child("Bookmarks")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child(model.getId());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef.removeValue();
                list.remove(pos);
                notifyItemRemoved(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
