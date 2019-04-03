package com.example.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.Change;
import com.example.myapplication.R;
import com.google.gson.Gson;

import java.io.Console;
import java.time.Year;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class details extends AppCompatActivity {
    public TextView Owner;
    public TextView Uploader;
   // public ImageView image; //image
    public TextView Reviewers ;
    public TextView Project;
    public TextView Branch;
    public TextView Topic;
    public TextView Strategy;
    public TextView Updated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Owner = (TextView) findViewById(R.id.owner_txt);
        Uploader = (TextView) findViewById(R.id.uploader_txt);
        Reviewers = (TextView) findViewById(R.id.reviewers_txt);
        Project = (TextView) findViewById(R.id.project_txt);
        Branch = (TextView) findViewById(R.id.branch_txt);
        Topic = (TextView) findViewById(R.id.topic_txt);
        Strategy = (TextView) findViewById(R.id.strategy_txt);
        Updated = (TextView) findViewById(R.id.update_txt);


        String jsonChange = getIntent().getStringExtra("change_key");
        Gson gson = new Gson();
        Change item = gson.fromJson(jsonChange, Change.class);


        Owner.setText(item.getOwner());
        Uploader.setText(item.getUploader());
        Reviewers.setText(item.getReviewers());
        Project.setText(item.getProject());
        Branch.setText(item.getBranch());
        Topic.setText(String.valueOf(item.getTopic()));
        Strategy.setText(String.valueOf(item.getStrategy()));
        Updated.setText(item.getUpdated());

    }
}
