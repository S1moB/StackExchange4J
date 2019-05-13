package generic;

import static utils.UtilsFunction.getJsonFromLink;

import java.util.List;

import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.Question;
import questions.ClientAPI;
import questions.QuestionApi;

public class RequestObject<T> {

    public List<T> getObjects(ClientAPI questionApi, TypeToken type) throws JSONException {
        String questionsJson = getJsonFromLink(questionApi.getLink());
        List<T> objects = new Gson().fromJson(questionsJson, getTypeFromApi(questionApi).getType());
        return objects;
    }
    private TypeToken getTypeFromApi(ClientAPI questionApi)
    {
        TypeToken type = new TypeToken<List>(){};
        if(questionApi instanceof QuestionApi)
        {
            type = new TypeToken<List<Question>>(){};
        }
        return type;
    }

}
