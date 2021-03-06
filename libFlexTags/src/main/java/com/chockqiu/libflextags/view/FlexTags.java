package com.chockqiu.libflextags.view;

import android.content.Context;
import android.database.Observable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.flexbox.FlexboxLayout;

/**
 * @author Administrator
 */
public class FlexTags extends FlexboxLayout {

    public FlexTags(Context context) {
        super(context);
    }

    public FlexTags(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlexTags(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private final AdapterDataObserver mAdapterDataObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            post(() -> {
                if (mAdapter != null) {
                    removeAllViews();
                    int total = mAdapter.getItemCount();
                    for (int position = 0; position < total; position++) {
                        View v = mAdapter.onCreateView(FlexTags.this);
                        mAdapter.onBindView(v, position);
                        addView(v);
                    }
                }
            });
        }
    };
    private Adapter mAdapter;

    public Adapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(Adapter mAdapter) {
        if (mAdapter == null) {
            if (this.mAdapter != null) {
                this.mAdapter.mAdapterDataObservable.unregisterAll();
                this.mAdapter = null;
            }
            removeAllViews();
        } else {
            if (this.mAdapter == mAdapter) {
                this.mAdapter.notifyDataSetChanged();
                return;
            }
            this.mAdapter = mAdapter;
            this.mAdapter.mAdapterDataObservable.registerObserver(mAdapterDataObserver);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public abstract static class Adapter {
        private final AdapterDataObservable mAdapterDataObservable = new AdapterDataObservable();

        /**
         * ?????????????????????
         *
         * @param parent ?????????
         * @return ???????????????
         */
        public abstract View onCreateView(ViewGroup parent);

        /**
         * ??????????????????
         *
         * @param v        ??????????????????
         * @param position ??????
         */
        public abstract void onBindView(View v, int position);

        /**
         * ??????????????????
         *
         * @return ??????
         */
        public abstract int getItemCount();

        /**
         * ?????????????????????
         */
        public void notifyDataSetChanged() {
            if (mAdapterDataObservable.hasObservers()) {
                mAdapterDataObservable.notifyChanged();
            }
        }
    }

    private static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public boolean hasObservers() {
            return !mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onChanged();
            }
        }
    }

    private abstract static class AdapterDataObserver {
        public abstract void onChanged();
    }
}
