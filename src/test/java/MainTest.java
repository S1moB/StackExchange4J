import org.junit.Test;

import constants.Order;
import constants.Sort;
import requests.SearchRequest;

public class MainTest {

    public static final String ID = "56108874";

    @Test
    public void mainTest() {
        SearchRequest searchRequest=null;
        try {
            searchRequest=new SearchRequest.Builder("collection java").sort(Sort.VOTES).order(Order.DESC).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(searchRequest.searchQuestions());
    }
}
