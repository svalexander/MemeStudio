package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import nyc.c4q.shannonalexander_navarro.memestudio.ScaleHandler;

/**
 * Created by shannonalexander-navarro on 1/19/17.
 */

public class CryingJordanCustomView extends View implements View.OnTouchListener {

    private ScaleGestureDetector scaleGestureDetector;
    private float scaleFactor = 1.f;

    private float posX;
    private float posY;

    public CryingJordanCustomView(Context context) {
        super(context);

        scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleHandler(scaleFactor));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.scale(scaleFactor,scaleFactor);

        //more onDraw();
        canvas.translate(posX, posY);

        
        canvas.restore();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        scaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }
}
