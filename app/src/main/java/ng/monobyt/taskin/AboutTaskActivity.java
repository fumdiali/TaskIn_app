package ng.monobyt.taskin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_task);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
