package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments.LilyFrags;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import nyc.c4q.shannonalexander_navarro.memestudio.R;

/**
 * Created by Hyun on 1/19/17.
 */

public class LilyCoffeeFrag extends Fragment implements View.OnClickListener, SurfaceHolder.Callback {

    private final int PICK_IMAGE_REQUEST = 2;
    private final int TAKE_PICTURE_CODE = 3;
    private final int REQUEST_CODE = 4;
    private ImageView gallery;
    private LinearLayout lilyCoffee;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lily_frag_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
        lilyCoffee = (LinearLayout) view.findViewById(R.id.lily_container);
        lilyCoffee.setBackgroundResource(R.drawable.lily_coffee);
        gallery = (ImageView) view.findViewById(R.id.lilypicture);
        gallery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        Intent lilyIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(lilyIntent, PICK_IMAGE_REQUEST);

//        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intent, TAKE_PICTURE_CODE);
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//        startActivityForResult(intent, REQUEST_CODE);

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent,TAKE_PICTURE_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == PICK_IMAGE_REQUEST
//                && resultCode == RESULT_OK
//                && data != null
//                && data.getData() != null) {
//
//            android.net.Uri uri = data.getData();
//
//            Picasso.with(getActivity())
//                    .load(uri)
//                    .fit()
//                    .into(gallery);
//        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
