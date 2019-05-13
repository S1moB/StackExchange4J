package utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UtilsFunction {
    public static String getJsonFromLink(String link) throws JSONException {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(link);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        String jsonString  = response.readEntity(String.class);
        client.close();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray questionsJSon = jsonObject.getJSONArray("items");
        return questionsJSon.toString();
    }
}
