package com.vncoder.demo_layout.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shashank.sony.fancytoastlib.FancyToast;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.vncoder.demo_layout.Item.Item;
import com.vncoder.demo_layout.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ViewHolder> {
    ArrayList<Item> listItem ;
    Context context;

    public AdapterItem(List<Item> listItem, Context context) {
        this.listItem = (ArrayList<Item>) listItem;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_item,parent,false);
        return new ViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = listItem.get(position);
        holder.name.setText(item.getName());
        holder.price.setText(item.getPrice());
        holder.description.setText(item.getDescription());
        Picasso.get()
                .load(item.getThumbnail())
                .into(holder.thumbnail);

        if (position%2==0){
            holder.name.setBackgroundColor(Color.YELLOW);
        }

        //getItemViewType(4); tìm hiểu !
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public void removeItem(int position){
        listItem.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Item item ,int position){
        listItem.add(position,item);
        notifyItemInserted(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public TextView price;
        public ImageView thumbnail;
        public RelativeLayout view_foreground;
        public RelativeLayout view_background;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            view_background = itemView.findViewById(R.id.view_background);
            view_foreground = itemView.findViewById(R.id.view_foreground);

        }
    }
}
