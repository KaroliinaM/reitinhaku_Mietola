package api;

import data.Stop;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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

    private static final String filepath = "./obj";

    public static void main(String[] args) {
        
        ArrayList<Stop> st = (ArrayList<Stop>) ReadObjectFromFile(filepath);
        System.out.println(st.get(0).getGtfsId());
 /**   ArrayList<Stop> stops=new ArrayList<>();

        Stop stop = new Stop();
        stop.setGtfsId("eka");
        stop.setName("nimi");
        stops.add(stop);
        Stop stop2 = new Stop();
        stop.setGtfsId("toka");
        stop.setName("toinen");
                stops.add(stop2);

        WriteObjectToFile(stops);

        /**
         * ExecuteQuery query = new ExecuteQuery(); Stopdata stopdata = new
         * Stopdata(); Data data; String url =
         * "https://api.digitransit.fi/routing/v1/routers/hsl/index/graphql";
         * String queryString = "{routes { gtfsId shortName longName mode }}";
         * // String queryString2= "{route(id:\"HSL:4421\") { shortName trips
         * {gtfsId stoptimes //{ stop {name} scheduledDeparture serviceDay } } }
         * }";
         *
         * data = query.callApi(url, queryString, stopdata);
         * //query.callApi(url, queryString2, stopdata); List<Route> routes =
         * data.getRoutes(); for (Route r : routes) {
         * //System.out.println(r.getGtfsId()); String queryString2 =
         * "{route(id:\"" + r.getGtfsId() + "\") " + "{ shortName trips {gtfsId
         * stoptimes { stop {name} " + "scheduledDeparture serviceDay } } } }";
         * query.callApi(url, queryString2, stopdata); }
         *
         * System.out.println(data.getRoutes().get(0).getGtfsId()); String
         * gtfsid = data.getRoutes().get(0).getGtfsId();
         *
         * String queryString2 = "{route(id:\"" +
         * data.getRoutes().get(0).getGtfsId() + "\") " + "{ shortName trips
         * {gtfsId stoptimes { stop {name} " + "scheduledDeparture serviceDay }
         * } } }"; query.callApi(url, queryString2, stopdata);
         *
         * /**
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

    public static void WriteObjectToFile(Object serObj) {

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

    public static Object ReadObjectFromFile(String filepath) {

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
}
