package nyc.c4q.shannonalexander_navarro.memestudio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import me.anwarshahriar.calligrapher.Calligrapher;
import nyc.c4q.shannonalexander_navarro.memestudio.Capture.TakePicture;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.CryingJordanFragment;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.LilyFrags.LilyCoffeeFrag;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.LilyFrags.LilyShotFrag;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.LilyFrags.LilyTennisFrag;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.Rusi_Fragment;

import static nyc.c4q.shannonalexander_navarro.memestudio.R.id.lily1;
import static nyc.c4q.shannonalexander_navarro.memestudio.R.id.lily2;
import static nyc.c4q.shannonalexander_navarro.memestudio.R.id.lily3;


public class CreateMemeActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private final int PICK_IMAGE_REQUEST = 1;
    private Activity mActivity = this;
    private ImageView home_fab;
    private ImageView showPicture;
    private ImageView shareMeme;
    private ImageView galleryBtn;
    private ImageView btnSave;
    private Button theoryBtn;
    private Button lilyBtn;


//    private String myTag;
//    private SharedPreferences myPrefs = getSharedPreferences(myTag, 0);
//    private SharedPreferences.Editor myPrefsEdit = myPrefs.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meme);

        initViews();

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Quantico-Regular.ttf", true);
        //calligrapher.setFont(findViewById(R.id.textGrp), "BungeeShade-Regular.ttf");

    }


    // Initializes Views
    private void initViews() {
        galleryBtn = (ImageView) findViewById(R.id.gallery_icon);
        galleryBtn.setOnClickListener(this);
        home_fab = (ImageView) findViewById(R.id.home);
        home_fab.setOnClickListener(this);
        showPicture = (ImageView) findViewById(R.id.showpicture);
        shareMeme = (ImageView) findViewById(R.id.share);
        shareMeme.setOnClickListener(this);
        btnSave = (ImageView) findViewById(R.id.save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CaptureView cv = new CaptureView(mActivity);
                //cv.capture();

                TakePicture tp = new TakePicture(mActivity);
            }
        });
        lilyBtn = (Button) findViewById(R.id.lily);
//        lilyBtn.setOnClickListener(this);
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
            case R.id.theory:
                FragmentManager newsFragment = getSupportFragmentManager();
                newsFragment.beginTransaction().add(R.id.cardView, new CryingJordanFragment()).commit();
                break;
            case R.id.share:
                Intent shareMemeIntent = new Intent();
                shareMemeIntent.setAction(Intent.ACTION_SEND);
                shareMemeIntent.setType("image/jpeg");

                // File photoFile = new File(getFilesDir(), "foo.jpg");
                startActivity(Intent.createChooser(shareMemeIntent, "Share image using"));
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

    public void saveInfo(View view) {
        SharedPreferences sharedPref = getSharedPreferences("uri", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("uriLink", String.valueOf(showPicture.getDrawingCache(true)));
        editor.apply();

    }

    public void showPopup(View view){
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.actions);
        popup.show();
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case lily1:
                Toast.makeText(getBaseContext(),"Drink Coffee",Toast.LENGTH_LONG).show();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.cardView, new LilyCoffeeFrag())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();
                return true;
            case lily2:
                Toast.makeText(getBaseContext(),"Tennis",Toast.LENGTH_LONG).show();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.cardView, new LilyTennisFrag())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();
                return true;
            case lily3:
                Toast.makeText(getBaseContext(),"Take a hit!",Toast.LENGTH_LONG).show();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.cardView, new LilyShotFrag())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();
                return true;
            default:
                return false;
        }
    }

    public void MeVsMeFragment(View view) {
        getFragmentManager().beginTransaction()
                .replace(R.id.cardView, new Rusi_Fragment())
                .commit();
    }

}
