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
 * Created by rusili on 1/15/17.
 */

public class MyPicture_Fragment extends Fragment {

    private View mView;
    private ImageView mBackground;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.mypicture_meme, container, false);
        mBackground = (ImageView) mView.findViewById(R.id.mypicture_meme_background);
        return mView;
    }
}
