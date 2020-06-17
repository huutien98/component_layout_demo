package com.vncoder.demo_layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.vncoder.demo_layout.Adapter.AdapterItem;
import com.vncoder.demo_layout.Item.Item;
import com.vncoder.demo_layout.Remote.IMenuRequest;
import com.vncoder.demo_layout.Helper.Common;
import com.vncoder.demo_layout.Helper.RecyclerItemTouchHelper;
import com.vncoder.demo_layout.Helper.RecyclerItemTouchHelperListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainItem extends AppCompatActivity implements RecyclerItemTouchHelperListener {

    private final String URL_API = "https://api.androidhive.info/json/menu.json";
    private RecyclerView recyclerView;
    private List<Item> itemList;
    private AdapterItem adapterItem;
    private CoordinatorLayout coordinator;


   public IMenuRequest mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        coordinator = findViewById(R.id.coordinator);
        mService = Common.getIMenuRequest();

        recyclerView = findViewById(R.id.recycle_view);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("EDMT Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        itemList = new ArrayList<>();
        adapterItem = new AdapterItem(itemList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapterItem);

        ItemTouchHelper.SimpleCallback simpleCallback
                = new RecyclerItemTouchHelper(0,ItemTouchHelper.LEFT,this);

        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerView);

        addItemToCard();
    }

    private void addItemToCard(){
        mService.getMenuList(URL_API)
                .enqueue(new Callback<List<Item>>() {
                    @Override
                    public void onResponse(Call<List<Item>> call,Response<List<Item>> response) {
                        itemList.clear();
                        itemList.addAll(response.body());
                        adapterItem.notifyDataSetChanged();
                    }
                    @Override
                    public void onFailure(Call<List<Item>> call, Throwable t) {
                    }
                });
    }
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof AdapterItem.ViewHolder){
            String name = itemList.get(viewHolder.getAdapterPosition()).getName();

            final Item deleteditem = itemList.get(viewHolder.getAdapterPosition());
            final int deleteindex = viewHolder.getAdapterPosition();
            adapterItem.removeItem(deleteindex);

            Snackbar snackbar = Snackbar.make(coordinator,name+"đã xóa khỏi list",Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapterItem.restoreItem(deleteditem,deleteindex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }
    }
}