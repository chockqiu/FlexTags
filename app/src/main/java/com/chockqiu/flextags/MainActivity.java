package com.chockqiu.flextags;

import android.content.Context;
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

    private Context mContext = this;
    private FlexTags.Adapter mAdapter;
    private ArrayList<String> tags = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private Random mRandom = new Random();

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

    private static final List<String> TEXT_POOL = new ArrayList<>();

    static {
        TEXT_POOL.add("中国农民丰收节");
        TEXT_POOL.add("热心肠的杨迪");
        TEXT_POOL.add("SHE");
        TEXT_POOL.add("易烊千玺");
        TEXT_POOL.add("爸爸去哪儿的孩子们都长大了");
        TEXT_POOL.add("罗晋");
        TEXT_POOL.add("鹿晗");
        TEXT_POOL.add("丁泽仁");
        TEXT_POOL.add("大张伟");
        TEXT_POOL.add("李易峰");
        TEXT_POOL.add("许魏洲");
        TEXT_POOL.add("吴磊");
        TEXT_POOL.add("ZZ");
        TEXT_POOL.add("XX");
        TEXT_POOL.add("YY");
        TEXT_POOL.add("520");
        TEXT_POOL.add("1314");
        TEXT_POOL.add("666");
        TEXT_POOL.add("劫");
        TEXT_POOL.add("肖战");
        TEXT_POOL.add("马东");
        TEXT_POOL.add("今日秋分");
        TEXT_POOL.add("马冬梅");
        TEXT_POOL.add("让亚洲象有家可回");
        TEXT_POOL.add("阳光帅气新生");
        TEXT_POOL.add("英俊帅气的实力派演员");
        TEXT_POOL.add("有时候会出现一段非常长非常长非常长非常长非常长非常长的文字, 这时候改如何显示呢?");
    }
}