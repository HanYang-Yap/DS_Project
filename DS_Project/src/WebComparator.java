import java.util.Comparator;

public class WebComparator implements Comparator<WebNode> {
	
	public int compare(WebNode o1, WebNode o2) {
		
		if (o1 == null || o2 == null)
			throw new NullPointerException();
		
		if (o1.nodeScore < o2.nodeScore) {
			return 1;
			
		} else if (o1.nodeScore > o2.nodeScore) {
			return -1;
		
		} else {
			 return 0;
		}

	}
}