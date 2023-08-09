package com.example.myfragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {


    private List<ItemApi> itemList;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public ItemAdapter(List<ItemApi> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemApi itemApi = itemList.get(position);
        holder.titleTextView.setText(itemApi.getName());
        holder.descriptionTextView.setText(itemApi.getUrl());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewMarca);
            descriptionTextView = itemView.findViewById(R.id.textViewModeo);
        }

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.textViewMarca);
            descriptionTextView = itemView.findViewById(R.id.textViewModeo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

    }
}
