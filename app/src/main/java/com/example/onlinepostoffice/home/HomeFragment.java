package com.example.onlinepostoffice.home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.onlinepostoffice.R;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private Button btnDynamicState;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        btnDynamicState=(Button) btnDynamicState.findViewById(R.id.btnDynamicState);
//        String[] dynamicState = {"关于2022年5月新飞行纪特邮票预售安排的公告",
//                "4月上新日【江山邮画】",
//                "关于调整《中墨建交五十周年》邮票预售自提相关时限",
//                "4月优选日【邮古说今】",
//                "中国古典文学名著--《红楼梦》（全张邮票折）摇号",
//                "关于2022年4月新发型纪特邮票预售安排的公告"};
//        btnDynamicState.setText(dynamicState[0]);
//    }
}