import java.util.List;

import org.json.JSONException;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import constants.Order;
import constants.Sort;
import generic.RequestObject;
import models.Question;
import requests.SearchRequest;
import utils.UtilsFunction;

public class MainTest {

    public static final String ID = "56108874";

    @Test
    public void mainTest() {
        RequestObject<Question> requestObject=new RequestObject<>();
        SearchRequest searchRequest=null;
        List<Question> questions;
        try {
            searchRequest=new SearchRequest.Builder("collection java").sort(Sort.VOTES).order(Order.DESC).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            questions= requestObject.getObjects(searchRequest);
            System.out.println(questions);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
