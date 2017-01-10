package nyc.c4q.shannonalexander_navarro.memestudio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

public class CreateMemeActivity extends AppCompatActivity {

    FloatingActionButton home_fab;

    private FloatingActionButton shareMeme;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meme);

        home_fab = (FloatingActionButton)findViewById(R.id.home);

        home_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(CreateMemeActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }

        });

        shareMeme = (FloatingActionButton) findViewById(R.id.share);

        shareMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendMemeIntent = new Intent(android.content.Intent.ACTION_SEND);
                sendMemeIntent.setType("image/jpeg");

                File savedPic = new File(
                        Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_PICTURES),

                        )
                )
            }
        });
    }


}
