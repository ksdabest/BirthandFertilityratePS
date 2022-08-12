package sg.edu.rp.c346.id21021230.birthandfertilityrateps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvBirthRate;
    AsyncHttpClient client;

    ArrayList<birthRate> alBirthRate;
    ArrayAdapter<birthRate> aaBirthRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvBirthRate = findViewById(R.id.lvBirthRate);
        client = new AsyncHttpClient();
    }
    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<birthRate> alBirthRate = new ArrayList<birthRate>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=55f8c651-6c18-4017-b1f4-f4c4b65785e2&limit=15", new JsonHttpResponseHandler() {

            String level_1;
            Double value;
            int year;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonObjectResults = response.getJSONObject("result");
                    JSONArray jsonArrRecords = jsonObjectResults.getJSONArray("records");
                   // JSONObject jsonArrRecords = firstArr.getJSONObject("value");

                    for(int i = 0; i < jsonArrRecords.length(); i++) {
                        JSONObject jsonObjectRecord = jsonArrRecords.getJSONObject(i);
                        level_1 = jsonObjectRecord.getString("level_1");
                        value = jsonObjectRecord.getDouble("value");
                        year = jsonObjectRecord.getInt("year");
                        birthRate birthRate = new birthRate(level_1, value, year);
                        alBirthRate.add(birthRate);
                    }
                }
                catch(JSONException e){

                }

                //POINT X – Code to display List View

                ArrayAdapter adapter = new ArrayAdapter<birthRate>(MainActivity.this,
                        android.R.layout.simple_list_item_1, alBirthRate);

                lvBirthRate.setAdapter(adapter);
            }//end onSuccess
        });
    }//end onResume


}

