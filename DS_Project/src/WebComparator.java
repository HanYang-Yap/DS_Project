import java.util.Comparator;

public class WebComparator implements Comparator<WebNode> {
	
	public int compare(WebNode o1, WebNode o2) {
	    if (o1 == null || o2 == null)
	        throw new NullPointerException();

	    return Integer.compare((int)o1.nodeScore,(int) o2.nodeScore);
	}

}