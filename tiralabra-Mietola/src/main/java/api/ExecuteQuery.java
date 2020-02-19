package api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import data.Connection;
import data.Stop;

/**
 *
 * @author k
 */
public class ExecuteQuery {

    String line, queryString, url;
    private static final String filepath = "./obj";

    public HashMap<String, Stop> loadStopData() {
        HashMap<String, Stop> st = (HashMap<String, Stop>) readObjectFromFile(filepath);
  //      System.out.println(st.get("HSL:1293150").getConnections().size());
        return st;
    }

    public void saveStopData() {
        ExecuteQuery query = new ExecuteQuery();
        Stopdata stopdata = new Stopdata();
        Data routeData;
        Data stopData;
        String url = "https://api.digitransit.fi/routing/v1/routers/hsl/index/graphql";
        String routeQueryString = "{routes { gtfsId shortName longName mode }}";
        String stopQueryString = "{stops {gtfsId name lat lon zoneId} }";
        //  String queryString2= "{route(id:\"HSL:4421\") { shortName trips
        //  {gtfsId stoptimes { stop {name} scheduledDeparture serviceDay } } }
        //  }";

        routeData = query.callApi(url, routeQueryString, stopdata);
        stopData = query.callApi(url, stopQueryString, stopdata);
        //query.callApi(url, queryString2, stopdata); 
        List<Route> routes = routeData.getRoutes();
        HashMap<String, Stop> stops = new HashMap<>();
        for (Stop s : stopData.getStops()) {
            stops.put(s.getGtfsId(), s);
        }

        System.out.println(routes.size());
        System.out.println(stops.size());
        int i = 10;

        for (Route r : routes) {
            System.out.println(r.getGtfsId());
            String queryString2 = "{route(id:\"" + r.getGtfsId() + "\") "
                    + "{ shortName trips {gtfsId stoptimes { stop {gtfsId name} " 
                    + "scheduledDeparture scheduledArrival serviceDay } } } }";
            Data data2 = query.callApi(url, queryString2, stopdata);
            List<Trip> trips = data2.getRoute().getTrips();
            for (Trip t : trips) {
                List<Stoptime> stoptimes = t.getStoptimes();
                Stoptime previous = null;
                for (Stoptime s : stoptimes) {
                    if (s.getServiceDay() > 0) {
                        return;
                    }
                    if (previous != null) {
                        Stop stop = stops.get(previous.getStop().getGtfsId());
                        //         System.out.println(stop.getGtfsId());
                        stop.addConnection(new Connection(previous.getStop().getGtfsId(), 
                                s.getStop().getGtfsId(), s.getScheduledDeparture(),
                                s.getScheduledArrival(), r.getShortName()));
                        //           System.out.println("pysäkiltä " + 
                        //previous.getStop().getGtfsId() +  
                        //" pysäkille " + s.getStop().getGtfsId() + " ajassa " 
                        //+ s.getScheduledArrival());
                    }
                    previous = s;
                }
            }
            //    i--;
            //    if(i<0) break;
        }
    //    System.out.println(stops.get("HSL:1293150").getConnections().size());
    //    System.out.println(stops.get("HSL:2643225").getConnections().size());
        System.out.println("saving...");
        writeObjectToFile(stops);
    }

    public static Object readObjectFromFile(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Data callApi(String url, String queryString, Stopdata stopdata) {
        this.url = url;
        this.queryString = queryString;
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

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(response.getEntity()
                    .getContent()));
            StringBuilder builder = new StringBuilder();

            while ((line = bufReader.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
            //          Stopdata stopdata=new Stopdata();
            Gson gson = new Gson();
            stopdata = gson.fromJson(builder.toString(),
                    Stopdata.class);

            //  System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopdata.getData();
    }

    public static void writeObjectToFile(Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
