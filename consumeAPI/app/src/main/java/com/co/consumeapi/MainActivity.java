package com.co.consumeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {


    EditText lng, lat, sunrise, lngResponse, countryCode, gmtOffset, rawOffset, sunset, timezoneId, dstOffset, countryName, time, latResponse;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lng = (EditText) findViewById(R.id.lng);
        lat = (EditText) findViewById(R.id.lat);
        sunrise = findViewById(R.id.sunrise);
        lngResponse = findViewById(R.id.lngResponse);
        countryCode = findViewById(R.id.countryCode);
        gmtOffset = findViewById(R.id.gmtOffset);
        rawOffset = findViewById(R.id.rawOffset);
        sunset = findViewById(R.id.sunset);
        timezoneId = findViewById(R.id.timezoneId);
        dstOffset = findViewById(R.id.dstOffset);
        countryName = findViewById(R.id.countryName);
        time = findViewById(R.id.time);
        latResponse = findViewById(R.id.latResponse);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                consultGeoName();
                cleanFields();
            }
        });

    }

    private void cleanFields() {
        lat.setText("");
        lng.setText("");
    }

    private void consultGeoName() {

        String longitude = lng.getText().toString();
        String latitude = lat.getText().toString();

        String url = "http://api.geonames.org/timezoneJSON?formatted=true&lat="+latitude+"&lng="+longitude+"&username=qa_mobile_easy&style=full";


        StringRequest getResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.toString().contains("status")){
                        Toast.makeText(MainActivity.this, jsonObject.getJSONObject("status").getString("message"), Toast.LENGTH_LONG).show();
                    }else{

                        sunrise.setText(jsonObject.getString("sunrise"));
                        lngResponse.setText(jsonObject.getString("lng"));
                        countryCode.setText(jsonObject.getString("countryCode"));
                        gmtOffset.setText(jsonObject.getString("gmtOffset"));
                        rawOffset.setText(jsonObject.getString("rawOffset"));
                        sunset.setText(jsonObject.getString("sunset"));
                        timezoneId.setText(jsonObject.getString("timezoneId"));
                        dstOffset.setText(jsonObject.getString("dstOffset"));
                        countryName.setText(jsonObject.getString("countryName"));
                        time.setText(jsonObject.getString("time"));
                        latResponse.setText(jsonObject.getString("lat"));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(getResquest);
    }
}