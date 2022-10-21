package com.example.continents;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.continents.databinding.ContinentItemBinding;
import com.example.continents.databinding.FragmentContinentBinding;

import java.util.ArrayList;


public class ContinentFragment extends Fragment implements RecyclerViewInterface {
    private FragmentContinentBinding binding;
    private ArrayList<Continent> continentList = new ArrayList<>();
    private ContinentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter = new ContinentAdapter(continentList, this);
        binding.continentRv.setAdapter(adapter);


    }

    private void loadData() {
        continentList.add(new Continent("AFRICA", R.drawable.africa));
        continentList.add(new Continent("ASIA", R.drawable.asia));
        continentList.add(new Continent("EUROPE", R.drawable.europe));
        continentList.add(new Continent("OCEANIA", R.drawable.ociania));
        continentList.add(new Continent("NORTH AMERICA", R.drawable.northamerica));
        continentList.add(new Continent("SOUTH AMERICA", R.drawable.southaamerica));


    }

    @Override
    public void onItemClick(int position) {

        CountryFragment countryFragment = new CountryFragment();
        Continent continent = adapter.getCountry(position);
        Bundle bundle = new Bundle();
        bundle.putString("key",continent.getName());
        Fragment fragment = new CountryFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Container, countryFragment).addToBackStack(null).commit();
    }
}