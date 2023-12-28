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
		//this.root = new WebNode(rootPage);
		this.heap = new PriorityQueue<WebNode>(queue.size(), new WebComparator());
		this.queue = queue;
		for(WebNode w : queue) {
			this.add(w);
			w.setNodeSocre();
		}
		reorder();
	
	}
	public void reorder() {
        ArrayList<WebNode> origin = new ArrayList<>();
        ArrayList<WebNode> tempList = new ArrayList<>();
        int index = 0;
        WebNode max = origin.get(0);
        for(WebNode w : queue) {
        	if(w.score>max.score) {
        		origin.add(origin.indexOf(max)-1);
        	}
        	
        }
        while (!origin.isEmpty()) {
            for(int i=0; i<origin.size();i++) {
            	
            }
        	
        }
        
    }
	
	
	
	public void reorderHeap() {
        ArrayList<WebNode> tempList = new ArrayList<>();

        while (!heap.isEmpty()) {
            tempList.add(heap.poll());
        }

        // 使用 Collections.sort 並傳入分數的比較器
        Collections.sort(tempList, new ScoreComparator());

        heap.addAll(tempList);
    }

    private static class ScoreComparator implements Comparator<WebNode> {
        @Override
        public int compare(WebNode node1, WebNode node2) {
            // 根據分數由大到小排序
            return Integer.compare((int)node2.score,(int) node1.score);
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
	
}