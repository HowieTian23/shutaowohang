package com.shutaowohang.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shutaowohang.R;
import com.shutaowohang.adapter.MyAdapter;
import com.shutaowohang.fab.FabTagLayout;
import com.shutaowohang.fab.FloatingActionButtonPlus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by saltwind on 2016/11/15.
 */

public class KnowledgeFragment extends Fragment {

    private List<String> mList;
    private RecyclerView mRecyclerView;
    private FloatingActionButtonPlus mActionButtonPlus;
    private LayoutInflater Knowledgeinflater;
    private View convertView;
    private Activity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        convertView=inflater.inflate(R.layout.test,container,false);
        Knowledgeinflater=inflater;
        activity=getActivity();
        init();
        events();
        return convertView;
    }

    private void events() {
        mActionButtonPlus.setOnItemClickListener(new FloatingActionButtonPlus.OnItemClickListener() {
            @Override
            public void onItemClick(FabTagLayout tagView, int position) {
                Toast.makeText(activity, ""+position, Toast.LENGTH_SHORT).show();
            }
        });

//        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                if (recyclerView.getScrollState() == RecyclerView.SCROLL_STATE_DRAGGING) {
//                    if (dy > 0) {
//                        mActionButtonPlus.hideFab();
//                    } else {
//                        mActionButtonPlus.showFab();
//                    }
//                }
//            }
//        });
    }

    private void init() {
        mList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            mList.add("this is item" + i);
        }

        mRecyclerView= (RecyclerView) convertView.findViewById(R.id.list);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new MyAdapter(Knowledgeinflater, mList));
        mActionButtonPlus = (FloatingActionButtonPlus) convertView.findViewById(R.id.FabPlus);
//        mActionButtonPlus.setContentIcon(getResources().getDrawable(R.mipmap.ic_get_app_white_48dp)); //设置主Fab的icon图标
//        mActionButtonPlus.setRotateValues(45); //设置主Fab被点击时旋转的度数，默认为45度
//        boolean state = mActionButtonPlus.getSwitchFabDisplayState();  //获取当前Fab的显示状态，显示时返回true，隐藏返回false
    }

}
