package com.example.spaceplato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetailsActivity extends AppCompatActivity {
    DatabaseReference dbRef;
    ImageView img;
    TextView title;
    TextView passage;
    Button addbookmark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().hide();

        dbRef = FirebaseDatabase.getInstance().getReference("Planets").child(getIntent().getStringExtra("title"));
        String id = dbRef.push().getKey();
        img = findViewById(R.id.image1);
        title = findViewById(R.id.title);
        passage = findViewById(R.id.passage);
        addbookmark = findViewById(R.id.addbookmark);

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int id = getIntent().getIntExtra("id",0);
                img.setImageResource(id);
                title.setText(snapshot.child("name").getValue().toString());
                passage.setText(snapshot.child("data").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        addbookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference("Bookmarks")
                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .child(id)
                    .setValue(new BookmarkModel(getIntent().getStringExtra("title"),getIntent().getIntExtra("id",0)+"",id))
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Bookmark added!", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(getApplicationContext(),"Unable to process the request!",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
            }
        });
    }
}