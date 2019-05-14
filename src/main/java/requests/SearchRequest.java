package requests;

import constants.Order;
import constants.Sort;
import constants.StackSite;
import exceptions.StackExchangeException;

public class SearchRequest extends ClientAPI {

    public static final String ITEMS = "items";

    private SearchRequest(StringBuilder url) {
        link = url.toString();
    }

    public static class Builder {

        public static final String SEPARATOR = "&";
        private StringBuilder url;

        public Builder(String question) {
            url = new StringBuilder("https://api.stackexchange.com/2.2/search/advanced?pagesize=5")
                .append(SEPARATOR)
                .append("q=")
                .append(question);
        }

        public Builder sort(Sort sort) {

            url.append(SEPARATOR)
                .append("sort=")
                .append(sort.getValue());
            return this;
        }

        public Builder order(Order order) throws StackExchangeException {
            if (!url.toString().contains("sort")) {
                throw new StackExchangeException("no sort Property");
            }

            url.append(SEPARATOR)
                .append("order=")
                .append(order.getValue());
            return this;
        }

        public Builder addSite(StackSite site) throws StackExchangeException {
            if (url.toString().contains("site")) {
                throw new StackExchangeException("You've already added a site");
            }
            this.url.append(SEPARATOR).append("site=").append(site);
            return this;
        }

        public Builder addBody() throws StackExchangeException {
            if (url.toString().contains("filter")) {
                throw new StackExchangeException("You've already added a filter");
            }
            this.url.append("&filter=withbody");
            return this;
        }

        public SearchRequest build() {
            return new SearchRequest(url);
        }
    }
}
