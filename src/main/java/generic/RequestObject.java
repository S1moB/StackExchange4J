package generic;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.Answer;
import models.Question;
import org.json.JSONException;
import requests.ClientAPI;
import requests.QuestionApi;
import requests.SearchRequest;

import java.util.List;

import static utils.UtilsFunction.getJsonFromLink;

public class RequestObject<T> {

    public List<T> getObjects(ClientAPI questionApi) throws JSONException {
        String questionsJson = getJsonFromLink(questionApi.getLink());
        List<T> objects = new Gson().fromJson(questionsJson, getTypeFromApi(questionApi).getType());
        return objects;
    }
    private TypeToken getTypeFromApi(ClientAPI questionApi)
    {
        TypeToken type = new TypeToken<List>(){};
        if(questionApi instanceof QuestionApi)
        {
            if(((QuestionApi) questionApi).getLink().contains("answer"))
                type = new TypeToken<List<Answer>>(){};
            else
                type = new TypeToken<List<Question>>(){};
        }
        else if(questionApi instanceof SearchRequest){
            type=new TypeToken<List<Question>>(){};
        }
        return type;
    }

}
