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
public class CircleLoading extends BaseLoading {

    public CircleLoading(Context context) {
        super(context);
        init(context);
    }

    public CircleLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {

    }

    @Override
    public void drawGraph(Rect mRect, Canvas canvas, float ratioX, float ratioY, Paint paint) {
        canvas.drawCircle(mRect.width()/2*ratioX,mRect.height()/2*ratioY,Math.min(mRect.width()/2*ratioX,mRect.height()/2*ratioY)
                -strockWidth/2,paint);
    }
}
