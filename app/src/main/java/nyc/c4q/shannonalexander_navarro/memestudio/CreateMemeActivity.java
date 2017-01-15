package nyc.c4q.shannonalexander_navarro.memestudio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.Rusi_Fragment;

public class CreateMemeActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton home_fab;
    private FrameLayout galleryBtn;
    private ImageView showPicture;
    private int PICK_IMAGE_REQUEST = 1;
    private FloatingActionButton shareMeme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meme);

        initViews();

        shareMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareMemeIntent = new Intent();
                shareMemeIntent.setAction(Intent.ACTION_SEND);
                shareMemeIntent.setType("image/jpeg");

               // File photoFile = new File(getFilesDir(), "foo.jpg");
                startActivity(Intent.createChooser(shareMemeIntent, "Share image using"));
            }
        });
    }

    private void initViews() {
        home_fab = (FloatingActionButton) findViewById(R.id.home);
        home_fab.setOnClickListener(this);
        showPicture = (ImageView) findViewById(R.id.showpicture);
        galleryBtn = (FrameLayout) findViewById(R.id.gallerybtn);
        galleryBtn.setOnClickListener(this);
        shareMeme = (FloatingActionButton) findViewById(R.id.share);
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
                startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            Picasso.with(getApplicationContext())
                    .load(uri)
                    .fit()
                    .into(showPicture);
        }
    }

    public void MeVsMeFragment(View view) {
        getFragmentManager().beginTransaction()
                .replace(R.id.Main_Meme_Fragment, new Rusi_Fragment())
                .commit();
    }
}
