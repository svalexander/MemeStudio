package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.lilyfrags;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.lilycamera.LilyCam;
import nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.lilycamera.LilyPreview;
import nyc.c4q.shannonalexander_navarro.memestudio.R;

/**
 * Created by Hyun on 1/20/17.
 */

public class LilyTennisFrag extends Fragment {

    private View mView;
    private ImageView gallery;
    private FrameLayout lilyFrame;
    private LilyPreview lilyPreview;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.lily_frag_layout, container, false);


        lilyFrame = (FrameLayout) mView.findViewById(R.id.lily_cam_preview);
        lilyPreview = new LilyPreview(getContext(), LilyCam.getCameraInstance());
        lilyFrame.addView(lilyPreview);
        gallery = (ImageView) mView.findViewById(R.id.lilypicture);
        gallery.setBackgroundResource(R.drawable.lily_tennis);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "Click Save to Save", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        return mView;
    }

}