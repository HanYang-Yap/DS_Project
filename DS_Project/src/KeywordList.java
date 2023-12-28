import java.util.*;

public class KeywordList
{
	public ArrayList<Keyword> keywords;

	public KeywordList()
	{
		keywords = new ArrayList<>();
		
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

	public void outputIndex(int i)
	{
		if (i >= keywords.size())
		{
			System.out.println("InvalidOperation");
			return;
		}
		Keyword k = keywords.get(i);
		System.out.println(k);
	}

	

	

	public void printKeywordList(ArrayList<Keyword> kLst)
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

		for (Keyword k : keywords)
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