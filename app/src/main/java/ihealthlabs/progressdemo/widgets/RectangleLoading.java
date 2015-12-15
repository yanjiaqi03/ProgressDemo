package ihealthlabs.progressdemo.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

import ihealthlabs.progressdemo.utils.DensityUtil;

/**
 * Created by YanJiaqi on 15/12/14
 */
public class RectangleLoading extends BaseLoading {
    private RectF mRectF = new RectF();
    private float roundRectRadius = 0f;

    public RectangleLoading(Context context) {
        super(context);
        init(context);
    }

    public RectangleLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        roundRectRadius = DensityUtil.dip2px(context, 10);
    }

    @Override
    public void drawGraph(Rect mRect, Canvas canvas, float ratioX, float ratioY, Paint paint) {
        mRectF.top = mRect.top * ratioY + strockWidth / 2;
        mRectF.bottom = mRect.bottom * ratioY - strockWidth / 2;
        mRectF.left = mRect.left * ratioX + strockWidth / 2;
        mRectF.right = mRect.right * ratioX - strockWidth / 2;
        canvas.drawRoundRect(mRectF, roundRectRadius, roundRectRadius, paint);
    }
}
