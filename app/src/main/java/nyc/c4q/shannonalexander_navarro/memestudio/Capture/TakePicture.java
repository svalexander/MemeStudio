package nyc.c4q.shannonalexander_navarro.memestudio.Capture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import nyc.c4q.shannonalexander_navarro.memestudio.R;

public class TakePicture extends AppCompatActivity {
    private Activity mActivity;
    private Context mContext;
    private File photoFile = null;
    static final int REQUEST_TAKE_PHOTO = 1;

    public TakePicture (Activity act) {
        this.mActivity = act;
        mContext = mActivity.getBaseContext();
        dispatchTakePictureIntent();
    }

    //Upgraded code to give the saved picture a unique name
    private void dispatchTakePictureIntent () {
        // Check if there is a camera.
        PackageManager packageManager = mContext.getPackageManager();
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA) == false) {
            Toast.makeText(mContext, "This device does not have a camera.", Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(mContext.getPackageManager()) != null) {
            try {
                CreateImageFile create = new CreateImageFile(mActivity, mContext);
                photoFile = create.returnFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                Toast toast = Toast.makeText(mContext, "There was a problem saving the photo...", Toast.LENGTH_SHORT);
                toast.show();
            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(mContext,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                mActivity.startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (photoFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(photoFile.getAbsolutePath());
            ImageView myImage = (ImageView) findViewById(R.id.mypicture_meme_background);
            myImage.setImageBitmap(myBitmap);
        }
    }
}
