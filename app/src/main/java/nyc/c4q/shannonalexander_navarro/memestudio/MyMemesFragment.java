package nyc.c4q.shannonalexander_navarro.memestudio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by shannonalexander-navarro on 1/8/17.
 */

public class MyMemesFragment extends Fragment {
    LinearLayout memeLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.my_memes_fragment, container, false);
        memeLayout = (LinearLayout) root.findViewById(R.id.saved_memes_frag);

        return root;
    }
}
