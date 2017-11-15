package yotta.yangkuan;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import util.Config;
import util.ProcessorSQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);
    public Site getSite() {
        return site;
    }
    public void process(Page page) {
        List<String> fragments = new ArrayList<String>();
        fragments = page.getHtml().xpath("div[@id='article_content']").all();
        page.putField("fragments",fragments);
    }
    public static void main(String[] args){
        //测试
        //String test_url =  "http://blog.csdn.net/haolexiao/article/details/54989306";
        String test_url = "http://so.csdn.net/so/search/s.do?q=%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84&q=%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84";
        YangKuanSpider.create(new TestProcessor())
                //.addRequests(requests)
                .addUrl(test_url)
                .thread(5)
                //.addPipeline(new SqlPipeline())
                .addPipeline(new ConsolePipeline())
                .runAsync();
    }
}
