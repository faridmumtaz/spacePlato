package com.example.spaceplato;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class ProfileFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    DatabaseReference dbRef;
    FirebaseAuth fbAuth;
    FirebaseUser user;
    Button logout;
    EditText etName,etEmail,etPhone,etPassword;
    TextView user_name_banner,user_email_banner;

    public ProfileFragment() {
    }
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);

        fbAuth = FirebaseAuth.getInstance();
        user = fbAuth.getCurrentUser();
        dbRef = FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid());
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                etName = view.findViewById(R.id.nameedit);
                etEmail = view.findViewById(R.id.emailedit);
                etPhone = view.findViewById(R.id.phoneedit);
                etPassword = view.findViewById(R.id.passedit);
                user_name_banner = view.findViewById(R.id.user_name_banner);
                user_email_banner = view.findViewById(R.id.user_email_banner);

                etName.setText(snapshot.child("name").getValue().toString());
                etEmail.setText(snapshot.child("email").getValue().toString());
                etPhone.setText(snapshot.child("phone").getValue().toString());
                etPassword.setText(snapshot.child("password").getValue().toString());
                user_name_banner.setText(snapshot.child("name").getValue().toString().toUpperCase());
                user_email_banner.setText(snapshot.child("email").getValue().toString().toUpperCase());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        logout = view.findViewById(R.id.logoutbtn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fbAuth.signOut();
                startActivity(new Intent(getActivity(),LoginActivity.class));
            }
        });
    }
}