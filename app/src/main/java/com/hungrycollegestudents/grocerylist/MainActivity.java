package com.hungrycollegestudents.grocerylist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());

        //Get text view display object (from activity_main.xml)
        final TextView textView = findViewById(R.id.textView);

        //Create object that adapts http json API (probably should change to singleton)
        APIAdapter api = new APIAdapter(queue);

        //Run the search. Pass in a "search listener" object with an onComplete() method.
        //Since the search is asynchronous, it will call onComplete() with an Item object when its finished
        api.queryItem("bread", new APIAdapter.SearchListener() {

            @Override
            public void onComplete(Item item) {
                //This method will be run when the search is finished.
                //item is an Item object. It will be the top/first item returned from the search

                //Set the text on the view
                String text = "from API: " +  item.getName() + " $" + item.getPrice();
                textView.setText(text);
            }

        });


    }

}
