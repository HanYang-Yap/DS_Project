import java.util.*;

public class KeywordList
{
	public ArrayList<Keyword> keywords;

	public KeywordList()
	{
		keywords = new ArrayList<>();
		setKword();
		
	}
	public void setKword() {
		
		keywords.add(new Keyword("HIKING TRAIL", 5));
		keywords.add(new Keyword("SCENARY", 3));
		keywords.add(new Keyword("NATIONAL PARK", 3));
		keywords.add(new Keyword("FOREST", 3));
		keywords.add(new Keyword("CLIMB", 3));
		keywords.add(new Keyword("GUIDE", 3));
		keywords.add(new Keyword("HIKING", 3));
		keywords.add(new Keyword("NATURE", 4));
		keywords.add(new Keyword("100 MOUNTAIN", 2));
		keywords.add(new Keyword("EXERCISE", 1));
		keywords.add(new Keyword("ATTRACTION", 4));
		keywords.add(new Keyword("PUBLIC TRANSPORTATION", 2));
		keywords.add(new Keyword("EQUIPMENT", -3));
		keywords.add(new Keyword("DICTIONARY", -10));
		keywords.add(new Keyword("TRANSLATE", -10));
		keywords.add(new Keyword("WEATHER", -3));
		keywords.add(new Keyword("翻譯", -10));
		keywords.add(new Keyword("意思", -10));
		keywords.add(new Keyword("字典", -10));
		keywords.add(new Keyword("HOT SPRING", -2));
		
	}
	public void add(Keyword kw) {
		keywords.add(kw);
		
	}
	
}