package com.example.corresponsalwpossmvp.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.corresponsalwpossmvp.R;
import com.example.corresponsalwpossmvp.model.models.Menu;

import java.util.ArrayList;

public class MenuAdminAdapter extends RecyclerView.Adapter<MenuAdminAdapter.MyViewHolder> {
    private Context context;
    MenuClickListener menuClickListener;
    ArrayList<Menu> listMenu;


    public MenuAdminAdapter(Context context, ArrayList<Menu> listMenu, MenuClickListener menuClickListener) {
        this.context = context;
        this.listMenu= listMenu;
        this.menuClickListener = menuClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.row_menu_function, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Menu menu = listMenu.get(position);
      /*  holder.bFM.tvMenuFuncion.setText(menu.getFuncionMenu());*/
        holder.tvMenuFuncion.setText(menu.getFuncionMenu());
        Glide.with(context)
                .load(String.valueOf(menu.getImagenMenu()))
               /* .into(holder.bFM.ivMenuFuncion);*/
                .into(holder.ivMenuFuncion);
      /*  holder.bFM.linearLayoutMenu.setOnClickListener(new View.OnClickListener() {*/
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuClickListener.clickListener(menu);
            }
        });
    }

    @Override
    public int getItemCount() {
      return listMenu.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        /*FilaMenuFuncionBinding bFM;*/

        ImageView ivMenuFuncion;
        TextView tvMenuFuncion;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMenuFuncion = itemView.findViewById(R.id.ivMenuFuncion);
            tvMenuFuncion = itemView.findViewById(R.id.tvMenuFuncion);
            linearLayout = itemView.findViewById(R.id.linearLayoutMenu);
        }
    }
}
