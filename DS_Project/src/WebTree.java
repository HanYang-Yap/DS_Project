import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.PriorityQueue;

public class WebTree
{
	//public WebNode root;
	private PriorityQueue<WebNode> heap;
	private ArrayList<WebNode> queue;
	
	public WebTree(ArrayList<WebNode> queue) throws IOException
	{
		this.heap = new PriorityQueue<WebNode>(queue.size(), new WebComparator());
		this.queue = queue;
		for(WebNode w : queue) {
			this.add(w);
			w.setNodeSocre();
		}
		sort();
		
	}
	
	public void sort() {
		Collections.sort(queue, new Comparator<WebNode>() {
			public int compare(WebNode node1,WebNode node2) {
				return Double.compare(node2.score, node1.score);
			}
		});
		
	}
	
	public ArrayList<WebNode> getQueue(){
		return this.queue;
	}
	
	public void add(WebNode k)
	{
		heap.offer(k);
	}

	public void output()
	{
		for(WebNode w:queue) {
			System.out.println(w.name + ", " + w.score+ ", " +w.url);
		}
		
		
	}
	
}