import java.util.*;

public class KeywordList
{
	private LinkedList<Keyword> lst;
	private ArrayList<Keyword> lst;

	public KeywordList()
	{
		this.lst = new LinkedList<Keyword>();
		this.lst = new ArrayList<Keyword>();
	}

	public void add(Keyword keyword)
	{
		// YOUR TURN
		// 1.add keyword to proper index base on its count.
		// ASCENDING SORT BY COUNT AND WEIGHT
		// You can use printKeywordList(lst) to check if elements are sorted
		boolean inserted=false;
		for (int i = 0; i < lst.size(); i++)
		{
			Keyword k = lst.get(i);
			if (keyword.count < k.count)
			{	lst.add(i,keyword);
				inserted=true;
				break;
				// If the count is smaller than the original, place it in the front.
				// If their count are same, smaller weight placed in the front
			}else if( keyword.count==k.count) 
			{	if(keyword.weight<=k.weight) {
				lst.add(i,keyword);
				inserted=true;
				break;
				}	
			}
		}
		if(!inserted) 
		{
			lst.add(keyword);
		}
		
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
		lst = new LinkedList<Keyword>();
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