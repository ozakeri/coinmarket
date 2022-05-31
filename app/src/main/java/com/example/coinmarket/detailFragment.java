package com.example.coinmarket;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coinmarket.Models.cryptolistmodel.DataItem;
import com.example.coinmarket.databinding.FragmentDetailBinding;


public class detailFragment extends Fragment {

    FragmentDetailBinding fragmentDetailBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail,container,false);

        DataItem dataItem = getArguments().getParcelable("model");

        fragmentDetailBinding.bckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                requireActivity().onBackPressed();
                Navigation.findNavController(view).popBackStack();
            }
        });

        // Inflate the layout for this fragment
        return fragmentDetailBinding.getRoot();
    }
}