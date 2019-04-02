package com.example.myapplication;

import android.content.Context;
import android.net.sip.SipSession;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class ContentItem {
   ;
    private List<ContentItem> items;
    private AdapterView.OnItemClickListener listener;

    ContentItem(List<ContentItem> items, AdapterView.OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;



    }
}
