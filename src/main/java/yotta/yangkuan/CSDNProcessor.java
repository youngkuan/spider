package yotta.yangkuan;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import util.SqlPipeline;

import java.util.ArrayList;
import java.util.List;

public class CSDNProcessor implements PageProcessor{
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);
    public Site getSite() {
        return site;
    }
    public void process(Page page) {
        //http://so.csdn.net/so/search/s.do?q=%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84&q=%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84
        //爬取碎片
        List<String> urls;
        urls = page.getHtml().xpath("a[contains(@strategy,'search_bc_5_')]").all();
        page.addTargetRequests(urls);
        //article_content
        List<String> fragments = new ArrayList<String>();
        fragments = page.getHtml().xpath("div[@id='article_content']").all();
        page.putField("fragments",fragments);
    }
    public void main(String[] args){
        YangKuanSpider.create(new CSDNProcessor())
                .addRequests(requests)
                .thread(5)
                .addPipeline(new SqlPipeline())
                .runAsync();
    }
}
