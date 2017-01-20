package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import nyc.c4q.shannonalexander_navarro.memestudio.R;

/**
 * Created by shannonalexander-navarro on 1/19/17.
 */

public class CryingJordanFragment extends Fragment {

    private ImageView fragView;
    private ImageView jordanHeadIV;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.crying_jordan_frag, container, false);
        fragView = (ImageView) root.findViewById(R.id.cj_iv_replacing_original_iv);
        return root;
    }
}
