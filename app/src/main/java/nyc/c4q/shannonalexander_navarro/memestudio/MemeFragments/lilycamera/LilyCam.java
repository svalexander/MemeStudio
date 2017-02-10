package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.lilycamera;

import android.hardware.Camera;

/**
 * Created by Hyun on 2/10/17.
 */

public class LilyCam {

    private static Camera sCamera;

    public static Camera getCameraInstance() {
        if (sCamera == null) {
            sCamera = Camera.open();
        }
        return sCamera;
    }

    public static void release() {
        if (sCamera != null) {
            sCamera.release();
        }
    }


}
