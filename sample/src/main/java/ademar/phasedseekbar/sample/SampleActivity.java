package ademar.phasedseekbar.sample;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import ademar.phasedseekbar.PhasedInteractionListener;
import ademar.phasedseekbar.PhasedListener;
import ademar.phasedseekbar.PhasedSeekBar;
import ademar.phasedseekbar.SimplePhasedAdapter;

public class SampleActivity extends AppCompatActivity {

    protected PhasedSeekBar psbLike, psbStar, psbNoImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity);

        PhasedSeekBar psbHorizontal = findViewById(R.id.psb_hor);
        psbLike = findViewById(R.id.psb_like);
        psbStar = findViewById(R.id.psb_star);
        psbNoImages = findViewById(R.id.psb_no_images);

        final Resources resources = getResources();

        psbHorizontal.setAdapter(new SimplePhasedAdapter(resources, new int[] {
                R.drawable.btn_square_selector,
                R.drawable.btn_triangle_selector,
                R.drawable.btn_xis_selector }));

        psbLike.setAdapter(new SimplePhasedAdapter(resources, new int[] {
                R.drawable.btn_like_selector,
                R.drawable.btn_unlike_selector }));
        psbStar.setAdapter(new SimplePhasedAdapter(resources, new int[] {
                R.drawable.btn_star1_selector,
                R.drawable.btn_star2_selector,
                R.drawable.btn_star3_selector,
                R.drawable.btn_star4_selector,
                R.drawable.btn_star5_selector }));
        psbNoImages.setAdapter(new SimplePhasedAdapter(resources, new int[] {
                R.drawable.no_image_shape }));

        psbHorizontal.setListener(new PhasedListener() {
            @Override
            public void onPositionSelected(int position) {
                psbLike.setVisibility(position == 0 ? View.VISIBLE : View.INVISIBLE);
                psbStar.setVisibility(position == 1 ? View.VISIBLE : View.INVISIBLE);
                psbNoImages.setVisibility(position == 2 ? View.VISIBLE : View.INVISIBLE);
            }
        });

        psbHorizontal.setInteractionListener(new PhasedInteractionListener() {
            @Override
            public void onInteracted(int x, int y, int position, MotionEvent motionEvent) {
                Log.d("PSB", String.format("onInteracted %d %d %d %d", x, y, position, motionEvent.getAction()));
            }
        });

        psbLike.setPosition(0);
    }

}
