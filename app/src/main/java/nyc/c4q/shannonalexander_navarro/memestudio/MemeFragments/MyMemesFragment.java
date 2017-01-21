package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import nyc.c4q.shannonalexander_navarro.memestudio.Activities.MainActivity;
import nyc.c4q.shannonalexander_navarro.memestudio.R;

/**
 * Created by shannonalexander-navarro on 1/8/17.
 */

public class MyMemesFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private LinearLayout memeLayout;
    private FloatingActionButton closeRVFrag;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.my_memes_fragment, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.meme_recyclervivew);
        layoutManager = new LinearLayoutManager(getContext());
        memeLayout = (LinearLayout) root.findViewById(R.id.saved_memes_frag);
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
