import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.PriorityQueue;

public class WebTree
{
	//public WebNode root;
	private PriorityQueue<WebNode> heap;

	public WebTree()
	{
		//this.root = new WebNode(rootPage);
		this.heap = new PriorityQueue<WebNode>(10, new WebComparator());
	}
	
	
	public void add(WebNode k)
	{
		heap.offer(k);
	}

	public void peek()
	{
		if (heap.peek() == null)
		{
			System.out.println("InvalidOperation");
			return;
		}

		WebNode k = heap.peek();
		System.out.println(k.toString());
	}

	public void removeMin()
	{
		//remove minimal element and print it
		if (heap.isEmpty()) {
			System.out.println("InvalidOperation");
			return;
		}
		
		WebNode min = heap.poll();
		System.out.println(min.toString());
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
            System.out.print(k.toString());
        }
	}
	
	
	
	//========================================//
	
	
	
	
	/*
	public void setPostOrderScore(ArrayList<Keyword> keywords) throws IOException
	{
		setPostOrderScore(root, keywords);
	}

	private void setPostOrderScore(WebNode startNode, ArrayList<Keyword> keywords) throws IOException
	{
		for(WebNode n : startNode.children) {
			setPostOrderScore(n,keywords);
		}
		startNode.setNodeScore(keywords);
	}

	public void eularPrintTree()
	{
		eularPrintTree(root);
	}

	private void eularPrintTree(WebNode startNode)
	{
		int nodeDepth = startNode.getDepth();

		if (nodeDepth > 1)
			System.out.print("\n" + repeat("\t", nodeDepth - 1));

		System.out.print("(");
		System.out.print(startNode.webPage.name + "," + startNode.nodeScore);
		
		if(!startNode.children.isEmpty()) {
			for(WebNode n : startNode.children) {
				eularPrintTree(n);
			}
		}
		System.out.print(")");

		if (startNode.isTheLastChild())
			System.out.print("\n" + repeat("\t", nodeDepth - 2));
	}

	private String repeat(String str, int repeat)
	{
		String retVal = "";
		for (int i = 0; i < repeat; i++)
		{
			retVal += str;
		}
		return retVal;
	}
	*/
}