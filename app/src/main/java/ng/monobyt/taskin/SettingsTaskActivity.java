package ng.monobyt.taskin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_task);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
