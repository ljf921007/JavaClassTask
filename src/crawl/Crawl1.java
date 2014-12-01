package crawl;

import java.io.IOException;
import java.sql.SQLException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawl1 {
	public static void main(String[] args) throws IOException, SQLException, InterruptedException
	{
		//�ȶ����Ҫ��ȡ������
				String content= null;
		
		//Ҫ������ҳ��url��ַ
		String url="http://www.ss.pku.edu.cn/index.php/newscenter/news/2091-%E5%8C%97%E4%BA%AC%E5%A4%A7%E5%AD%A6%E8%BD%AF%E4%BB%B6%E4%B8%8E%E5%BE%AE%E7%94%B5%E5%AD%90%E5%AD%A6%E9%99%A2%E5%8F%AC%E5%BC%80%E6%A0%A1%E5%8F%8B%E4%BC%9A%E6%88%90%E7%AB%8B%E5%A4%A7%E4%BC%9A";
		//ʹ��jsoup���߰���Ҫ��ǰ�����Document���ı��������������ҳhtml����
		Document document = null;
		//����ҳԴ����װ��document���������
		document = Jsoup.connect(url).get();
		
		//Elements ������������Ż��ֺõ�html���ݿ�
		Elements notices = null;
		
		if(document!=null)
		{ 
			//ץȡ�������� (text()�����ǻ�ȡ��ǩ�ڵ��ı�����)
			notices = document.select("div[class=article-content]");
			content = notices.text();
			System.out.println("�������ݣ�"+content);
		}
	}

}