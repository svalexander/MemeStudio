package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.LilyFrags;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import nyc.c4q.shannonalexander_navarro.memestudio.R;


/**
 * Created by Hyun on 1/20/17.
 */

public class LilyCamera extends AppCompatActivity {

    private Camera mCamera;
    private LilyPreview mPreview;
    private FrameLayout preview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lily_frag_layout);

        mCamera = getCameraInstance();
    }

    /**
     * A safe way to get an instance of the Camera object.
     */
    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        } catch (Exception e) {
            throw new IllegalStateException("Camera not working");

            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
}
