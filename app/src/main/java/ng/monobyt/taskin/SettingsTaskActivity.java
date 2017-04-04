package ng.monobyt.taskin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class SettingsTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_task);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final TextView tv = (TextView) findViewById(R.id.numpickLabel);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numpick);

        //initialize string array for values to choose from
        final String[] values = {"Red","Green","Blue","Orange","Yellow"};

        //populate numpick values
        //set min/max vals for numpick
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(values.length-1);

        //specify numpick data source as array elements
        numberPicker.setDisplayedValues(values);
        //check if selector wheel wraps
        numberPicker.setWrapSelectorWheel(true);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(){
            @Override
            public void onValueChange(NumberPicker picker,int oldVal, int newVal){
                //display user selection
                tv.setText("You sure you want "+values[newVal]+"?");
            }
        });
    }
}
