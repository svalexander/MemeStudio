package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by tarynking on 1/20/17.
 */

public class PaintMemeView extends ImageView {
    private Paint paintLine = new Paint();
    private Path path = new Path();
    //Constructors
    public PaintMemeView(Context context) {
        super(context);
        init(null, 0);
    }
    public PaintMemeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }
    public PaintMemeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }
    private void init(AttributeSet attrs, int defStyleAttr) {
        paintLine.setColor(Color.WHITE);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setAntiAlias(true); // this makes your stroke smooth
        paintLine.setStrokeWidth(10);//set the width of your stroke
    }
    //getters
    public Paint getPaintLine() {
        return paintLine;
    }
    public Path getPath() {
        return path;
    }
    //button methods
    public void setStrokeRed() {
        paintLine.setColor(Color.RED);
    }
    public void setStrokeGreen() {
        paintLine.setColor(Color.GREEN);
    }
    public void setStrokeBlue() {
        paintLine.setColor(Color.BLUE);
    }
    public void setStrokeBlack() {
        paintLine.setColor(Color.BLACK);
    }
    public void setStrokeWhite() {
        paintLine.setColor(Color.WHITE);
    }
    public void setStrokeThick() {
        paintLine.setStrokeWidth(20);
    }
    public void setStrokeThin() {
        paintLine.setStrokeWidth(10);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paintLine);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                path.moveTo(touchX, touchY);
                break;
        }
        invalidate();
        return true;
    }
}