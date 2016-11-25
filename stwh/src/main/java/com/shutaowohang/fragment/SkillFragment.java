package com.shutaowohang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shutaowohang.R;

/**
 *
 * Created by saltwind on 2016/11/15.
 */

public class SkillFragment extends Fragment {
    private View convertView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        convertView=inflater.inflate(R.layout.fragment_skill,container,false);
        return convertView;
    }
}
