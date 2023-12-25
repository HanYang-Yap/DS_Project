import java.util.*;

public class KeywordList
{
	private LinkedList<Keyword> linkedList;
	private ArrayList<Keyword> lst;

	ArrayList<Keyword> keywords = new ArrayList<>();
	public KeywordList(String name, int weight) {
		
		Keyword hikingTrail = new Keyword("HIKING TRAIL", 5);
		Keyword scenery = new Keyword("SCENARY", 3);
		Keyword nationalPark = new Keyword("NATIONAL PARK", 3);
		Keyword forest = new Keyword("FOREST", 3);
		Keyword climb = new Keyword("CLIMB", 3);
		Keyword guide = new Keyword("GUIDE", 3);
		Keyword hiking = new Keyword("HIKING", 3);
		Keyword nature = new Keyword("NATURE", 4);
		Keyword hundredMountian = new Keyword("100 MOUNTAIN", 2);
		Keyword exercise = new Keyword("EXERCISE", 1);
		Keyword attraction = new Keyword("ATTRACTION", 4);
		Keyword publicTransportation = new Keyword("PUBLIC TRANSPORTATION", 2);
		Keyword equipment = new Keyword("EQUIPMENT", -3);
		Keyword dictionary = new Keyword("DICTIONARY", -10);
		Keyword translate = new Keyword("TRANSLATE", -10);
		Keyword weather = new Keyword("WEATHER", -3);
		Keyword hotSpring = new Keyword("HOT SPRING", -2);
		Keyword dictionary_chinese = new Keyword("字典", -10);
		Keyword translate_chinese = new Keyword("翻譯", -10);
		Keyword meaning = new Keyword("意思", -10);
		
		keywords.add(hikingTrail);
		keywords.add(scenery);
		keywords.add(nationalPark);
		keywords.add(forest);
		keywords.add(climb);
		keywords.add(guide);
		keywords.add(hiking);
		keywords.add(nature);
		keywords.add(hundredMountian);
		keywords.add(exercise);
		keywords.add(attraction);
		keywords.add(publicTransportation);
		keywords.add(equipment);
		keywords.add(dictionary);
		keywords.add(translate);
		keywords.add(dictionary_chinese);
		keywords.add(translate_chinese);
		keywords.add(meaning);
		keywords.add(weather);
		keywords.add(hotSpring);
		
	}
	
	public KeywordList()
	{
		this.linkedList = new LinkedList<Keyword>();
		this.lst = new ArrayList<Keyword>();
	}

	public void add(Keyword keyword)
	{
		lst.add(keyword);
	}

	public void outputIndex(int i)
	{
		if (i >= lst.size())
		{
			System.out.println("InvalidOperation");
			return;
		}
		Keyword k = lst.get(i);
		System.out.println(k);
	}

	public void outputCount(int c)
	{
		LinkedList<Keyword> results = new LinkedList<>();
		for (int i = 0; i < lst.size(); i++)
		{
			Keyword k = lst.get(i);
			if (k.count == c)
			{
				results.add(k);
			}
		}
		if (results.isEmpty())
		{
			System.out.println("NotFound");
		}
		else
		{
			printKeywordList(results);
		}
	}

	public void outputHas(String pattern)
	{
		LinkedList<Keyword> results = new LinkedList<>();
		for (int i = 0; i < lst.size(); i++)
		{
			Keyword k = lst.get(i);
			if (k.name.contains(pattern))
			{
				results.add(k);
			}
		}
		if (results.isEmpty())
		{
			System.out.println("NotFound");
		}
		else
		{
			printKeywordList(results);
		}
	}

	public void outputName(String pattern)
	{
		LinkedList<Keyword> results = new LinkedList<>();
		for (int i = 0; i < lst.size(); i++)
		{
			Keyword k = lst.get(i);
			if (k.name.equals(pattern))
			{
				results.add(k);
			}
		}
		if (results.isEmpty())
		{
			System.out.println("NotFound");
		}
		else
		{
			printKeywordList(results);
		}
	}

	public void outputFirstN(int n)
	{
		if (n > lst.size())
		{
			System.out.println("InvalidOperation");
			return;
		}
		LinkedList<Keyword> found = new LinkedList<>();

		for (int i = 0; i < n; i++)
		{
			Keyword k = lst.get(i);
			found.add(k);
		}
		printKeywordList(found);
	}

	public void outputScore()
	{
		float results = 0;
		// YOUR TURN
		// 2.To calculate all keyword's count*weight
		for(int i=0;i<lst.size();i++) {
			results+=lst.get(i).count*lst.get(i).weight;
		}

		System.out.println(results);
	}

	public void deleteIndex(int i)
	{
		if (i >= lst.size())
		{
			return;
		}
		lst.remove(i);
	}

	public void deleteCount(int c)
	{
		// In the following methods, you can use the way similar to that in the
		// previous output method and integrate the provided code, or use your own way.

//		LinkedList<Keyword> found = new LinkedList<>();
//		if (!found.isEmpty())
//		{
//			lst.removeAll(found);
//		}

		// YOUR TURN
		// 3. remove nodes that the count is equal to c
		for(int i=lst.size()-1;i>=0;i--) {
			if(lst.get(i).count==c) {
				lst.remove(i);
			}
		}

	}

	public void deleteHas(String pattern)
	{
		// YOUR TURN
		// 4. remove nodes that the name contains input name
		for(int i=0;i<lst.size();i++) {
			if(lst.get(i).name.contains(pattern)) {
				lst.remove(i);
			}
		}

	}

	public void deleteName(String name)
	{
		// YOUR TURN
		// 5. remove nodes that the name is equal to input name
		for(int i=0;i<lst.size();i++) {
			if(lst.get(i).name.equals(name)) {
				lst.remove(i);
			}
		}

	}

	public void deleteFirstN(int n)
	{
		// YOUR TURN
		// 6. remove first n nodes
		for(int i=0;i<=n;i++) {
			lst.remove(i);
		}

	}

	public void deleteAll()
	{
		linkedList = new LinkedList<Keyword>();
	}

	private void printKeywordList(LinkedList<Keyword> kLst)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < kLst.size(); i++)
		{
			Keyword k = kLst.get(i);
			if (i > 0)
				sb.append(" ");
			sb.append(k.toString());
		}
		System.out.println(sb.toString());
	}
	
	public void find(String s)
	{
		int maxValue = -1;
		Keyword LCS = null;

		for (Keyword k : lst)
		{
			int lcs = findLCS(k.name, s);

			if (lcs > maxValue)
			{
				maxValue = lcs;
				LCS = k;
			}
		}
		System.out.println(s + ": " + LCS.toString());
	}

	// YOUR TURN
	// 1. Implement the LCS algorithm
	// Return the length of lcs

	public int findLCS(String x, String y)
	{
		 int m = x.length();
		    int n = y.length();

		    int[][] dp = new int[m + 1][n + 1];

		    for (int i = 0; i <= m; i++) {
		        for (int j = 0; j <= n; j++) {
		            if (i == 0 || j == 0) {
		                dp[i][j] = 0;
		            } else if (x.charAt(i - 1) == y.charAt(j - 1)) {
		                dp[i][j] = dp[i - 1][j - 1] + 1;
		            } else {
		                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
		            }
		        }
		    }

		    return dp[m][n];
		
	}

	private void printMatrix(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j] + " ");
				if (j == matrix[0].length - 1)
					System.out.print("\n");
			}
		}
	}
}