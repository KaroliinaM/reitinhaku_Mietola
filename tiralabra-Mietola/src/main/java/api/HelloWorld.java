package api;

import ui.FinderUI;
import data.Connection;
import data.Data;
import data.Route;
import data.Stop;
import data.Stopdata;
import data.Stoptime;
import data.Trip;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author k
 */
public class HelloWorld {

    public static void main(String[] args) throws IOException {

        FinderUI ui = new FinderUI();

        ui.run();

        /**
         * ArrayList<Stop> stops=new ArrayList<>();
         *
         * Stop stop = new Stop(); stop.setGtfsId("eka"); stop.setName("nimi");
         * stops.add(stop); Stop stop2 = new Stop(); stop.setGtfsId("toka");
         * stop.setName("toinen"); stops.add(stop2);
         *
         * WriteObjectToFile(stops);
         *
         *
         */
        /**
         * ExecuteQuery query = new ExecuteQuery(); Stopdata stopdata = new
         * Stopdata(); Data routeData; Data stopData; String url =
         * "https://api.digitransit.fi/routing/v1/routers/hsl/index/graphql";
         * String routeQueryString = "{routes { gtfsId shortName longName mode
         * }}"; String stopQueryString= "{stops {gtfsId name lat lon zoneId} }";
         * // String queryString2= "{route(id:\"HSL:4421\") { shortName trips //
         * {gtfsId stoptimes { stop {name} scheduledDeparture serviceDay } } }
         * // }";
         *
         * routeData = query.callApi(url, routeQueryString, stopdata); stopData
         * = query.callApi(url, stopQueryString, stopdata); //query.callApi(url,
         * queryString2, stopdata); List<Route> routes = routeData.getRoutes();
         * HashMap<String, Stop> stops=new HashMap<>(); for(Stop s:
         * stopData.getStops()) { stops.put(s.getGtfsId(), s); }
         *
         * System.out.println(routes.size()); System.out.println(stops.size());
         * int i=10;
         *
         *
         * for (Route r : routes) { System.out.println(r.getGtfsId()); String
         * queryString2 = "{route(id:\"" + r.getGtfsId() + "\") " + "{ shortName
         * trips {gtfsId stoptimes { stop {gtfsId name} " + "scheduledArrival
         * serviceDay } } } }"; Data data2=query.callApi(url, queryString2,
         * stopdata); List<Trip> trips=data2.getRoute().getTrips(); for(Trip t:
         * trips) { List<Stoptime> stoptimes=t.getStoptimes(); Stoptime
         * previous=null; for(Stoptime s: stoptimes) { if(s.getServiceDay()>0)
         * return; if(previous!=null) { Stop
         * stop=stops.get(previous.getStop().getGtfsId()); //
         * System.out.println(stop.getGtfsId()); stop.addConnection(new
         * Connection(previous.getStop().getGtfsId() , s.getStop().getGtfsId(),
         * s.getScheduledArrival())); // System.out.println("pysäkiltä " +
         * previous.getStop().getGtfsId() + " pysäkille " +
         * s.getStop().getGtfsId() + " ajassa " + s.getScheduledArrival()); }
         * previous=s; } } // i--; // if(i<0) break; }
         * System.out.println(stops.get("HSL:1293150").getConnections().size());
         * System.out.println(stops.get("HSL:2643225").getConnections().size());
         * System.out.println("saving..."); WriteObjectToFile(stops); *
         *
         */
        //    System.out.println(data.getRoutes().get(0).getGtfsId()); String
        //    gtfsid = data.getRoutes().get(0).getGtfsId();
        //    String queryString2 = "{route(id:\"" + data.getRoutes().get(0).getGtfsId() 
        //    + "\") " + "{ shortName trips {gtfsId stoptimes { stop {name} " 
        //          + "scheduledDeparture serviceDay }} } }"; 
        //    query.callApi(url, queryString2, stopdata);
        /**
         * String line, queryString, url;
         *
         * url =
         * "https://api.digitransit.fi/routing/v1/routers/hsl/index/graphql";
         * CloseableHttpClient client = null; CloseableHttpResponse response =
         * null;
         *
         * client = HttpClientBuilder.create().build(); HttpPost httpPost = new
         * HttpPost(url);
         *
         * httpPost.addHeader("Content-Type", "application/json");
         *
         * JSONObject jsonobj = new JSONObject(); // jsonobj.put("query",
         * "{stops {gtfsId name lat lon zoneId}}"); jsonobj.put("query",
         * "{routes { gtfsId shortName longName mode }}");
         *
         *
         * try { StringEntity entity = new StringEntity(jsonobj.toString());
         * httpPost.setEntity(entity); response = client.execute(httpPost);
         * System.out.println(response.getEntity());
         *
         * BufferedReader bufReader = new BufferedReader(new
         * InputStreamReader(response.getEntity().getContent())); StringBuilder
         * builder = new StringBuilder();
         *
         * while ((line = bufReader.readLine()) != null) { builder.append(line);
         * builder.append(System.lineSeparator()); } /** Stopdata stopdata=new
         * Stopdata(); Gson gson = new Gson(); stopdata=
         * gson.fromJson(builder.toString(), Stopdata.class); *
         * System.out.println(stopdata.getData().getStops().size()); Stopdata
         * stopdata=new Stopdata(); Gson gson = new Gson(); stopdata=
         * gson.fromJson(builder.toString(), Stopdata.class); *
         * System.out.println(stopdata.getData().getRoutes().size()); *
         * System.out.println(builder); } catch (IOException e) {
         * e.printStackTrace(); }*
         */
    }
    /**
     * public static void WriteObjectToFile(Object serObj) {
     *
     * try {
     *
     * FileOutputStream fileOut = new FileOutputStream(filepath);
     * ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
     * objectOut.writeObject(serObj); objectOut.close(); System.out.println("The
     * Object was succesfully written to a file");
     *
     * } catch (Exception ex) { ex.printStackTrace(); } }
     *
     *
     */
}
