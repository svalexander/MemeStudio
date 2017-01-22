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
<<<<<<< HEAD


=======
>>>>>>> f199e35ff9c5cb207a2195653947116367da4a20
    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragView = inflater.inflate(R.layout.paint_meme_fragment, container, false);
        paintBackground = (PaintMemeView) fragView.findViewById(R.id.paint_meme_background);
<<<<<<< HEAD

=======
>>>>>>> f199e35ff9c5cb207a2195653947116367da4a20
        redBtn = (Button) fragView.findViewById(R.id.red_btn);
        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintBackground.setStrokeRed();
<<<<<<< HEAD


            }
        });



=======
            }
        });
>>>>>>> f199e35ff9c5cb207a2195653947116367da4a20
        greenBtn = (Button) fragView.findViewById(R.id.green_btn);
        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintBackground.setStrokeGreen();
<<<<<<< HEAD


            }
        });

=======
            }
        });
>>>>>>> f199e35ff9c5cb207a2195653947116367da4a20
        blueBtn = (Button) fragView.findViewById(R.id.blue_btn);
        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintBackground.setStrokeBlue();
<<<<<<< HEAD


            }
        });

=======
            }
        });
>>>>>>> f199e35ff9c5cb207a2195653947116367da4a20
        blackBtn = (Button) fragView.findViewById(R.id.black_btn);
        blackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintBackground.setStrokeBlack();
<<<<<<< HEAD


            }
        });

=======
            }
        });
>>>>>>> f199e35ff9c5cb207a2195653947116367da4a20
        whiteBtn = (Button) fragView.findViewById(R.id.white_btn);
        whiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintBackground.setStrokeWhite();
<<<<<<< HEAD


            }
        });

=======
            }
        });
>>>>>>> f199e35ff9c5cb207a2195653947116367da4a20
        return fragView;
    }
}
