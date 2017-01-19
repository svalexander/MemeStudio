package nyc.c4q.shannonalexander_navarro.memestudio;

import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by tarynking on 1/17/17.
 */

public class MemeViewHolder extends RecyclerView.ViewHolder {

    private ImageView memeNameIv;
    private Fragment fragment;


    public MemeViewHolder (ViewGroup parent) {
//        super(itemView);
        super(inflateView(parent));
        memeNameIv = (ImageView)
                itemView.findViewById(R.id.iv_meme_item_id);

    }

    private static View inflateView (ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.meme_item_layout, parent, false);
    }

    public void bind (final Meme meme) {

        memeNameIv.setImageURI(meme.getUri());
        Picasso.with(itemView.getContext())
                .load("http://i.imgur.com/DvpvklR.png")
                .into(memeNameIv);

    }
}
