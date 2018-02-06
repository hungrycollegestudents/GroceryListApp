package me.brunson.testapplication;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jacob on 1/30/18.
 */

public class API {

    private RequestQueue queue;

    public API(RequestQueue queue) {
        this.queue = queue;
    }

    public void queryItem(String name) {
        String url = String.format(
                "http://api.walmartlabs.com/v1/search?query=%s&sort=price&order=asc&format=json&apiKey=v787ajf5jpa8tm885drd5b2g",
                name);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
            (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONObject item = response.getJSONArray("items").getJSONObject(0);
                        Log.d("idk", String.valueOf(item.getInt("upc")));
                        Log.d("idk", item.getString("name"));
                        Log.d("idk", String.valueOf(item.getDouble("salePrice")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {``

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("idk", error.toString());

                }
            });

        queue.add(jsObjRequest);
    }

}
