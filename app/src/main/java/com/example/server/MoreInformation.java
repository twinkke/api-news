package com.example.server;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class MoreInformation extends Fragment implements View.OnClickListener {
    ArticlesModel article;
    TextView textTitel;
    ImageView myImage;
    TextView bodyText;
    LinearLayout mainview;
    TextView urlLaunchar, publish;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.moreinformation, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        article = ((MainActivity)getActivity()).artical;
        textTitel = getActivity().findViewById(R.id.toolbar);
        myImage = getActivity().findViewById(R.id.imageNew);
        bodyText = getActivity().findViewById(R.id.bodyText);
        urlLaunchar = getActivity().findViewById(R.id.urlLaunchar);
        mainview = getActivity().findViewById(R.id.moreinfo);
        publish = getActivity().findViewById(R.id.published);

        mainview.setOnClickListener(this);
        urlLaunchar.setOnClickListener(this);
        viewCreator();
    }

    private void viewCreator(){
        String myText = article.getContent();
        String delimeter = "\\[";///
        String[] subStr = myText.split(delimeter);
        String body = subStr[0];

        publish.setText(article.getPublishedAt());
        textTitel.setText(article.getTitle());
        bodyText.setText(body);
        urlLaunchar.setText("See more");

        Picasso.get()
                .load(article.getUrlToImage())
                .resize(1200, 600)
                .centerCrop()
                .into(myImage);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.urlLaunchar:
                Uri uriUrl = Uri.parse(article.getUrl());
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);//////
                startActivity(launchBrowser);
                break;
            case R.id.moreinfo:
                System.out.println("main information");
                break;
        }
    }
}
