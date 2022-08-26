package com.example.spaceplato;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoriesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageView mercury,venus,earth,mars,jupiter,saturn,uranus,neptune,pluto,asteroid,black_hole,hjakutake,meteor_eplosion,solar_eclipse;

    public StoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StoriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StoriesFragment newInstance(String param1, String param2) {
        StoriesFragment fragment = new StoriesFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stories, container, false);
        mercury = view.findViewById(R.id.mercury);
        mercury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id", R.drawable.mercury).putExtra("title","Mercury"));
            }
        });

        venus = view.findViewById(R.id.venus);
        venus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.venus).putExtra("title","Venus"));
            }
        });

        earth = view.findViewById(R.id.earth);
        earth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.earth).putExtra("title","Earth"));
            }
        });

        mars = view.findViewById(R.id.mars);
        mars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.mars).putExtra("title","Mars"));
            }
        });

        jupiter = view.findViewById(R.id.jupiter);
        jupiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.jupiter).putExtra("title","Jupiter"));
            }
        });

        saturn = view.findViewById(R.id.saturn);
        saturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.saturn).putExtra("title","Saturn"));
            }
        });

        uranus = view.findViewById(R.id.uranus);
        uranus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.uranus).putExtra("title","Uranus"));
            }
        });

        neptune = view.findViewById(R.id.neptune);
        neptune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.neptune).putExtra("title","Neptune"));
            }
        });

        pluto = view.findViewById(R.id.pluto);
        pluto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.pluto).putExtra("title","Pluto"));
            }
        });

        asteroid = view.findViewById(R.id.asteroid);
        asteroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.asteroid).putExtra("title","Asteroid"));
            }
        });

        black_hole = view.findViewById(R.id.black_hole);
        black_hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.black_hole).putExtra("title","Black_Hole"));
            }
        });

        hjakutake = view.findViewById(R.id.hjakutake);
        hjakutake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.hjakutake).putExtra("title","Hjakutake"));
            }
        });

        meteor_eplosion = view.findViewById(R.id.meteor_explosion);
        meteor_eplosion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.meteor_explosion).putExtra("title","Meteor_explosion"));
            }
        });

        solar_eclipse = view.findViewById(R.id.solar_eclipse);
        solar_eclipse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DetailsActivity.class).putExtra("id",R.drawable.solar_eclipse).putExtra("title","Solar_eclipse"));
            }
        });
        return view;
    }
}