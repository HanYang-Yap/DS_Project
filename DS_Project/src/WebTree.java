import java.io.IOException;
import java.util.ArrayList;
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
		//this.root = new WebNode(rootPage);
		this.heap = new PriorityQueue<WebNode>(30, new WebComparator());
		this.queue = queue;
		for(WebNode w : queue) {
			this.add(w);
			w.setNodeSocre();
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
            WebNode k = heap.poll();
            System.out.println(k.name + ", " + k.score);
			
        }
	}
	
}//https://dictionary.cambridge.org/zht/%E8%A9%9E%E5%85%B8/%E8%8B%B1%E8%AA%9E-%E6%BC%A2%E8%AA%9E-%E7%B9%81%E9%AB%94/mountain#google_vignette