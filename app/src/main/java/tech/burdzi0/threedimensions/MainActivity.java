package tech.burdzi0.threedimensions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ToggleButton toggleButton;
    private Switch aSwitch;
    private Button button;

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

        button.setOnLongClickListener(secondActivityLongClickListener());
    }

    private View.OnLongClickListener secondActivityLongClickListener() {
        return new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                createSecondActivity();
                return true;
            }
        };
    }

    private void createSecondActivity() {
        Intent myIntent = new Intent(this, SecondActivity.class);
        this.startActivity(myIntent);
    }

    private View.OnClickListener progressBarUpdater(final CompoundButton button) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int halfOfProgressBar = 50;
                int change = button.isChecked() ? halfOfProgressBar : -halfOfProgressBar;
                progressBar.setProgress(progressBar.getProgress() + change, true);
            }
        };
    }




}
