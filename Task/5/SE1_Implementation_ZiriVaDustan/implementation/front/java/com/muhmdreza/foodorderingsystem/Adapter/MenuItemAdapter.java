package com.muhmdreza.foodorderingsystem.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.muhmdreza.foodorderingsystem.CustomListViewDialog;
import com.muhmdreza.foodorderingsystem.Models.CommentItem;
import com.muhmdreza.foodorderingsystem.Models.MenuItem;
import com.muhmdreza.foodorderingsystem.Models.Order;
import com.muhmdreza.foodorderingsystem.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.FoodItemViewHolder> {
    private Context context;
    private List<MenuItem> menuItemList;
    private Order order;

    public MenuItemAdapter(Context context, List<MenuItem> menuItemList, String username ) {
        this.context = context;
        this.menuItemList = menuItemList;
        this.order = new Order();
        order.setId(username);
    }

    @NonNull
    @Override
    public FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodItemViewHolder(LayoutInflater.from(this.context).inflate(R.layout.menu_item, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final FoodItemViewHolder holder, int position) {
        final MenuItem menuItem = menuItemList.get(position);
        Picasso.with(context).load(menuItem.getImageUrl()).into(holder.imageView);
        holder.name.setText(menuItem.getName());
        holder.price.setText(menuItem.getPrice());
        holder.description.setText(menuItem.getDescription());
        holder.count.setText(order.getCount(menuItem) + "");
        holder.addMenuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order.addFood(menuItem);
                holder.count.setText(order.getCount(menuItem) + "");
            }
        });
        holder.removeMenuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order.removeFood(menuItem);
                holder.count.setText(order.getCount(menuItem) + "");
            }
        });

        holder.commentItems = menuItem.getCommentItems();
        holder.commentImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomListViewDialog dialog = new CustomListViewDialog(context, new CommentAdapter(context, menuItem.getCommentItems()));
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }

    public Map<MenuItem, Integer> getOrder() {
        return this.order.getMenuItems();
    }

    class FoodItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, addMenuItem, removeMenuItem, commentImageView;
        TextView name, description, price, count;
        List<CommentItem> commentItems;

        FoodItemViewHolder(View itemView) {
            super(itemView);
            count = itemView.findViewById(R.id.txt_menuItem_count);
            commentImageView = itemView.findViewById(R.id.img_menuItem_comment);
            addMenuItem = itemView.findViewById(R.id.img_menuItem_add);
            removeMenuItem = itemView.findViewById(R.id.img_menuItem_remove);
            imageView = itemView.findViewById(R.id.img_menu_item_image);
            name = itemView.findViewById(R.id.txt_menuItem_name);
            description = itemView.findViewById(R.id.txt_menuItem_description);
            price = itemView.findViewById(R.id.txt_menuItem_price);
        }
    }
}
