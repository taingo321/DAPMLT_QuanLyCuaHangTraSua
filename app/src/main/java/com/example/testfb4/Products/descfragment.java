package com.example.testfb4.Products;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testfb4.R;

public class descfragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String name, price, ingre, purl;

    public descfragment() {

    }

    public descfragment(String name, String price, String ingre, String purl) {
        this.name = name;
        this.price = price;
        this.ingre = ingre;
        this.purl = purl;
    }


    public static descfragment newInstance(String param1, String param2) {
        descfragment fragment = new descfragment();
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

        View view =  inflater.inflate(R.layout.fragment_descfragment, container, false);

        ImageView imageholder = view.findViewById(R.id.imageholder);
        TextView nameholder = view.findViewById(R.id.nameholder);
        TextView priceholder = view.findViewById(R.id.priceholder);
        TextView ingreholder = view.findViewById(R.id.ingreholder);

        nameholder.setText(name);
        priceholder.setText(price);
        ingreholder.setText(ingre);
        Glide.with(getContext()).load(purl).into(imageholder);

        return view;
    }

    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new recfragment()).addToBackStack(null).commit();
    }
}