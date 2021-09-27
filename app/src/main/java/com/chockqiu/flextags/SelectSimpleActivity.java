package com.chockqiu.flextags;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chockqiu.flextags.been.SelectBeen;
import com.chockqiu.libflextags.view.FlexTags;

import java.util.ArrayList;

public class SelectSimpleActivity extends AppCompatActivity {

    private final Context mContext = this;
    private FlexTags.Adapter mAdapter;
    private final ArrayList<SelectBeen> tags = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_simple);
        initView();
    }

    private void initView() {
        SelectBeen mSelectBeen = new SelectBeen();
        mSelectBeen.setText("军事");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("实事");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("明星");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("搞笑");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("同城");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("美女");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("帅哥");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("宠物");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("生活");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("旅游");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("二次元");
        tags.add(mSelectBeen);
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
                SelectBeen been = tags.get(position);
                if (been.isSelected()) {
                    tv.setBackgroundResource(R.drawable.shape_16dp_f5f7fa_selected);
                } else {
                    tv.setBackgroundResource(R.drawable.shape_16dp_f5f7fa);
                }
                tv.setText(been.getText());
                tv.setOnClickListener(v1 -> {
                            been.setSelected(!been.isSelected());
                            mAdapter.notifyDataSetChanged();
                        }
                );
            }

            @Override
            public int getItemCount() {
                return tags.size();
            }
        };
        mFlexTags.setAdapter(mAdapter);
    }
}
