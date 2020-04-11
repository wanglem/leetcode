import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

class WebCrawler {
    private class HtmlParser {
        public List<String> getUrls(String url){
            return null;
        }
    }
    public List<String> crawl(String startUrl, HtmlParser htmlParser) throws URISyntaxException {
        String hostname = (new URI(startUrl)).getHost();

        Set<String> crawledUnderDomain = new HashSet<>();
        Set<String> crawledOther = new HashSet<>();
        Queue<String> process = new LinkedList<>();
        process.offer(startUrl);

        while(!process.isEmpty()) {
            String next = process.poll();
            if (crawledUnderDomain.contains(next) || crawledOther.contains(next)) continue;

            List<String> thisPageUrls = htmlParser.getUrls(next);
            for (String url: thisPageUrls) {
                URI uri = new URI(url);
                if (uri.getHost().equals(hostname)) {
                    crawledUnderDomain.add(url);
                } else {
                    crawledOther.add(url);
                }
            }
        }
        return new ArrayList<>(crawledUnderDomain);
    }
}