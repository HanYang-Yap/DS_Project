import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.LinkedList;
import java.util.Queue;

public class GoogleQuery 
{
	public String searchKeyword;
	public String url;
	public String content;
	public ArrayList<WebNode> queue;
	public ArrayList<String> titleList = new ArrayList<>();
	
	public GoogleQuery(String searchKeyword)
	{
		this.queue = new ArrayList<WebNode>();
		this.searchKeyword = searchKeyword+"爬山";
		try 
		{
			// This part has been specially handled for Chinese keyword processing. 
			String encodeKeyword=java.net.URLEncoder.encode(this.searchKeyword,"utf-8");
			this.url = "https://www.google.com/search?q="+encodeKeyword+"&oe=utf8&num=20";

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private String fetchContent() throws IOException
	{
		String retVal = "";
		
		this.url = this.url.replaceAll("%25", "%");
		
		URL u = new URL(this.url);
		URLConnection conn = u.openConnection();
		//set HTTP header 
		conn.setRequestProperty("User-agent", "Chrome/107.0.5304.107");
		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in, "utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line = bufReader.readLine()) != null)
		{
			retVal += line;
		}
		return retVal;
	}
	
	public LinkedHashMap<String, String> query() throws IOException
	{
		if(content == null)
		{
			content = fetchContent();
		}
		
		//using Jsoup analyze html string
		Document doc = Jsoup.parse(content);
		
		//select particular element(tag) which you want 
		Elements lis = doc.select("div");
		lis = lis.select(".kCrYT");
		
		
		for(Element li : lis)
		{
			try 
			{
				String href = li.select("a").get(0).attr("href").replace("/url?q=", "");
				String title = li.select("a").get(0).select(".vvjwJb").text();
//				String citeUrl = li.select("a").get(0).absUrl("href");
				int saIndex = href.indexOf("&sa=");
				if (saIndex != -1) {
				    // 如果找到了"&sa="，截取"&sa="之前的部分
				    href = href.substring(0, saIndex);
				}
				// 替換"/url?q="為空字符串
				String citeUrl = href.replace("/url?q=", "");
				citeUrl = href.replace("%25", "%");
				if(citeUrl.contains("https://tw.dictionary.yahoo.com/dictionary%3Fp%3D")) {
					citeUrl = href.replace("https://tw.dictionary.yahoo.com/dictionary%3Fp%3D", "https://tw.dictionary.search.yahoo.com/search?p=");
				}
				//
				if(title.equals("")) 
				{
					continue;
				}
				System.out.println("Title: " + title + " , url: " + citeUrl);
				
				queue.add(new WebNode(title, citeUrl));
				titleList.add(title);

			} catch (IndexOutOfBoundsException e) 
			{
//				e.printStackTrace();
			}
		}
		

		
		KeywordList keywords=new KeywordList();
		WebTree webTree = new WebTree(this.queue);
		webTree.output();
		
		LinkedHashMap<String, String> retVal = new LinkedHashMap<String, String>();
		for(WebNode w : webTree.getQueue()) {
			retVal.put(w.name,w.url);
		}
		
		return retVal;
	}
}