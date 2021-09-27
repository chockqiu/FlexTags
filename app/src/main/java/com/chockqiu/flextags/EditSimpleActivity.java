package com.chockqiu.flextags;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chockqiu.flextags.been.SelectBeen;
import com.chockqiu.libflextags.view.FlexTags;

import java.util.ArrayList;

public class EditSimpleActivity extends AppCompatActivity {

    private final Context mContext = this;
    private FlexTags.Adapter mAdapter;
    private final ArrayList<SelectBeen> tags = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_simple);
        initView();
    }

    private void initView() {
        SelectBeen mSelectBeen = new SelectBeen();
        mSelectBeen.setText("阳光");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("幽默");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("低调");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("时尚");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("果断");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("搞怪");
        tags.add(mSelectBeen);
        mSelectBeen = new SelectBeen();
        mSelectBeen.setText("假温柔");
        tags.add(mSelectBeen);
        FlexTags mFlexTags = findViewById(R.id.flex_tags);
        mLayoutInflater = LayoutInflater.from(this);
        mAdapter = new FlexTags.Adapter() {

            @Override
            public View onCreateView(ViewGroup parent) {
                return mLayoutInflater.inflate(R.layout.item_edit_tag, parent, false);
            }

            @Override
            public void onBindView(View v, int position) {
                TextView tv = v.findViewById(R.id.tv_item_text);
                SelectBeen been = tags.get(position);
                tv.setText(been.getText());
                View vd = v.findViewById(R.id.iv_delete);
                vd.setOnClickListener(v1 -> {
                            tags.remove(been);
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
        EditText editText = findViewById(R.id.ed_add_text);
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().isEmpty()) {
                    return;
                }
                SelectBeen mSelectBeen = new SelectBeen();
                mSelectBeen.setText(editText.getText().toString());
                tags.add(mSelectBeen);
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
