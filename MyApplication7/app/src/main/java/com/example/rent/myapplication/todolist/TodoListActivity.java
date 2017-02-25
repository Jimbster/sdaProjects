package com.example.rent.myapplication.todolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rent.myapplication.R;

/**
 * Created by RENT on 2017-02-22.
 */

public class TodoListActivity extends AppCompatActivity implements OnItemCheckStateChanged {

    private TodoListAdapter todoListAdapter;
    private String activityTitle;
    private ActionMode actionMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todoactivity);
        activityTitle = getSupportActionBar().getTitle().toString();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        todoListAdapter = new TodoListAdapter();
        todoListAdapter.setCheckListener(this);
        recyclerView.setAdapter(todoListAdapter);

        final EditText editText = (EditText) findViewById(R.id.todoedittext);

        Button addButton = (Button) findViewById(R.id.addbutton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoListAdapter.addItem(editText.getText().toString());
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.todolistmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.delete_item) {
//            todoListAdapter.deleteAllCheckedItems();
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void OnItemCheckStateChanged(int checkedItemsCount) {
        if (checkedItemsCount > 0) {
            createActionMode();
            actionMode.setTitle("Checked items" + checkedItemsCount);

        } else {
            if (actionMode != null) {
                actionMode.finish();
            }
        }

        getSupportActionBar().setTitle(activityTitle);


    }


    private void createActionMode() {
        actionMode = startSupportActionMode(new ActionMode.Callback() {

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.todolistactionmenu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {


                    if (item.getItemId() == R.id.action_delete) {
                        todoListAdapter.deleteAllCheckedItems();
                        return true;
                    }
                    return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}
