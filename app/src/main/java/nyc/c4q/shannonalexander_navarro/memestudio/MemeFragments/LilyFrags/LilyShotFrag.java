package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.LilyFrags;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import nyc.c4q.shannonalexander_navarro.memestudio.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Hyun on 1/20/17.
 */

public class LilyShotFrag  extends Fragment implements View.OnClickListener {

    private final int PICK_IMAGE_REQUEST = 2;
    private ImageView gallery;
    private LinearLayout lilyshot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lily_frag_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
        lilyshot = (LinearLayout) view.findViewById(R.id.lily_container);
        lilyshot.setBackgroundResource(R.drawable.lily_shot);
        gallery = (ImageView) view.findViewById(R.id.lilypicture);
        gallery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent lilyIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(lilyIntent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            android.net.Uri uri = data.getData();

            Picasso.with(getActivity())
                    .load(uri)
                    .fit()
                    .into(gallery);
        }
    }
}
