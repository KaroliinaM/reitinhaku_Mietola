package api;

import java.util.*;
import data.Data;
import data.Route;
import data.Stopdata;

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

    public static void main(String[] args) {

        ExecuteQuery query = new ExecuteQuery();
        Stopdata stopdata = new Stopdata();
        Data data;
        String url = "https://api.digitransit.fi/routing/v1/routers/hsl/index/graphql";
        String queryString = "{routes { gtfsId shortName longName mode }}";
        //      String queryString2= "{route(id:\"HSL:4421\") { shortName trips {gtfsId stoptimes
        //{ stop {name} scheduledDeparture serviceDay } } } }";

        data = query.callApi(url, queryString, stopdata);
        //query.callApi(url, queryString2, stopdata);
        List<Route> routes = data.getRoutes();
        for (Route r : routes) {
            //System.out.println(r.getGtfsId());
            String queryString2 = "{route(id:\"" + r.getGtfsId() + "\") "
                    + "{ shortName trips {gtfsId stoptimes { stop {name} "
                    + "scheduledDeparture serviceDay } } } }";
            query.callApi(url, queryString2, stopdata);
        }

        System.out.println(data.getRoutes().get(0).getGtfsId());
        String gtfsid = data.getRoutes().get(0).getGtfsId();

        String queryString2 = "{route(id:\"" + data.getRoutes().get(0).getGtfsId() + "\") "
                + "{ shortName trips {gtfsId stoptimes { stop {name} "
                + "scheduledDeparture serviceDay } } } }";
        query.callApi(url, queryString2, stopdata);

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
         * gson.fromJson(builder.toString(), Stopdata.class);          *
         * System.out.println(stopdata.getData().getStops().size()); Stopdata
         * stopdata=new Stopdata(); Gson gson = new Gson(); stopdata=
         * gson.fromJson(builder.toString(), Stopdata.class);          *
         * System.out.println(stopdata.getData().getRoutes().size());          *
         * System.out.println(builder); } catch (IOException e) {
         * e.printStackTrace();
        }*
         */
    }
}
