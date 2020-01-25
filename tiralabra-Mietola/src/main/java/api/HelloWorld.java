package api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k
 */
import reittiopas.Stopdata;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONObject;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson; 
import java.util.*;

public class HelloWorld {

    public static void main(String[] args) {

         String line, queryString, url;

        url = "https://api.digitransit.fi/routing/v1/routers/hsl/index/graphql";
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;

        client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader("Content-Type", "application/json");

        JSONObject jsonobj = new JSONObject();
        jsonobj.put("query", "{stops {gtfsId name lat lon zoneId}}");
        try {
            StringEntity entity = new StringEntity(jsonobj.toString());
            httpPost.setEntity(entity);
            response = client.execute(httpPost);
            System.out.println(response.getEntity());

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder builder = new StringBuilder();

            while ((line = bufReader.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
           // String stops=builder.toString().substring(builder.toString().indexOf("["), builder.toString().indexOf("]"));
            JsonObject jsonObject = new JsonParser().parse(builder.toString()).getAsJsonObject();
            Stopdata stopdata=new Stopdata();
            Gson gson = new Gson();
            stopdata= gson.fromJson(builder.toString(), 
                            Stopdata.class); 
            
            System.out.println(stopdata.getData().getStops().size());

            System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}