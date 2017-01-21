package nyc.c4q.shannonalexander_navarro.memestudio;

import android.view.ScaleGestureDetector;

/**
 * Created by shannonalexander-navarro on 1/19/17.
 */

public class ScaleHandler extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    public float userScaler;

    public ScaleHandler(float userScaler) {
        this.userScaler = userScaler;
    }



    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        this.userScaler *= detector.getScaleFactor();
        this.userScaler = Math.max(0.1f, Math.min(this.userScaler, 5.0f));

       // invalidate();

        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        return super.onScaleBegin(detector);
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {
        super.onScaleEnd(detector);
    }


}
