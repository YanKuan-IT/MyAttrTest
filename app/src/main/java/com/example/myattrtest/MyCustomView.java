package com.example.myattrtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyCustomView extends View {
    private static final String TAG = "MyCustomViewTag";

    Paint paint;
    String mText;
    int mColor;
    int mSize;
    String mAttr1;

    public MyCustomView(Context context) {
//        super(context);
        this(context, null);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs,0);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyDefStyle);

        mText = typedArray.getString(R.styleable.MyDefStyle_android_text);
        mColor = typedArray.getColor(R.styleable.MyDefStyle_mTextColor, Color.BLACK);
        mSize = typedArray.getDimensionPixelSize(R.styleable.MyDefStyle_mTextSize, 30);
        mAttr1 = typedArray.getString(R.styleable.MyDefStyle_attr1);

        typedArray.recycle();

        Log.d(TAG, "MyCustomView: mText:" + mText
                + ", mColor:" + mColor
                + ", mSize:" + mSize
                + ", mAttr1:" + mAttr1
        );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint = new Paint();
        paint.setTextSize(mSize);
        paint.setColor(mColor);

        float x = 0;
        float baseLine = 100;
        canvas.drawText(mText, x, baseLine, paint);
    }
}