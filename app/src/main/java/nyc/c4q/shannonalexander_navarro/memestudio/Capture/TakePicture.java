package nyc.c4q.shannonalexander_navarro.memestudio.Capture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class TakePicture {
    private Activity mActivity;
    private Context mContext;
    static final int REQUEST_TAKE_PHOTO = 1;

    public TakePicture(Activity act) {
        this.mActivity = act;
        mContext = mActivity.getBaseContext();
        dispatchTakePictureIntent();
    }

    //Upgraded code to give the saved picture a unique name
    private void dispatchTakePictureIntent() {

        // Check if there is a camera.
        PackageManager packageManager = mContext.getPackageManager();
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA) == false){
            Toast.makeText(mContext, "This device does not have a camera.", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(mContext.getPackageManager()) != null) {
            File photoFile = null;
            try {
                CreateImageFile create = new CreateImageFile(mContext);
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

    /* Puts picture into an Imageview
    // Use Picasso instead

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        File imgFile = new  File(mCurrentPhotoPath);

        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ImageView myImage = (ImageView) findViewById(R.id.wImageView);
            myImage.setImageBitmap(myBitmap);

        }
    }
    */
}
