package com.example.myapplication;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.myapplication.Model.Change;
import com.example.myapplication.view.MainActivity2;
import com.example.myapplication.view.details;
import com.google.gson.Gson;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Change> values;
    private Object item;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtName;
        public TextView txtHobby;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtName = (TextView) v.findViewById(R.id.firstLine);
            txtHobby = (TextView) v.findViewById(R.id.secondLine);
        }

        public void bind(ContentItem contentItem, AdapterView.OnItemClickListener listener) {
        }
    }

    public void add(int position, Change item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Change> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Change name = values.get(position);
        holder.txtName.setText(name.getSubject());
        holder.txtName.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context= v.getContext();

                Intent intent = new Intent(context, details.class);
                Gson gson = new Gson();
                intent.putExtra("change_key" ,gson.toJson(item));
                context.startActivity(intent);
            }
        });

        holder.txtHobby.setText("Footer: " + name);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}
