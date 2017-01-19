package nyc.c4q.shannonalexander_navarro.memestudio.Capture;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import nyc.c4q.shannonalexander_navarro.memestudio.R;

// 01-19 15:48:58.549 27614-27614/nyc.c4q.shannonalexander_navarro.memestudio D/Location of picture:: /storage/emulated/0/Android/data/nyc.c4q.shannonalexander_navarro.memestudio/files/Pictures/PNG_20170119_154858_-1059305312.png
// 01-19 15:50:21.691 28298-28298/nyc.c4q.shannonalexander_navarro.memestudio D/Location of picture:: /storage/emulated/0/Android/data/nyc.c4q.shannonalexander_navarro.memestudio/files/Pictures/PNG_20170119_155021_1512245498.png

/**
 * Created by rusili on 1/15/17.
 */

public class CaptureView {
    private Activity mActivity;

    public CaptureView (Activity inputActivity) {
        this.mActivity = inputActivity;
    }

    public void capture () {
        //Find the view we are after: Put into findViewById:

        View view = (View) mActivity.findViewById(R.id.activity_create_meme);

        //Create a Bitmap with the same dimensions
        Bitmap image = Bitmap.createBitmap(view.getWidth(),
                view.getHeight(),
                Bitmap.Config.RGB_565);
        //Draw the view inside the Bitmap
        view.draw(new Canvas(image));

        //Store to sdcard
        try {
            CreateImageFile create = new CreateImageFile(view.getContext());
            File viewFile = create.returnFile();

            Toast.makeText(view.getContext(), "Meme Saved!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
