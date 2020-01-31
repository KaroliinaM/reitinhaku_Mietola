/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import data.Data;
import data.Stopdata;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

/**
 *
 * @author k
 */
public class ExecuteQuery {
    
    String line, queryString, url;
    
    public Data callApi(String url, String queryString, Stopdata stopdata) {
          

        this.url=url;
        this.queryString=queryString;
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;

        client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader("Content-Type", "application/json");

        JSONObject jsonobj = new JSONObject();
 //       jsonobj.put("query", "{stops {gtfsId name lat lon zoneId}}");
        jsonobj.put("query", queryString);
 
            
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
  //          Stopdata stopdata=new Stopdata();
            Gson gson = new Gson();
            stopdata= gson.fromJson(builder.toString(), 
                            Stopdata.class); 
            

          //  System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopdata.getData();
    }
    
}
