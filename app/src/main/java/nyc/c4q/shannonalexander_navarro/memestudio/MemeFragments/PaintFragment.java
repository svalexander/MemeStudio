package nyc.c4q.shannonalexander_navarro.memestudio.MemeFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import nyc.c4q.shannonalexander_navarro.memestudio.R;

/**
 * Created by tarynking on 1/21/17.
 */

public class  PaintFragment extends Fragment {
    private View fragView;
    private PaintMemeView paintBackground;
    private Button redBtn;
    private Button greenBtn;
    private Button blueBtn;
    private Button blackBtn;
    private Button whiteBtn;
    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragView = inflater.inflate(R.layout.paint_meme_fragment, container, false);
        paintBackground = (PaintMemeView) fragView.findViewById(R.id.paint_meme_background);

        redBtn = (Button) fragView.findViewById(R.id.red_btn);
        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintBackground.setStrokeRed();
            }
        });
        greenBtn = (Button) fragView.findViewById(R.id.green_btn);
        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintBackground.setStrokeGreen();
            }
        });
        blueBtn = (Button) fragView.findViewById(R.id.blue_btn);
        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintBackground.setStrokeBlue();
            }
        });
        blackBtn = (Button) fragView.findViewById(R.id.black_btn);
        blackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintBackground.setStrokeBlack();
            }
        });
        whiteBtn = (Button) fragView.findViewById(R.id.white_btn);
        whiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintBackground.setStrokeWhite();
            }
        });
        return fragView;
    }
}
