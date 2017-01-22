package nyc.c4q.shannonalexander_navarro.memestudio.capture;

import android.app.Activity;
import android.content.Context;
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
    private Activity mActivity;
    private String mPhotoPath;


    public CreateImageFile (Activity act, Context ctx) throws IOException {
        this.mActivity = act;
        this.mContext = ctx;

        photo = createImageFile();
        AddtoGallery.now(photo, mActivity);
    }

    public File returnFile () {
        return photo;
    }


    //Creates an image file that is unique using a timestamp
    private File createImageFile () throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mmss").format(new Date());
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES); //Creates app specific folder
        File imageFile = new File(path, timeStamp + ".png"); // Imagename.png
        File storageDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                timeStamp,  /* prefix */
                ".png",         /* suffix */
                storageDir      /* directory */
        );
        mPhotoPath = image.getAbsolutePath();
        Log.d("Location of picture: ", image.getAbsolutePath());
        return image;
    }
    public File getPhoto() {
        return photo;
    }

    public String getmPhotoPath() {
        return mPhotoPath;
    }
}
