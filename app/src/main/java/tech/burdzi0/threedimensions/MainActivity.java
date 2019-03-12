package tech.burdzi0.threedimensions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ToggleButton toggleButton;
    private Switch aSwitch;
    private Button button;
    private Button buttonThirdActivity;
    private String toastText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = findViewById(R.id.switch2);
        aSwitch.setOnClickListener(progressBarUpdater(aSwitch));

        toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(progressBarUpdater(toggleButton));

        progressBar = findViewById(R.id.progressBar);
        progressBar.setMin(0);
        progressBar.setMax(100);

        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            if (progressBar.getProgress() == 100) {
                startActivity(SecondActivity.class);
            } else {
                toastText = "Fill the progressbar first!";
                Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnLongClickListener(v -> startActivity(SecondActivity.class));

        buttonThirdActivity = findViewById(R.id.button2);
        buttonThirdActivity.setOnClickListener(v -> startActivity(ThirdActivity.class));
    }

    private boolean startActivity(Class<?> activityClass) {
        Intent myIntent = new Intent(this, activityClass);
        this.startActivity(myIntent);
        return true;
    }

    private View.OnClickListener progressBarUpdater(final CompoundButton button) {
        return v -> {
            int halfOfProgressBar = 50;
            int change = button.isChecked() ? halfOfProgressBar : -halfOfProgressBar;
            progressBar.setProgress(progressBar.getProgress() + change, true);
        };
    }

}
