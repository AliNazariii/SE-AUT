package com.muhmdreza.foodorderingsystem;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

public class CustomListViewDialog extends Dialog {
    private RecyclerView.Adapter adapter;
    private Context context;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    public CustomListViewDialog(Context context, RecyclerView.Adapter adapter) {
        super(context);
        this.context = context;
        this.adapter = adapter;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.comment_layout);
        recyclerView =findViewById(R.id.rv_commentLayout_recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}
