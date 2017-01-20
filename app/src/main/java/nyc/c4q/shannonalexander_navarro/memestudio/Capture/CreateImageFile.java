package nyc.c4q.shannonalexander_navarro.memestudio.Capture;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rusili on 1/15/17.
 */

public class CreateImageFile {
    private File photo;
    private Context mContext;
    private String mPhotoPath;

    public CreateImageFile (Context ctx) throws IOException {
        this.mContext = ctx;

        photo = createImageFile();
        galleryAddPic();
    }

    public File returnFile () {
        return photo;
    }

    //Creates an image file that is unique using a timestamp
    private File createImageFile () throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mmss").format(new Date());
        String imageFileName = "PNG_" + timeStamp + "_";
        File storageDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".png",         /* suffix */
                storageDir      /* directory */
        );
        mPhotoPath = image.getAbsolutePath();
        Log.d("Location of picture: ", image.getAbsolutePath());
        return image;
    }

    //Adds the picture to the Android gallery so anyone can access it.
    private void galleryAddPic () {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        mContext.sendBroadcast(mediaScanIntent);
    }
}
