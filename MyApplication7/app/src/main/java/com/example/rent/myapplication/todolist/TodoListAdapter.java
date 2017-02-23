package com.example.rent.myapplication.todolist;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.rent.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-02-22.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.MyViewHolder> {

    private List<ToDoListItem> items = new ArrayList<>();
    private OnItemCheckStateChanged checkListener;

    public void setCheckListener(OnItemCheckStateChanged checkListener) {
        this.checkListener = checkListener;
    }

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

        final ToDoListItem listItem = items.get(position);

        holder.textView.setText(items.get(position).getText());
        holder.checkBox.setChecked(listItem.isChecked());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listItem.setChecked(isChecked);
                if (checkListener != null) {
                    checkListener.OnItemCheckStateChanged(getCheckedItemsCount());
                }
            }
        });
    }

    private int getCheckedItemsCount() {
        int count = 0;
        for (ToDoListItem item : items) {
            if (item.isChecked()) {
                count++;
            }
        }
        return count;
    }

    public void addItem(String item) {
        items.add(new ToDoListItem(item));
        notifyDataSetChanged();
    }

    public void deleteAllCheckedItems() {
        List<ToDoListItem> newListItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (!items.get(i).isChecked()) {
                newListItems.add(items.get(i));

            }

        }
        items = newListItems;
        notifyDataSetChanged();
        if (checkListener != null) {
            checkListener.OnItemCheckStateChanged(getCheckedItemsCount());
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        CheckBox checkBox;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.itemText);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }

}
