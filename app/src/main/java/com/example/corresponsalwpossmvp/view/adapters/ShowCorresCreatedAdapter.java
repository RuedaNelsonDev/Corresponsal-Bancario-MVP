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
import com.example.corresponsalwpossmvp.model.models.Correspondent;
import com.example.corresponsalwpossmvp.view.ViewInterface;

import java.util.ArrayList;

public class ShowCorresCreatedAdapter extends RecyclerView.Adapter<ShowCorresCreatedAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Correspondent> listCorrespondent;
    private ViewInterface view;

    public ShowCorresCreatedAdapter(Context context, ArrayList<Correspondent> listCorrespondent, ViewInterface view) {
        this.context = context;
        this.listCorrespondent = listCorrespondent;
        this.view = view;
    }

    @NonNull
    @Override
    public ShowCorresCreatedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_show_createds, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowCorresCreatedAdapter.MyViewHolder holder, int position) {
        Correspondent correspondent = listCorrespondent.get(position);


        holder.tvShowCorresId.setText(String.valueOf(correspondent.getId()));
        holder.tvShowCorresName.setText(String.valueOf(correspondent.getName()));
        holder.tvShowCorresLastName.setText(String.valueOf(correspondent.getLastName()));
        holder.tvShowCorresIdentification.setText(String.valueOf(correspondent.getIdentification()));
        holder.tvShowCorresBalance.setText(String.valueOf("$ " + correspondent.getBalance()));
        holder.tvShowCorresStatus.setText(String.valueOf(correspondent.getStatus()));
        holder.linearShowCorres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.showCorresStatus(correspondent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCorrespondent.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvShowCorresId;
        TextView tvShowCorresName;
        TextView tvShowCorresLastName;
        TextView tvShowCorresIdentification;
        TextView tvShowCorresBalance;
        TextView tvShowCorresStatus;

        LinearLayout linearShowCorres;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvShowCorresId = itemView.findViewById(R.id.tvShowId);
            tvShowCorresName = itemView.findViewById(R.id.tvShowName);
            tvShowCorresLastName = itemView.findViewById(R.id.tvShowLastName);
            tvShowCorresIdentification = itemView.findViewById(R.id.tvShowIndentification);
            tvShowCorresBalance = itemView.findViewById(R.id.tvShowBalance);
            tvShowCorresStatus = itemView.findViewById(R.id.tvShowStatus);
            linearShowCorres = itemView.findViewById(R.id.linearCreateds);
        }
    }
}
