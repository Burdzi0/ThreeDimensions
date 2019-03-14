package tech.burdzi0.threedimensions;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private View view;
    private SeekBar seekBar;
    private int currentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        radioGroup = findViewById(R.id.radio_group);

        seekBar = findViewById(R.id.seekBar5);

        seekBar.setMax(255);
        seekBar.setMin(0);
        seekBar.setProgress(100);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                view.setBackgroundColor(getColorWithOpacity(currentColor));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        view = findViewById(R.id.view3);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            int color = getColorWithOpacity(R.color.colorRed);
            switch (checkedId) {
                case R.id.radioButton:
                    color = getColorWithOpacity(R.color.colorRed);
                    currentColor = R.color.colorRed;
                    showToast("You chose red!");
                    break;
                case R.id.radioButton2:
                    color = getColorWithOpacity(R.color.colorBlue);
                    currentColor = R.color.colorBlue;
                    showToast("You chose blue!");
                    break;
                case R.id.radioButton3:
                    color = getColorWithOpacity(R.color.colorGreen);
                    currentColor = R.color.colorGreen;
                    showToast("You chose green!");
                    break;
            }
            view.setBackgroundColor(color);
        });
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);

        view.setBackgroundColor(getColorWithOpacity(R.color.colorRed));
    }

    private int getColorWithOpacity(int color) {
        String colorWithoutOpacity = Integer.toHexString(getResources().getColor(color));
        String opacity = Integer.toHexString(seekBar.getProgress());
        String result = opacity + colorWithoutOpacity.substring(2);
        return Long.decode("0x" + result).intValue();
    }

    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
