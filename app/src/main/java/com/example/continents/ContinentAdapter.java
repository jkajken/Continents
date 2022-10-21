package com.example.continents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.continents.databinding.ContinentItemBinding;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder> {

    private ArrayList<Continent> continentList;
    private RecyclerViewInterface recyclerViewInterface;

    public ContinentAdapter(ArrayList<Continent> continentList, RecyclerViewInterface recyclerViewInterface) {
        this.continentList = continentList;
        this.recyclerViewInterface = recyclerViewInterface;
    }


    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder(ContinentItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, int position) {
        holder.bind(continentList.get(position ));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerViewInterface.onItemClick(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return continentList.size();
    }

    public Continent getCountry(int position) {
        return continentList.get(position);
    }


    class ContinentViewHolder extends RecyclerView.ViewHolder {

        private ContinentItemBinding binding;

        public ContinentViewHolder(@NonNull ContinentItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
        public void bind(Continent continent){
            binding.continentTextView.setText(continent.getName());
            binding.continentImg.setImageResource(continent.getShapeImg());

            }
    }
}
