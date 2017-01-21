package nyc.c4q.shannonalexander_navarro.memestudio.Capture;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * Created by rusili on 1/20/17.
 */

public class AddtoGallery {

    public static void now (File mPhotoPath, Activity mActivity) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mPhotoPath.getAbsolutePath());
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        mActivity.sendBroadcast(mediaScanIntent);
    }
}
