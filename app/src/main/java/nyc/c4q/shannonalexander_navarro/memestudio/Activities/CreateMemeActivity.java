package nyc.c4q.shannonalexander_navarro.memestudio.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import me.anwarshahriar.calligrapher.Calligrapher;
import nyc.c4q.shannonalexander_navarro.memestudio.Capture.CaptureView;
import nyc.c4q.shannonalexander_navarro.memestudio.Capture.TakePicture;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.CryingJordanFragment;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.LilyFrags.LilyCoffeeFrag;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.LilyFrags.LilyShotFrag;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.LilyFrags.LilyTennisFrag;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.PaintFragment;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.RusiFragment;
import nyc.c4q.shannonalexander_navarro.memestudio.R;

import static nyc.c4q.shannonalexander_navarro.memestudio.R.id.lily1;
import static nyc.c4q.shannonalexander_navarro.memestudio.R.id.lily2;
import static nyc.c4q.shannonalexander_navarro.memestudio.R.id.lily3;

public class CreateMemeActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    // Storage Permissions variables
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private Activity mActivity = this;
    private ImageView showPicture;
    private ImageView cameraBtn;
    private ImageView galleryBtn;
    private ImageView trashBtn;
    private ImageView shareMeme;
    private ImageView saveBtn;
    private ImageView home_fab;
    private Button meBtn;
    private final int PICK_IMAGE_REQUEST = 1;
    private Button theoryBtn;
    private Button lilyBtn;
    private boolean isFragment = false;
    private View fragView;
    private Button paintBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meme);
        verifyStoragePermissions(this);

        initViews();

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Quantico-Regular.ttf", true);
    }

    private void initViews() {
        fragView = (View) findViewById(R.id.frags_go_here);
        showPicture = (ImageView) findViewById(R.id.showpicture);

        meBtn = (Button) findViewById(R.id.me);
        meBtn.setOnClickListener(this);
        theoryBtn = (Button) findViewById(R.id.theory);
        theoryBtn.setOnClickListener(this);
        paintBtn = (Button) findViewById(R.id.paint);
        paintBtn.setOnClickListener(this);

        cameraBtn = (ImageView) findViewById(R.id.camera_icon);
        cameraBtn.setOnClickListener(this);
        galleryBtn = (ImageView) findViewById(R.id.gallery_icon);
        galleryBtn.setOnClickListener(this);

        trashBtn = (ImageView) findViewById(R.id.trash);
        trashBtn.setOnClickListener(this);
        shareMeme = (ImageView) findViewById(R.id.share);
        shareMeme.setOnClickListener(this);
        saveBtn = (ImageView) findViewById(R.id.save);
        saveBtn.setOnClickListener(this);
        home_fab = (ImageView) findViewById(R.id.home);
        home_fab.setOnClickListener(this);
        showPicture = (ImageView) findViewById(R.id.showpicture);
        shareMeme = (ImageView) findViewById(R.id.share);
        shareMeme.setOnClickListener(this);
        lilyBtn = (Button) findViewById(R.id.lily);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.me:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.cardView, new RusiFragment())
                        .addToBackStack(null)
                        .commit();
                isFragment = true;
                break;
            case R.id.theory:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.cardView, new CryingJordanFragment())
                        .addToBackStack(null)
                        .commit();
                isFragment = true;
                break;
            case R.id.paint:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.cardView, new PaintFragment())
                        .addToBackStack(null)
                        .commit();
                isFragment = true;
                break;
            case R.id.camera_icon:
                TakePicture tp = new TakePicture(mActivity);
                break;
            case R.id.gallery_icon:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
                break;
            case R.id.trash:
                if (isFragment) {
                    getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentById(R.id.cardView)).commit();
                }
                break;
            case R.id.share:
                Intent shareMemeIntent = new Intent();
                shareMemeIntent.setAction(Intent.ACTION_SEND);
                shareMemeIntent.setType("image/jpeg");
                // File photoFile = new File(getFilesDir(), "foo.jpg");
                startActivity(Intent.createChooser(shareMemeIntent, "Share image using"));
                break;
            case R.id.save:
                CaptureView cv = new CaptureView(mActivity);
                break;
            case R.id.home:
                Intent homeIntent = new Intent(CreateMemeActivity.this, MainActivity.class);
                startActivity(homeIntent);
                break;
        }
        InputMethodManager imm = (InputMethodManager) fragView.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(fragView.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
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

        }
    }

    public void saveInfo(View view) {
        SharedPreferences sharedPref = getSharedPreferences("uri", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("uriLink", String.valueOf(showPicture.getDrawingCache(true)));
        editor.apply();
    }

    //persmission method.
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.actions);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case lily1:
                Toast.makeText(getBaseContext(), "Drink Coffee!", Toast.LENGTH_LONG).show();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.cardView, new LilyCoffeeFrag())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();
                isFragment = true;
                return true;
            case lily2:
                Toast.makeText(getBaseContext(), "Tennis!", Toast.LENGTH_LONG).show();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.cardView, new LilyTennisFrag())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();
                isFragment = true;
                return true;
            case lily3:
                Toast.makeText(getBaseContext(), "Take a hit!", Toast.LENGTH_LONG).show();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.cardView, new LilyShotFrag())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();
                isFragment = true;
                return true;
            default:
                return false;
        }
    }
}
