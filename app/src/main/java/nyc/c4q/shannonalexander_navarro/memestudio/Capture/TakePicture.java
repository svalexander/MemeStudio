package nyc.c4q.shannonalexander_navarro.memestudio.Capture;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class TakePicture extends AppCompatActivity {
    static final int REQUEST_TAKE_PHOTO = 1;

    public TakePicture() {
        dispatchTakePictureIntent();
    }

    //Upgraded code to give the saved picture a unique name
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                CreateImageFile create = new CreateImageFile(this);
                photoFile = create.returnFile();
            } catch (IOException ex) {
            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
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
