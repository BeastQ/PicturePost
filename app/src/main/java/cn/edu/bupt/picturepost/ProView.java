package cn.edu.bupt.picturepost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/**
 * Created by BeastQ on 2016/5/19.
 * 此类是拍照时预览自定义view的实现
 */
public class ProView extends TextureView{
    private int mRatioWidth = 0;
    private int mRatioHeight = 0;

    public ProView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void setAspectRatio(int width, int height)
    {
        mRatioWidth = width;
        mRatioHeight = height;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (0 == mRatioWidth || 0 == mRatioHeight)
        {
            setMeasuredDimension(width, height);
        }
        else
        {
            if (width < height * mRatioWidth / mRatioHeight)
            {
                setMeasuredDimension(width, width * mRatioHeight / mRatioWidth);
            }
            else
            {
                setMeasuredDimension(height * mRatioWidth / mRatioHeight, height);
            }
        }
    }
}
