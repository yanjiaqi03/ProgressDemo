package ihealthlabs.progressdemo.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;

/**
 * Created by YanJiaqi on 15/12/14
 */
public class MutiangleLoading extends BaseLoading {
    private Point[] points = new Point[12];
    private Path mPath = new Path();
    private float width = 0f;
    private float height = 0f;

    public MutiangleLoading(Context context) {
        super(context);
        init(context);
    }

    public MutiangleLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point();
        }
    }

    @Override
    public void drawGraph(Rect mRect, Canvas canvas, float ratioX, float ratioY, Paint paint) {
        width = mRect.width() * ratioX;
        height = mRect.height() * ratioY;

        points[0].setPoint(strockWidth / 2, height / 3 + strockWidth / 2);
        points[1].setPoint(strockWidth / 2 + width / 3, height / 3 + strockWidth / 2);
        points[2].setPoint(width / 2, strockWidth / 2);
        points[3].setPoint(strockWidth / 2 + width * 2 / 3, height / 3 + strockWidth / 2);
        points[4].setPoint(width - strockWidth / 2, height / 3 + strockWidth / 2);

        points[5].setPoint(strockWidth / 2 + width * 5 / 6, height / 2);
        points[6].setPoint(width - strockWidth / 2, height *2 / 3 + strockWidth / 2);

        points[7].setPoint(strockWidth / 2 + width * 2 / 3, height * 2 / 3 + strockWidth / 2);
        points[8].setPoint(width / 2, height - strockWidth / 2);
        points[9].setPoint(strockWidth / 2 + width  / 3, height * 2 / 3 + strockWidth / 2);
        points[10].setPoint(strockWidth / 2, height * 2 / 3 + strockWidth / 2);

        points[11].setPoint(strockWidth / 2 + width /6, height / 2);


        mPath.reset();
        for (int i = 0; i < points.length; i++) {
            if (i == 0) {
                mPath.moveTo(points[i].getX(), points[i].getY());
                continue;
            }
            mPath.lineTo(points[i].getX(), points[i].getY());
        }
        mPath.lineTo(points[0].getX(), points[0].getY());
        canvas.drawPath(mPath, paint);
    }
}
