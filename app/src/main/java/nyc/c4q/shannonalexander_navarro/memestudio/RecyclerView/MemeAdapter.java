package nyc.c4q.shannonalexander_navarro.memestudio.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.memestudio.Meme;

/**
 * Created by tarynking on 1/17/17.
 */

public class MemeAdapter extends RecyclerView.Adapter {

    private List <Meme> meme = new ArrayList <>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        return new MemeViewHolder(parent);
    }

    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder holder, int position) {
        MemeViewHolder animalViewHolder = (MemeViewHolder) holder;
        Meme currentMeme = meme.get(position);
        animalViewHolder.bind(currentMeme);
    }

    @Override
    public int getItemCount () {
        return meme.size();
    }

    public void setData (List <Meme> meme) {
        this.meme = meme;
        notifyDataSetChanged();
    }
}
