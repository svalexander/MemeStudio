package nyc.c4q.shannonalexander_navarro.memestudio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;



public class CreateMemeActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton home_fab;
    private FrameLayout galleryBtn;
    private ImageView showPicture;
    private int PICK_IMAGE_REQUEST = 1;
    private FloatingActionButton shareMeme;

//    private String myTag;
//    private SharedPreferences myPrefs = getSharedPreferences(myTag, 0);
//    private SharedPreferences.Editor myPrefsEdit = myPrefs.edit();

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
            android.net.Uri uri = data.getData();



            Picasso.with(getApplicationContext())
                    .load(uri)
                    .fit()
                    .into(showPicture);

//            myPrefsEdit.putString("url", uri.toString());
//            myPrefsEdit.commit();


        }
    }

//    public void permission() {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
//                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//
//
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.INTERNET},   //request specific permission from user
//                    10);
//
//            return;
//        }
//    }

    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("uri", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("uriLink", String.valueOf(showPicture.getDrawingCache(true)));
        editor.apply();

    }

}
