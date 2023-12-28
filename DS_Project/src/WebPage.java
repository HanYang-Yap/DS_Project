import java.io.IOException;
import java.util.ArrayList;

public class WebPage
{
	public String url;
	public String name;
	public WordCounter counter;
	public double score;

	public WebPage(String name, String url)
	{
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);
	}

	public void setScore(ArrayList<Keyword> keywords) throws IOException
	{	System.out.println("this is set score");
		score = 0;
		for(Keyword k : keywords) {
			score += k.weight * counter.countKeyword(k.name);
			System.out.println(counter.countKeyword(k.name));
		}
		
	}
}