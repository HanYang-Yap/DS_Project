import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.PriorityQueue;

public class WebTree
{
	//public WebNode root;
	private PriorityQueue<WebNode> heap;
	private ArrayList<WebNode> queue;
	
	public WebTree(ArrayList<WebNode> queue)
	{
		//this.root = new WebNode(rootPage);
		this.heap = new PriorityQueue<WebNode>(30, new WebComparator());
		this.queue = queue;
		for(WebNode w : queue) {
			this.add(w);
		}
	
	}
	
	
	public void add(WebNode k)
	{
		heap.offer(k);
	}

	public void output()
	{
		// print the output in order and remove all element
		if (heap.isEmpty()) {
			System.out.println("InvalidOperation");
			return;
		}
		while (!heap.isEmpty())
        {
			
            WebPage k = heap.poll().webPage;
            System.out.println(k.name);
			
        }
	}
	
}