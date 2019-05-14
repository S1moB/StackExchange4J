import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import constants.Order;
import constants.Sort;
import constants.StackQuestionFilter;
import constants.StackSite;
import exceptions.StackExchangeException;
import generic.RequestObject;
import models.Answer;
import models.Question;
import requests.QuestionApi;
import requests.SearchRequest;
import utils.UtilsFunction;

public class MainTest {

    public static final String ID = "56108874";

    @Test
    public void searchRequestTest() throws StackExchangeException, JSONException {
        RequestObject<Question> requestObject = new RequestObject<>();
        SearchRequest searchRequest = new SearchRequest.Builder("collection java")
            .sort(Sort.RELEVANCE)
            .order(Order.DESC)
            .addSite(StackSite.StackOverflow)
            .addBody().build();
        List<Question> questions = requestObject.getObjects(searchRequest);
        Assert.assertTrue(!questions.isEmpty());
    }
    @Test
    public void questionTest() throws StackExchangeException, JSONException {
        RequestObject<Question> requestObject = new RequestObject<>();
        QuestionApi questionRequest = new QuestionApi.Builder()
            .addFilter(StackQuestionFilter.pagesize,"5")
            .addSite(StackSite.StackOverflow)
            .addBody().build();
        List<Question> questions = requestObject.getObjects(questionRequest);
        Assert.assertTrue(!questions.isEmpty());
    }
    @Test
    public void AnswerTest() throws StackExchangeException, JSONException {
        RequestObject<Answer> requestObject = new RequestObject<>();
        QuestionApi answerRequest = new QuestionApi.Builder()
            .answers(3730019)
            .addFilter(StackQuestionFilter.order,"asc")
            .addSite(StackSite.StackOverflow)
            .addBody().build();
        List<Answer> answers = requestObject.getObjects(answerRequest);
        Assert.assertTrue(!answers.isEmpty());
    }
}
