package crawl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawl {
	public static void main(String[] args) throws IOException, SQLException, InterruptedException
	{
		//先定义好要爬取的内容
		String title= null;
		String content= null;
		String website= null;
		
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
			
			
			//抓取新闻标题 (select()方法中可通过">"符号逐层深入标签的内部,比如：要选择标签A里面B标签的内容，写成select("A>B")即可)
			notices = document.select("ul[class=breadcrumb clearfix]>li");
			title = notices.get(4).text();
			System.out.println("新闻题目："+title);
			
			//抓取新闻url地址 (attr()方法是获取属性的内容)
			notices = document.select("head>base");
			website = notices.attr("href");
			System.out.println("新闻网址："+website);

			
		}
		
		
	}

}