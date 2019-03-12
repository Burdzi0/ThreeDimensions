package tech.burdzi0.threedimensions;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class ThirdActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private View view;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        radioGroup = findViewById(R.id.radio_group);

        seekBar = findViewById(R.id.seekBar5);

        seekBar.setMax(255);
        seekBar.setMin(0);

        view = findViewById(R.id.view3);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            int color = getColorWithOpacity(R.color.colorRed);
            switch (checkedId) {
                case R.id.radioButton:
                    color = getColorWithOpacity(R.color.colorRed);
                    break;
                case R.id.radioButton2:
                    color = getColorWithOpacity(R.color.colorBlue);
                    break;
                case R.id.radioButton3:
                    color = getColorWithOpacity(R.color.colorGreen);
                    break;
            }
            view.setBackgroundColor(color);
        });
    }

    private int getColorWithOpacity(int p) {
        String colorWithoutOpacity = Integer.toHexString(getResources().getColor(p));
        String opacity = Integer.toHexString(seekBar.getProgress());
        String result = opacity + colorWithoutOpacity.substring(2);
        return Long.decode("0x" + result).intValue();
    }

    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
