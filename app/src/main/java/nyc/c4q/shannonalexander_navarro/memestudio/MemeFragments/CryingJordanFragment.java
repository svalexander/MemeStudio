package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import nyc.c4q.shannonalexander_navarro.memestudio.R;

/**
 * Created by shannonalexander-navarro on 1/19/17.
 */

public class CryingJordanFragment extends android.support.v4.app.Fragment {

    private ImageView jordanHeadIV;
    private Matrix matrix; //picked android graphics
    private float scale = 1f;
    private ScaleGestureDetector scaleGestureDetector;

    private WindowManager.LayoutParams layoutParams;
    float windowWidth;
    float windowHeight;

    ViewGroup layout;
    private int changeInX;
    private int changeInY;
    int display;


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.crying_jordan_frag, container, false);
        //  fragView = (ImageView) root.findViewById(R.id.cj_iv_replacing_original_iv);

        windowWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        windowHeight = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        layout = (ViewGroup) root.findViewById(R.id.cj_frag_view);
        jordanHeadIV = (ImageView) layout.findViewById(R.id.cj_head_iv);
        scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        matrix = new Matrix();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(5000, 5000);
        jordanHeadIV.setLayoutParams(layoutParams);

        jordanHeadIV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent mevent) {
                scaleGestureDetector.onTouchEvent(mevent);

                final int X = (int) mevent.getRawX();
                final int Y = (int) mevent.getRawY();
                switch (mevent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams layoutParamsAD = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        changeInX = X - layoutParamsAD.leftMargin;
                        changeInY = Y - layoutParamsAD.topMargin;
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParamsAM = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParamsAM.leftMargin = X - changeInX;
                        layoutParamsAM.topMargin = Y - changeInY;
                        layoutParamsAM.rightMargin = 0b11111111111111111111111100000110;
                        layoutParamsAM.bottomMargin = 0b11111111111111111111111100000110;
                        view.setLayoutParams(layoutParamsAM);
                        break;
                }
                layout.invalidate();
                return true;
            }
            //     return true;
            //   }
        });
        return root;

    }


//    public boolean onTouchEvent(MotionEvent ev) {
//        scaleGestureDetector.onTouchEvent(ev);
//        return true;
//    }


    private class ScaleListener extends ScaleGestureDetector.
            SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5.0f));
            matrix.setScale(scale, scale);
            jordanHeadIV.setImageMatrix(matrix);
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
}
