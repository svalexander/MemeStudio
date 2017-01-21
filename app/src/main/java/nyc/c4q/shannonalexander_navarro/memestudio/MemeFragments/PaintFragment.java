package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.shannonalexander_navarro.memestudio.R;

/**
 * Created by tarynking on 1/21/17.
 */

public class  PaintFragment extends Fragment {

    private View fragView;
    private PaintMemeView paintBackground;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragView = inflater.inflate(R.layout.paint_meme_fragment, container, false);
        paintBackground = (PaintMemeView) fragView.findViewById(R.id.paint_meme_background);
        return fragView;
    }
}
