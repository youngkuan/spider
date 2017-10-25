package yotta.yangkuan;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class ZhihuSpider extends Spider {
    public ZhihuSpider(PageProcessor pageProcessor) {
        super(pageProcessor);
    }
    public static ZhihuSpider create(PageProcessor pageProcessor){
        return new ZhihuSpider(pageProcessor);
    }
    public ZhihuSpider addRequests(List<Request> requests){
        for(Request request:requests){
            this.addRequest(request);
        }
        return this;
    }
}
