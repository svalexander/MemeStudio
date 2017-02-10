package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.lilycamera;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nyc.c4q.shannonalexander_navarro.memestudio.R;

import static nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.lilycamera.LilyCam.release;


/**
 * Created by Hyun on 1/20/17.
 */

public class LilyCameraActivity extends AppCompatActivity {

    private static Camera sCamera;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lily_frag_layout);

        sCamera = LilyCam.getCameraInstance();

    }

    @Override
    protected void onStop() {
        super.onStop();
        release();
    }
}