package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.LilyFrags;

import android.hardware.Camera;
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

import nyc.c4q.shannonalexander_navarro.memestudio.R;

import static nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.LilyFrags.LilyCamera.getCameraInstance;

/**
 * Created by Hyun on 1/19/17.
 */
public class LilyCoffeeFrag extends Fragment {

    private View mView;
    private ImageView gallery;
    private FrameLayout lilyFrame;
    private Camera mCamera;
    private LilyPreview lilyPreview;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.lily_frag_layout, container, false);

        mCamera = getCameraInstance();

        lilyFrame = (FrameLayout) mView.findViewById(R.id.lily_cam_preview);
        lilyPreview = new LilyPreview(getContext(), mCamera);
        lilyFrame.addView(lilyPreview);

        gallery = (ImageView) mView.findViewById(R.id.lilypicture);
        gallery.setBackgroundResource(R.drawable.lily_coffee);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "Click Save to Save", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                mCamera.takePicture(null, null, null);
            }
        });

        return mView;
    }
}