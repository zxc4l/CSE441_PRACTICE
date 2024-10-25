package com.example.prac03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> countryList;
    private Context context;
    private OnItemClickListener listener;

    public CountryAdapter(Context context, List<Country> countryList, OnItemClickListener listener) {
        this.context = context;
        this.countryList = countryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.textCountryName.setText(country.getName());
        holder.imageFlag.setImageResource(country.getFlagResource());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(country));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView textCountryName;
        ImageView imageFlag;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            textCountryName = itemView.findViewById(R.id.textCountryName);
            imageFlag = itemView.findViewById(R.id.imageFlag);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Country country);
    }
}
