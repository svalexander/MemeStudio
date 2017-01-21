package nyc.c4q.shannonalexander_navarro.memestudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView myMemes;
    private FloatingActionButton goTo;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
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
