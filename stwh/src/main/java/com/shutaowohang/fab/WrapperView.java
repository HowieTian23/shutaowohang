package com.shutaowohang.fab;

/**
 * Created by 78421 on 2016/11/27.
 */



import android.view.View;

/**
 * Created by liuzipeng on 16/5/1.
 */
public class WrapperView {
    private FabTagLayout mTarget;

    public WrapperView(FabTagLayout mTarget) {
        this.mTarget = mTarget;
    }

    public int getWidth() {
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width) {
        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }

    public int getHeight() {
        return mTarget.getLayoutParams().height;
    }

    public void setHeight(int height) {
        mTarget.getLayoutParams().height = height;
        mTarget.requestLayout();
    }
}
