package requests;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import constants.Order;
import constants.Sort;
import models.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchRequest {

    public static final String ITEMS = "items";

    private String searchRequest;
    private SearchRequest(StringBuilder url) {
        searchRequest =url.toString();
    }

    public String getSearchRequest() {
        return searchRequest;
    }


    public List<Question> searchQuestions(){
        List<Question> questions=new ArrayList<Question>();
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(searchRequest);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        try {
            JSONObject jsonObject =new JSONObject(response.readEntity(String.class));
            JSONArray arrJson = jsonObject.getJSONArray(ITEMS);
            questions= new Gson().fromJson(arrJson.toString(), new TypeToken<List<Question>>() {}.getType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        client.close();
        return questions;
    }

    public static class Builder {

        public static final String SEPARATOR = "&";
        private StringBuilder url;



        public Builder(String question){
            url=new StringBuilder("https://api.stackexchange.com/2.2/search/advanced?pagesize=5" )
                .append(SEPARATOR)
                .append("q=")
                .append(question);
        }

        public Builder sort(Sort sort){

            url.append(SEPARATOR)
                .append("sort=")
                .append(sort.getValue());
            return this;
        }

        public Builder order(Order order) throws Exception {
            if (!url.toString().contains("sort"))
             throw new Exception("no sort Propertie");

            url.append(SEPARATOR)
                .append("order=")
                .append(order.getValue());
            return this;
        }

        public SearchRequest build(){
            url.append("&site=stackoverflow&filter=withbody");
            return new SearchRequest(url);
        }

    }


}
