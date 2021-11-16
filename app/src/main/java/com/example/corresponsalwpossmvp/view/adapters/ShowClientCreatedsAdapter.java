package com.example.corresponsalwpossmvp.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corresponsalwpossmvp.R;
import com.example.corresponsalwpossmvp.model.models.Client;
import com.example.corresponsalwpossmvp.view.ViewInterface;

import java.util.ArrayList;

public class ShowClientCreatedsAdapter extends RecyclerView.Adapter<ShowClientCreatedsAdapter.MyViewHolder> {
    Context context;
    private ArrayList<Client> listClient;
    private ViewInterface view;

    public ShowClientCreatedsAdapter(Context context, ArrayList<Client> listClient, ViewInterface view) {
        this.context = context;
        this.listClient = listClient;
        this.view = view;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_show_createds, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Client client = listClient.get(position);

        holder.tvShowClientId.setText(String.valueOf(client.getId()));
        holder.tvShowClientName.setText(String.valueOf(client.getName()));
        holder.tvShowClientLastName.setText(String.valueOf(client.getLastName()));
        holder.tvShowClientIdentification.setText(String.valueOf(client.getIdentification()));
        holder.tvShowClientBalance.setText(String.valueOf("$" + client.getBalance()));
        holder.tvShowClientStatus.setText(String.valueOf(client.getStatus()));
        holder.linearShowClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.showClientStatus(client);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listClient.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvShowClientId;
        TextView tvShowClientName;
        TextView tvShowClientLastName;
        TextView tvShowClientIdentification;
        TextView tvShowClientBalance;
        TextView tvShowClientStatus;

        LinearLayout linearShowClient;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvShowClientId = itemView.findViewById(R.id.tvShowId);
            tvShowClientName = itemView.findViewById(R.id.tvShowName);
            tvShowClientLastName = itemView.findViewById(R.id.tvShowLastName);
            tvShowClientIdentification = itemView.findViewById(R.id.tvShowIndentification);
            tvShowClientBalance = itemView.findViewById(R.id.tvShowBalance);
            tvShowClientStatus = itemView.findViewById(R.id.tvShowStatus);
            linearShowClient = itemView.findViewById(R.id.linearCreateds);
        }
    }
}
