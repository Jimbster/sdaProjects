package com.example.rent.myapplication.todolist;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rent.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-02-22.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.MyViewHolder> {

    List<String> items = new ArrayList<>();

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(items.get(position));
    }


    public void addItem (String item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.itemText);
        }
    }

}
