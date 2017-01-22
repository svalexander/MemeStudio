package nyc.c4q.shannonalexander_navarro.memestudio.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import nyc.c4q.shannonalexander_navarro.memestudio.ImageAdapter;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.MyMemesFragment;
import nyc.c4q.shannonalexander_navarro.memestudio.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView myMemes;
    private FloatingActionButton goTo;
    private Cursor cursor;
    private int columnIndex;
    private String[] galleryURI;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        // Set up an array of the Thumbnail Image ID column we want
        String[] projection = {MediaStore.Images.Thumbnails._ID};
        // Create the cursor pointing to the SDCard
        cursor = managedQuery( MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI,
                projection, // Which columns to return
                null,       // Return all rows
                null,
                MediaStore.Images.Thumbnails.IMAGE_ID);
        // Get the column index of the Thumbnails Image ID
        columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Thumbnails._ID);

        GridView sdcardImages = (GridView) findViewById(R.id.main_gridview);
        sdcardImages.setAdapter(new ImageAdapter(this, cursor, columnIndex));
    }

    private void initViews () {
        myMemes = (TextView) findViewById(R.id.myMemes);
        myMemes.setOnClickListener(this);
        goTo = (FloatingActionButton) findViewById(R.id.newMeme);
        goTo.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.myMemes:
                FragmentManager savedMemesFragment = getSupportFragmentManager();
                savedMemesFragment.beginTransaction().add(R.id.activity_main, new MyMemesFragment()).commit();
                break;
            case R.id.newMeme:
                Intent intent = new Intent(MainActivity.this, CreateMemeActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onResume () {
        super.onResume();
    }
}
