package ng.monobyt.taskin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    Button btn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,items);
        lvItems.setAdapter(itemsAdapter);

        //items.add("Task 1");
        //items.add("Task 2");

        //call long click listener method
        setupListViewListener();
    }//endof onCreate

    //add items to list
    public void addItem(View v){
        EditText editText = (EditText) findViewById(R.id.etNewItem);
        String itemText = editText.getText().toString();
         itemsAdapter.add(itemText);
        editText.setText(" ");
    }

    //attaches a long click listener to the listview
    public void setupListViewListener(){
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener(){
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item,int pos, long id){
                        //remove item in array
                        items.remove(pos);
                        //refresh adapter
                        itemsAdapter.notifyDataSetChanged();
                        //return true consumes long click
                        return true;
                    }
                });

    }//end of long click listener


    // options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about:
                Intent about = new Intent(this, AboutTaskActivity.class);
                startActivity(about);
                return true;
            case R.id.set:
                Intent set = new Intent(this, SettingsTaskActivity.class);
                startActivity(set);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
