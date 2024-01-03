import java.io.IOException;
import java.util.ArrayList;

public class WebNode
{
	public WebNode parent;
	public ArrayList<WebNode> children;
	public WebPage webPage;
	public double nodeScore;
	public KeywordList keywordList;
	public String url;
	public String name;
	public WordCounter counter;
	public double score;

	
	public WebNode(String name, String url)
	{
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);
		keywordList=new KeywordList();
	}
	
	public void setNodeSocre() throws IOException{
		score = 0;
		for(Keyword k : keywordList.keywords) {
			score += k.weight * counter.countKeyword(k.name);
		}
	}
	
}