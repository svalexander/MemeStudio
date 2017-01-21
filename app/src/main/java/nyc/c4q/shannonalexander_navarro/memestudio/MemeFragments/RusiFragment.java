package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.shannonalexander_navarro.memestudio.R;

/**
 * Created by rusili on 1/15/17.
 */

public class RusiFragment extends Fragment {

    private View mView;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.rusi_meme, container, false);
        return mView;
    }
}
