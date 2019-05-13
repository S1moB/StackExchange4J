package requests;

import static constants.StackExchange.URL;

import java.util.Arrays;
import java.util.stream.Collectors;

import constants.StackQuestionFilter;
import constants.StackSite;

public class QuestionApi extends ClientAPI {


    public static class Builder {
        private StringBuilder link = new StringBuilder(URL.getValue() + "questions");
        private StringBuilder params = new StringBuilder();
        private boolean idExist = false;
        public Builder addFilter(StackQuestionFilter param, String value) {
            this.params.append("&").append(param).append("=").append(value);
            return this;
        }

        public Builder addSite(StackSite site) throws Exception {
            if (params.toString().contains("site")) {
                throw new Exception("You've already added a site");
            }
            this.params.append("&site=").append(site);
            return this;
        }

        public Builder addBody() throws Exception {
            if (params.toString().contains("filter")) {
                throw new Exception("You've already added a filter");
            }
            this.params.append("&filter=withbody");
            return this;
        }

        public Builder addID(long... ids) throws Exception {
            if(idExist)
                throw new Exception("Id Already exist");
            String idsAsString = String.join(";", Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.toList()));
            link.append(idsAsString);
            idExist = true;
            return this;
        }

        public Builder answers(long... ids) throws Exception {
            addID(ids);
            link.append("/answers");
            return this;
        }

        public QuestionApi build() {
            link.append("?").append(params.toString());
            return new QuestionApi(this);
        }
    }

    private QuestionApi(Builder builder) {
        this.link = builder.link.toString();
    }

}
