package nyc.c4q.shannonalexander_navarro.memestudio.capture;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import nyc.c4q.shannonalexander_navarro.memestudio.R;


/**
 * Created by rusili on 1/15/17.
 */

public class CaptureView {
    private View mView;
    private Activity mActivity;
    private File mPhotoPath;
    public  static String uri;

    public CaptureView (Activity inputActivity) {
        this.mActivity = inputActivity;
        String[] perms = {"android.permission. WRITE_EXTERNAL_STORAGE"};
        int permsRequestCode = 200;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mActivity.requestPermissions(perms, permsRequestCode);
        }

        mView = (View) mActivity.findViewById(R.id.frags_go_here);
        capture();
    }

    public void capture () {
        //Create a Bitmap with the same dimensions
        Bitmap image = Bitmap.createBitmap(mView.getWidth(),
                mView.getHeight(),
                Bitmap.Config.RGB_565);
        //Draw the view inside the Bitmap
        mView.draw(new Canvas(image));
        try {
            //Need to implement unique naming method
            String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mmss").format(new Date());
            saveImageToExternal(timeStamp, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Store to sdcard
        try {
            CreateImageFile create = new CreateImageFile(mActivity, mView.getContext());
            mPhotoPath = create.returnFile();
            AddtoGallery.now(mPhotoPath, mActivity);

            Toast.makeText(mView.getContext(), "Meme Saved!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveImageToExternal (String imgName, Bitmap bm) throws IOException {
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES); //Creates app specific folder
        path.mkdirs();
        uri = path.toString();
        Log.d("This is the uri string", uri);
        File imageFile = new File(path, imgName + ".png"); // Imagename.png
        FileOutputStream out = new FileOutputStream(imageFile);
        try {
            bm.compress(Bitmap.CompressFormat.PNG, 100, out); // Compress Image
            out.flush();
            out.close();

            // Tell the media scanner about the new file so that it is
            // immediately available to the user.
            MediaScannerConnection.scanFile(mActivity, new String[] {imageFile.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted (String path, Uri uri) {
                    Log.i("ExternalStorage", "Scanned " + path + ":");
                    Log.i("ExternalStorage", "-> uri=" + uri);
                }
            });
        } catch (Exception e) {
            throw new IOException();
        }
    }
}
