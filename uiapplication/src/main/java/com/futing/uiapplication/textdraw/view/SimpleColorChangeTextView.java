package com.futing.uiapplication.textdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatTextView;

public class SimpleColorChangeTextView extends AppCompatTextView {

    private String mText = "【享学课堂】";//成员变量

    private float mPercent = 0.0f;

    public float getPercent() {
        return mPercent;
    }

    public void setPercent(float mPercent) {
        this.mPercent = mPercent;
        invalidate();//重绘
    }

    public SimpleColorChangeTextView(Context context) {
        super(context);
    }

    public SimpleColorChangeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleColorChangeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制文字 笔画多大有Paint决定的
        Paint paint = new Paint();
        paint.setTextSize(80);
        float baseline = 100;
        canvas.drawText(mText, baseline, baseline, paint);

        drawCenterLineX(canvas);
        float x = getWidth() / 2;

        //默认LEFT (整个文字在线y线 | 的左边  )
        canvas.drawText(mText, x, baseline, paint);
        //1. 设置文字对齐 (整个文字在 线y线 | 的左边和右边各占一半  )
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(mText, x, baseline + paint.getFontSpacing(), paint);
        //RIGHT (整个文字在线y线 | 的右边边  )
        paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(mText, x, baseline + paint.getFontSpacing() * 2, paint);

        drawCenterLineY(canvas);
        //把文字绘制到view的中心
        //文字高度的计算

//        public float ascent;
//        public float bottom;
//        public float descent;
//        public float leading;
//        public float top; 从baseline到文字最顶端的尺寸


        //第二种方式 x种居中
        //底层 黑色
        drawCenterText(canvas);
        //上面一层 红色
        drawCenterText1(canvas);


    }

    private void drawCenterText(final Canvas canvas) {
        //反面教程 ——不要onDraw在里面new
        canvas.save();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        //一般要加     paint.setAntiAlias(true); 否则在低版本有问题；
        paint.setAntiAlias(true);
        paint.setTextSize(80);
        float width = paint.measureText(mText);
        paint.setTextAlign(Paint.Align.LEFT);
        float left = getWidth() / 2 - width / 2;
        //优化 避免过度绘制；
        float left_x = left + width * mPercent;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float baseline = getHeight() / 2 - (fontMetrics.descent + fontMetrics.ascent) / 2;
        Rect rect = new Rect((int) left_x, 0, getWidth(), getHeight());
        canvas.clipRect(rect);
        canvas.drawText(mText, left, baseline, paint);
        canvas.restore();
    }

    //文字居中计算
    private void drawCenterText1(final Canvas canvas) {
        canvas.save();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setTextSize(80);
        float width = paint.measureText(mText);
        paint.setTextAlign(Paint.Align.LEFT);
        //y轴计算
        float left = getWidth() / 2 - width / 2;
        //渐变百分比 mPercent  文字宽度x百分比
        float right = left + width * mPercent;
        //文字高度的计算 getFontMetrics  这是推到出来的getHeight()/2 -  (fontMetrics.descent + fontMetrics.ascent)/2;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
//        float baseline = getHeight()/2;
//        19.53125:::::-74.21875  baseline为基线 往回走 ascent就是负的 为什么减去- fontMetrics.descent 理解的还是不够深刻

        Log.e("SimpleColorChangeTextView", fontMetrics.descent + ":::::" + fontMetrics.ascent + "");
//        x轴计算baseline计算 比较难
        float baseline = getHeight() / 2 + (fontMetrics.descent - fontMetrics.ascent) / 2 - fontMetrics.descent;
//        float baseline = getHeight()/2 - (fontMetrics.descent + fontMetrics.ascent)/2; //最终用这个是上面推导来的
        Rect rect = new Rect((int) left, 0, (int) right, getHeight());
        //画布裁剪
        canvas.clipRect(rect);
        canvas.drawText(mText, left, baseline, paint);
        canvas.restore();

    }

    //画一根x轴中间，y轴红线 |  放在中间
    private void drawCenterLineX(final Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), paint);
    }

    //画一根y轴中间，x轴蓝线 ——  放在中间
    private void drawCenterLineY(final Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(3);
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paint);
    }


}
