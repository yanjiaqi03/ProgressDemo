package ihealthlabs.progressdemo.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Xfermode;
import android.os.SystemClock;
import android.util.AttributeSet;

import ihealthlabs.progressdemo.R;
import ihealthlabs.progressdemo.utils.DensityUtil;

import static android.graphics.PorterDuff.*;
import static android.graphics.PorterDuff.Mode.*;

/**
 * Created by YanJiaqi on 15/12/14
 */
public abstract class BaseLoading extends BaseView {
    private Paint mPaint = null;
    protected float strockWidth = 0f;
    private int color = 0xffffffff;
    private RectF mArcRect = new RectF();
    private float mArcSize = 0f;
    private Xfermode Xmode;
    private float radius = 0f;
    private Shader mShader = null;
    private Matrix mGradientMatrix = new Matrix();

    public BaseLoading(Context context) {
        super(context);
        initWidgets(context);
    }

    public BaseLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWidgets(context,attrs);
    }

    private void initWidgets(Context context) {
        initWidgets(context,null);
    }

    private void initWidgets(Context context,AttributeSet attrs) {
        setHasLogic(true);
        setThreadRun(true);

        if(attrs != null){
            TypedArray a = context.obtainStyledAttributes(attrs,
                    R.styleable.BaseLoading);
            color = a.getColor(R.styleable.BaseLoading_loadingColor,0xffffffff);
            strockWidth = a.getDimension(R.styleable.BaseLoading_lineWidth,DensityUtil.dip2px(context,2f));
            a.recycle();
        }else{
            color = 0xffffffff;
            strockWidth = DensityUtil.dip2px(context,2f);
        }
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(strockWidth);
        Xmode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }

    protected abstract void drawGraph(Rect mRect, Canvas canvas, float ratioX, float ratioY,Paint paint);

    @Override
    protected void drawSub(Rect mRect, Canvas canvas, float ratioX, float ratioY) {
        if(mShader == null){
            mShader = new LinearGradient(0,mRect.height()/2*ratioY,mRect.width()*ratioX,mRect.height()/2*ratioY,
                    new int[]{
                    Color.argb(0,Color.red(color),Color.green(color),Color.blue(color)),
                    Color.argb(0,Color.red(color),Color.green(color),Color.blue(color)),color},null,Shader.TileMode.MIRROR);
        }
        mGradientMatrix.setRotate(radius, mRect.width() * ratioX / 2, mRect.height() * ratioY / 2);
        mShader.setLocalMatrix(mGradientMatrix);
        canvas.save();
        mPaint.setShader(mShader);
        mPaint.setXfermode(null);
        mPaint.setStyle(Paint.Style.STROKE);
        drawGraph(mRect, canvas, ratioX, ratioY, mPaint);
        canvas.restore();
        canvas.save();
        mPaint.setShader(null);
        mPaint.setXfermode(Xmode);
        mPaint.setStyle(Paint.Style.FILL);
        mArcSize = calculateSqrt(mRect.width() * ratioX, mRect.height() * ratioY);
        mArcRect.top = mRect.height() * ratioY / 2 - mArcSize;
        mArcRect.bottom = mRect.height() * ratioY / 2 + mArcSize;
        mArcRect.left = mRect.width() * ratioX / 2 - mArcSize;
        mArcRect.right = mRect.width() * ratioX / 2 + mArcSize;

        canvas.rotate(radius, mRect.width() * ratioX / 2, mRect.height() * ratioY / 2);
        canvas.drawArc(mArcRect, 0f, 270f, true, mPaint);
        canvas.restore();
    }

    private float calculateSqrt(float a, float b) {
        float c = 0f;

        c = (float) Math.sqrt(a * a + b * b);

        return c;
    }

    @Override
    protected void logic() {
        radius += 4;
        if (radius >= 360f) {
            radius = 0f;
        }
    }

    @Override
    protected void reset() {
        radius = 0f;
    }
}
