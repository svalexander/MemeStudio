package nyc.c4q.shannonalexander_navarro.memestudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView myMemes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myMemes = (TextView) findViewById(R.id.myMemes);
        myMemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager savedMemesFragment = getSupportFragmentManager();
                savedMemesFragment.beginTransaction().add(R.id.activity_main, new MyMemesFragment()).commit();
            }
        });

        FloatingActionButton goTo = (FloatingActionButton) findViewById(R.id.newMeme);
        goTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateMemeActivity.class);
                startActivity(intent);
            }
        });

    }
}
