package yotta.yangkuan;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class QuoraSpider extends Spider{
    public QuoraSpider(PageProcessor pageProcessor) {
        super(pageProcessor);
    }
    public static QuoraSpider create(PageProcessor pageProcessor){
        return new QuoraSpider(pageProcessor);
    }
    public QuoraSpider addRequests(List<Request> requests){
        for(Request request:requests){
            this.addRequest(request);
        }
        return this;
    }
}
