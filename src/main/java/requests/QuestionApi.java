package requests;

import static constants.StackExchange.URL;

import java.util.Arrays;
import java.util.stream.Collectors;

import constants.QuestionSort;
import constants.StackQuestionFilter;
import constants.StackSite;
import exceptions.StackExchangeException;
import models.Question;

public class QuestionApi extends ClientAPI {

    public static class Builder {
        private StringBuilder link = new StringBuilder(URL.getValue()).append("questions");
        private StringBuilder params = new StringBuilder();
        private boolean idExist = false;

        public Builder addFilter(StackQuestionFilter param, String value) throws StackExchangeException {
            if (this.params.toString().contains(param.toString())) {
                throw new StackExchangeException("You've already added " + param.toString() + " filter");
            }
            this.params.append("&").append(param).append("=").append(value);
            return this;
        }

        public Builder addSort(QuestionSort questionSort) throws StackExchangeException {
            if (params.toString().contains("sort")) {
                throw new StackExchangeException("You've already added a filter");
            }
            this.params.append("&sort=")
                .append(questionSort.getValue());
            return this;
        }

        public Builder addSite(StackSite site) throws StackExchangeException {
            if (params.toString().contains("site")) {
                throw new StackExchangeException("You've already added a site");
            }
            this.params.append("&site=").append(site);
            return this;
        }

        public Builder addBody() throws StackExchangeException {
            if (params.toString().contains("filter")) {
                throw new StackExchangeException("You've already added a filter");
            }
            this.params.append("&filter=withbody");
            return this;
        }

        public Builder addID(long... ids) throws StackExchangeException {
            if (idExist) {
                throw new StackExchangeException("ID Already exist");
            }
            String idsAsString = String.join(";", Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.toList()));
            link.append("/").append(idsAsString);
            idExist = true;
            return this;
        }

        public Builder answers(long... ids) throws StackExchangeException {
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
