package com.example.dbcrud;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private ArrayList <Item> listItem;
    private Context context;
    private ItemListener itemListener;

    public ItemAdapter(ArrayList<Item>listItem,Context context,ItemListener itemListener){
        this.listItem =listItem;
        this.context = context;
        this.itemListener = itemListener;

    }

    @NonNull
    @Override
    public  ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final String name = listItem.get(position).getName();
        final String desc = listItem.get(position).getDesc();
        final Integer qty = listItem.get(position).getQty();

        holder.txtName.setText(name);
        holder.txtDesc.setText(desc);
        holder.txtQty.setText("Qty = "+ String.valueOf(qty));
        holder.imgItemMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context,holder.imgItemMenu);
                popupMenu.inflate(R.menu.menu_item);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.action_edit :
                                Intent intent = new Intent(context,ItemEditActivity.class);
                                intent.putExtra("data",listItem.get(position));
                                context.startActivity(intent);
                                Toast.makeText(context, "Edit Button", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.action_delete:
                                itemListener.deleteItem(listItem.get(position),position);
                                return true;
                            default:
                                return false;
                        }


                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgItem;
        private TextView txtName;
        private TextView txtDesc;
        private TextView txtQty;
        private ImageView imgItemMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem =itemView.findViewById(R.id.img_item);
            txtName =itemView.findViewById(R.id.txt_name);
            txtDesc =itemView.findViewById(R.id.txt_desc);
            txtQty =itemView.findViewById(R.id.txt_qty);
            imgItemMenu =itemView.findViewById(R.id.img_item_menu);
        }
    }

    public interface ItemListener{
        void deleteItem(Item item , int position);
    }
}
