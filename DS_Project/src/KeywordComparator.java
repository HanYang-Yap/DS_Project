import java.util.Comparator;

public class KeywordComparator implements Comparator<Keyword> {
	
	@Override
	public int compare(Keyword o1, Keyword o2) {
		
		if (o1 == null || o2 == null)
			throw new NullPointerException();
		
		if (o1.getCount() < o2.getCount()) {
			return -1;
			
		} else if (o1.getCount() > o2.getCount()) {
			return 1;
		
		} else {
			 return 0;
		}

	}
}