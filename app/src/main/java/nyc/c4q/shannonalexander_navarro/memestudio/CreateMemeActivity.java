package nyc.c4q.shannonalexander_navarro.memestudio;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class CreateMemeActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton home_fab;
    private FrameLayout galleryBtn;
    private ImageView showPicture;
    private int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meme);

        initViews();

    }

    private void initViews() {
        home_fab = (FloatingActionButton) findViewById(R.id.home);
        home_fab.setOnClickListener(this);
        showPicture = (ImageView) findViewById(R.id.showpicture);
        galleryBtn = (FrameLayout) findViewById(R.id.gallerybtn);
        galleryBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home:
                Intent homeIntent = new Intent(CreateMemeActivity.this, MainActivity.class);
                startActivity(homeIntent);
                break;
            case R.id.gallerybtn:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,PICK_IMAGE_REQUEST);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();
            String[] projection = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(projection[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            Bitmap selectedPhoto = BitmapFactory.decodeFile(picturePath);
            Drawable d = new BitmapDrawable(selectedPhoto);
            showPicture.setBackground(d);
        }
    }
}
