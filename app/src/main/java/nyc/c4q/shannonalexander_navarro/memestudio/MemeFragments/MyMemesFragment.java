package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import nyc.c4q.shannonalexander_navarro.memestudio.Activities.MainActivity;
import nyc.c4q.shannonalexander_navarro.memestudio.ImageAdapter;
import nyc.c4q.shannonalexander_navarro.memestudio.R;

/**
 * Created by shannonalexander-navarro on 1/8/17.
 */

@SuppressLint("ValidFragment")
public class MyMemesFragment extends Fragment {

    private View root;
    private GridView sdcardImages;
    private FloatingActionButton closeRVFrag;
    private Cursor cursor;
    private int columnIndex;

    @SuppressLint("ValidFragment")
    public MyMemesFragment(Cursor cursor, int columnIndex) {
        this.cursor = cursor;
        this.columnIndex = columnIndex;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.my_memes_fragment, container, false);

        sdcardImages = (GridView) root.findViewById(R.id.main_gridview);
        sdcardImages.setAdapter(new ImageAdapter(getContext(), cursor, columnIndex));

        closeRVFrag = (FloatingActionButton) root.findViewById(R.id.close_rv);
        closeRVFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent closeIntent = new Intent(getContext(), MainActivity.class);
                startActivity(closeIntent);
            }
        });
        return root;
    }
}
