package com.example.continents;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.continents.databinding.FragmentCountryBinding;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

public class CountryFragment extends Fragment implements RecyclerViewInterface {
    private FragmentCountryBinding binding;
    private ArrayList<Continent> countryList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCountryBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String countryName = getArguments().getString("key");
        loadData(countryName);
        if (getArguments() != null) {
            ContinentAdapter adapter = new ContinentAdapter(countryList, this::onItemClick);
            binding.countryRV.setAdapter(adapter);
        }
    }

    private void loadData(String countryName) {
        if (countryName == "AFRICA") {
            countryList.add(new Continent("Tunisia", R.drawable.tunisia));
            countryList.add(new Continent("Uganda", R.drawable.uganda));
            countryList.add(new Continent("Zimbabwe", R.drawable.zimbabwe));
            countryList.add(new Continent("Kenya", R.drawable.kenya));
            countryList.add(new Continent("Morocco", R.drawable.morocco));

        }
        if (countryName == "ASIA") {
            countryList.add(new Continent("Kyrgyzstan", R.drawable.kyrgyzstan));
            countryList.add(new Continent("Korea", R.drawable.korea));
            countryList.add(new Continent("Japan", R.drawable.japan));
            countryList.add(new Continent("Uzbekistan", R.drawable.uzbekistan));
            countryList.add(new Continent("Philippines", R.drawable.philippines));
        }
        if (countryName == "EUROPE") {
            countryList.add(new Continent("Deutchland", R.drawable.deutchland));
            countryList.add(new Continent("France", R.drawable.france));
            countryList.add(new Continent("Greese", R.drawable.greese));
            countryList.add(new Continent("Italy", R.drawable.italy));
            countryList.add(new Continent("Netherlands", R.drawable.netherlamds));
        }
        if (countryName == "OCEANIA") {
            countryList.add(new Continent("Australia", R.drawable.australia));
            countryList.add(new Continent("Fiji", R.drawable.fiji));
            countryList.add(new Continent("Vanuatu", R.drawable.vanuatu));
            countryList.add(new Continent("Nauru", R.drawable.nauru));
            countryList.add(new Continent("New Zealand", R.drawable.newzealand));
        }
        if (countryName == "NORTH AMERICA") {
            countryList.add(new Continent("Canada", R.drawable.canada));
            countryList.add(new Continent("Cuba", R.drawable.cuba));
            countryList.add(new Continent("Grenada", R.drawable.grenada));
            countryList.add(new Continent("Jamaica", R.drawable.janaika));
            countryList.add(new Continent("Mexico", R.drawable.mexico));
        }
        if (countryName == "SOUTH AMERICA") {
            countryList.add(new Continent("Brazil", R.drawable.bdazil));
            countryList.add(new Continent("Colombia", R.drawable.colombia));
            countryList.add(new Continent("Ecuador", R.drawable.ecuador));
            countryList.add(new Continent("Peru", R.drawable.peru));
            countryList.add(new Continent("Argentina", R.drawable.argentina));
        }
    }

    @Override
    public void onItemClick(int position) {

    }
}
