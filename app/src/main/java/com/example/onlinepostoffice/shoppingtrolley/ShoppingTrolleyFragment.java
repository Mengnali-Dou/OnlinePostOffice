package com.example.onlinepostoffice.shoppingtrolley;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlinepostoffice.R;

public class ShoppingTrolleyFragment extends Fragment {

    private ShoppingTrolleyViewModel mViewModel;

    public static ShoppingTrolleyFragment newInstance() {
        return new ShoppingTrolleyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.shopping_trolley_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ShoppingTrolleyViewModel.class);
        // TODO: Use the ViewModel
    }

}