package com.guanaj.easyswipemenulayout;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guanaj.easyswipemenulibrary.EasySwipeMenuLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<String> listData;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIView();
        initIEvent();
        initIData();
    }


    private void initIView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(R.layout.item_rv_swipemenu, null);
        recyclerView.setAdapter(myAdapter);
        inflater = getLayoutInflater();

    }

    private void initIEvent() {
    }

    private void initIData() {
        listData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listData.add("index is =" + i);
        }
        myAdapter.addData(listData);
        myAdapter.notifyDataSetChanged();
    }


    public class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public MyAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(final BaseViewHolder helper, String item) {
            EasySwipeMenuLayout easySwipeMenuLayout = helper.getView(R.id.es);

            easySwipeMenuLayout.setListener(new EasySwipeMenuLayout.EasySwipeMenuLayoutListener() {
                @Override
                public void onRightSwipeListener() {
                    Toast.makeText(MainActivity.this, "onRightSwipeListener", Toast.LENGTH_SHORT).show();
                    Log.d("test", "test onRightSwipeListener");
                }

                @Override
                public void onLeftSwipeListener() {
                    Toast.makeText(MainActivity.this, "onLeftSwipeListener", Toast.LENGTH_SHORT).show();
                    Log.d("test", "test onLeftSwipeListener");
                }

                @Override
                public void onNoWipeListener() {
                    Toast.makeText(MainActivity.this, "onNoWipeListener", Toast.LENGTH_SHORT).show();
                    Log.d("test", "test onNoWipeListener");

                }

                @Override
                public void onActionSwipeStart() {
                    Toast.makeText(MainActivity.this, "onActionSwipeStart", Toast.LENGTH_SHORT).show();
                    Log.d("test", "test onActionSwipeStart");
                }

                @Override
                public void onActionSwipeFinish() {
                    Toast.makeText(MainActivity.this, "onActionSwipeFinish", Toast.LENGTH_SHORT).show();
                    Log.d("test", "test onActionSwipeEnd");

                }
            });

            helper.getView(R.id.right_menu_2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "收藏", Toast.LENGTH_SHORT).show();
                    EasySwipeMenuLayout easySwipeMenuLayout = helper.getView(R.id.es);

                    easySwipeMenuLayout.resetStatus();
                }
            });
            helper.getView(R.id.content).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "setOnClickListener", Toast.LENGTH_SHORT).show();

                }
            });

        }

    }
}
