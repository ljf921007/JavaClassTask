package crawl;

import java.io.IOException;
import java.sql.SQLException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawl1 {
	public static void main(String[] args) throws IOException, SQLException, InterruptedException
	{
		//先定义好要爬取的内容
				String content= null;
		
		//要爬虫网页的url地址
		String url="http://www.ss.pku.edu.cn/index.php/newscenter/news/2091-%E5%8C%97%E4%BA%AC%E5%A4%A7%E5%AD%A6%E8%BD%AF%E4%BB%B6%E4%B8%8E%E5%BE%AE%E7%94%B5%E5%AD%90%E5%AD%A6%E9%99%A2%E5%8F%AC%E5%BC%80%E6%A0%A1%E5%8F%8B%E4%BC%9A%E6%88%90%E7%AB%8B%E5%A4%A7%E4%BC%9A";
		//使用jsoup工具包，要提前定义好Document类别的变量，用来存放网页html代码
		Document document = null;
		//将网页源代码装入document这个变量中
		document = Jsoup.connect(url).get();
		
		//Elements 此类是用来存放划分好的html内容块
		Elements notices = null;
		
		if(document!=null)
		{ 
			//抓取新闻内容 (text()方法是获取标签内的文本内容)
			notices = document.select("div[class=article-content]");
			content = notices.text();
			System.out.println("新闻内容："+content);
		}
	}

}