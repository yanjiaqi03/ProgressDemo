package ihealthlabs.progressdemo.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

import ihealthlabs.progressdemo.utils.DensityUtil;

/**
 * Created by YanJiaqi on 15/12/14
 */
public class TriangleLoading extends BaseLoading {
    private Point[] points = new Point[]{new Point(),new Point(),new Point()};
    private Path mPath = new Path();

    public TriangleLoading(Context context) {
        super(context);
        init(context);
    }

    public TriangleLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {

    }

    @Override
    public void drawGraph(Rect mRect, Canvas canvas, float ratioX, float ratioY, Paint paint) {
        points[0].setPoint(mRect.width() / 2 * ratioX, strockWidth/2);
        points[1].setPoint(strockWidth/2,mRect.height()*ratioY-strockWidth/2);
        points[2].setPoint(mRect.width()*ratioX-strockWidth/2,mRect.height()*ratioY-strockWidth/2);

        mPath.reset();
        for(int i = 0;i<points.length;i++){
            if(i == 0){
                mPath.moveTo(points[i].getX(),points[i].getY());
                continue;
            }
            mPath.lineTo(points[i].getX(),points[i].getY());
        }
        mPath.lineTo(points[0].getX(),points[0].getY());
        canvas.drawPath(mPath,paint);
    }
}
