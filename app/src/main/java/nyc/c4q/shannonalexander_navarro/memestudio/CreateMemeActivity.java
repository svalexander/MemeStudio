package nyc.c4q.shannonalexander_navarro.memestudio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


import me.anwarshahriar.calligrapher.Calligrapher;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.Rusi_Fragment;


public class CreateMemeActivity extends AppCompatActivity implements View.OnClickListener {

//    private SharedPreferences myPrefs = getSharedPreferences(myTag, 0);
//    private SharedPreferences.Editor myPrefsEdit = myPrefs.edit();

    private ImageView home_fab;
    //private FrameLayout galleryBtn;
    private ImageView showPicture;
    private int PICK_IMAGE_REQUEST = 1;
    private ImageView shareMeme;
    private ImageView galleryBtn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meme);

        initViews();

//        String uri = myPrefs.getString("uri", null);
//        if (uri!=null) {
//            Picasso.with(getApplicationContext())
//                    .load(uri)
//                    .fit()
//                    .into(showPicture);
//        }

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Quantico-Regular.ttf", true);
        //calligrapher.setFont(findViewById(R.id.textGrp), "BungeeShade-Regular.ttf");

        // Shares Meme
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

    // Initializes Views
    private void initViews() {
        galleryBtn = (ImageView) findViewById(R.id.gallery_icon);
        galleryBtn.setOnClickListener(this);
        home_fab = (ImageView) findViewById(R.id.home);
        home_fab.setOnClickListener(this);
        showPicture = (ImageView) findViewById(R.id.showpicture);
        shareMeme = (ImageView) findViewById(R.id.share);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // from Meme Activity to Home Activity
            case R.id.home:
                Intent homeIntent = new Intent(CreateMemeActivity.this, MainActivity.class);
                startActivity(homeIntent);
                break;
            // to Gallery
            case R.id.gallery_icon:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Loads gallery picture into showPicture
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


    public void MeVsMeFragment(View view) {
        getFragmentManager().beginTransaction()
                .replace(R.id.Main_Meme_Fragment, new Rusi_Fragment())
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

}
