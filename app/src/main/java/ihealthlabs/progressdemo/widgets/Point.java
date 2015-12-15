package ihealthlabs.progressdemo.widgets;

/**
 * Created by YanJiaqi on 15/12/14
 */
public class Point {
    private float x = 0f;
    private float y = 0f;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setPoint(float x,float y){
        this.x = x;
        this.y = y;
    }
}
