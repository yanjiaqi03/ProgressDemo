# ProgressDemo
线段绘制图形动画

在这个demo中，你可以通过继承 BaseLoading，之后在

@Override 

public void drawGraph(Rect mRect, Canvas canvas, float ratioX, float ratioY, Paint paint) { 

    mRectF.top = mRect.top * ratioY + strockWidth / 2; 
    
    mRectF.bottom = mRect.bottom * ratioY - strockWidth / 2; 
    
    mRectF.left = mRect.left * ratioX + strockWidth / 2; 
    
    mRectF.right = mRect.right * ratioX - strockWidth / 2; 
    
    canvas.drawRoundRect(mRectF, roundRectRadius, roundRectRadius, paint); 

} 

绘制你想要的图形，最好保证View是正方形，并且在drawGraph绘制的图形在View中充满，strockWidth是xml属性赋值的线条宽度。

样式： 

<declare-styleable name="BaseLoading">

    <attr name="lineWidth" format="dimension" /> 线条宽度

    <attr name="loadingColor" format="color" /> 线条颜色

</declare-styleable>

xml调用： 

由于自定义attr，所以加入 xmlns:custom="http://schemas.android.com/apk/res-auto"

<ihealthlabs.progressdemo.widgets.RectangleLoading

    android:layout_width="100dp"

    android:layout_height="100dp"

    custom:lineWidth="2dp"

    custom:loadingColor="#ff6633"

/>
