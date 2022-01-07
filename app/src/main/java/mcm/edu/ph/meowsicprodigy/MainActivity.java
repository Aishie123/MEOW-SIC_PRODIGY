package mcm.edu.ph.meowsicprodigy;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {
    ImageButton catto1;
    ImageView catto2;
    final String TAG = "catto";

    MediaPlayer player;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player = new MediaPlayer();
        player = MediaPlayer.create(this, R.raw.acnh);


        catto1 = (ImageButton) findViewById(R.id.imageButton);
        catto2 = (ImageView) findViewById(R.id.imageView);

        play();

        }
        @SuppressLint("ClickableViewAccessibility")
        public void play() {
        catto1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    catto2.setVisibility(View.VISIBLE);
                    catto1.setVisibility(View.INVISIBLE);
                    player.start();
                    Log.d(TAG, "catto ending kk slider's career");
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    catto2.setVisibility(View.INVISIBLE);
                    catto1.setVisibility(View.VISIBLE);

                    Log.d(TAG, "plz click");
                    player.pause();
                }
                return false;
            }

        });


    }
    @Override
    public void onCompletion(MediaPlayer player) {
        player.stop();
        player.reset();
        play();
    }


}








