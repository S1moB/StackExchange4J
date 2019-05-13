import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.reflect.TypeToken;

import constants.StackQuestionFilter;
import constants.StackSite;
import generic.RequestObject;
import models.Question;
import questions.ClientAPI;
import questions.QuestionApi;

public class Test {
    public static void main(String[] args) throws Exception {

        ClientAPI questionApi = new QuestionApi.Builder().addFilter(StackQuestionFilter.order,"asc").addSite(StackSite.StackOverflow).addBody().build();
        RequestObject<Question> questionRequestObject = new RequestObject<>();
        questionRequestObject.getObjects(questionApi,new TypeToken<List<Question>>(){});
    }
    public static void testing (long ... tests)
    {
        System.out.println(String.join(";", Arrays.stream(tests).mapToObj(String::valueOf).collect(Collectors.toList())));
    }
}
