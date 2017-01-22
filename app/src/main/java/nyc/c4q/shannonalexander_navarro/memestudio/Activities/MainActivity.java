package nyc.c4q.shannonalexander_navarro.memestudio.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.memecollection.MyMemesFragment;
import nyc.c4q.shannonalexander_navarro.memestudio.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView myMemes;
    private FloatingActionButton goTo;
    private Cursor cursor;
    private int columnIndex;
    private MyMemesFragment myMemesFragment;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Quantico-Regular.ttf", true);
        initViews();

        String[] projection = {MediaStore.Images.Thumbnails._ID};
        // Create the cursor pointing to the SDCard
        cursor = getContentResolver().query( MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI,
                projection, // Which columns to return
                null,       // Return all rows
                null,
                MediaStore.Images.Thumbnails.IMAGE_ID);
        columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Thumbnails._ID);

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
                myMemesFragment = new MyMemesFragment(cursor,columnIndex);
                FragmentManager savedMemesFragment = getSupportFragmentManager();
                savedMemesFragment.beginTransaction().add(R.id.activity_main, myMemesFragment).commit();
                break;
            case R.id.newMeme:
                Intent intent = new Intent(MainActivity.this, CreateMemeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
