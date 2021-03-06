package com.chockqiu.flextags;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chockqiu.libflextags.view.FlexTags;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final Context mContext = this;
    private FlexTags.Adapter mAdapter;
    private final ArrayList<String> tags = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private final Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        FlexTags mFlexTags = findViewById(R.id.flex_tags);
        mLayoutInflater = LayoutInflater.from(this);
        mAdapter = new FlexTags.Adapter() {

            @Override
            public View onCreateView(ViewGroup parent) {
                return mLayoutInflater.inflate(R.layout.item_search_hot_text, parent, false);
            }

            @Override
            public void onBindView(View v, int position) {
                TextView tv = v.findViewById(R.id.tv_item_text);
                tv.setText(tags.get(position));
                tv.setOnClickListener(v1 -> Toast.makeText(mContext, tags.get(position), Toast.LENGTH_SHORT).show());
            }

            @Override
            public int getItemCount() {
                return tags.size();
            }
        };
        mFlexTags.setAdapter(mAdapter);
        randomTest(null);
    }

    public void randomTest(View view) {
        int total = mRandom.nextInt(8) + 5;
        int poolSize = TEXT_POOL.size();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < total; i++) {
            set.add(TEXT_POOL.get(mRandom.nextInt(poolSize)));
        }
        tags.clear();
        tags.addAll(set);
        mAdapter.notifyDataSetChanged();
    }

    public void selectSimple(View view) {
        Intent intent = new Intent(this, SelectSimpleActivity.class);
        startActivity(intent);
    }

    public void editSimple(View view) {
        Intent intent = new Intent(this, EditSimpleActivity.class);
        startActivity(intent);
    }

    private static final List<String> TEXT_POOL = new ArrayList<>();

    static {
        TEXT_POOL.add("?????????????????????");
        TEXT_POOL.add("??????????????????");
        TEXT_POOL.add("SHE");
        TEXT_POOL.add("????????????");
        TEXT_POOL.add("???????????????????????????????????????");
        TEXT_POOL.add("??????");
        TEXT_POOL.add("??????");
        TEXT_POOL.add("?????????");
        TEXT_POOL.add("?????????");
        TEXT_POOL.add("?????????");
        TEXT_POOL.add("?????????");
        TEXT_POOL.add("??????");
        TEXT_POOL.add("ZZ");
        TEXT_POOL.add("XX");
        TEXT_POOL.add("YY");
        TEXT_POOL.add("520");
        TEXT_POOL.add("1314");
        TEXT_POOL.add("666");
        TEXT_POOL.add("???");
        TEXT_POOL.add("??????");
        TEXT_POOL.add("??????");
        TEXT_POOL.add("????????????");
        TEXT_POOL.add("?????????");
        TEXT_POOL.add("????????????????????????");
        TEXT_POOL.add("??????????????????");
        TEXT_POOL.add("??????????????????????????????");
        TEXT_POOL.add("???????????????????????????????????????????????????????????????????????????????????????, ????????????????????????????");
    }
}