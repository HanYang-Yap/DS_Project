import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KeywordHeap {
	
	private PriorityQueue<Keyword> heap;
	public KeywordComparator kComparator = new KeywordComparator();

	public KeywordHeap() {
		
		this.heap = new PriorityQueue<Keyword>(10, new KeywordComparator());
	}

	public void add(Keyword k) {
		
		heap.offer(k);
	}

	public void peek() {
		
		if (heap.peek() == null) {
			
			System.out.println("InvalidOperation");
			return;
		}

		Keyword k = heap.peek();
		System.out.println(k.toString());
	}

	public void removeMin()	{
		
		Iterator<Keyword> iterator = heap.iterator(); 
		
		Keyword k = heap.poll();
		System.out.println(k.toString());
			
	}

	public void output() {
		
		StringBuilder sb = new StringBuilder();
		Keyword k;
		
		Iterator<Keyword> kIterator = heap.iterator();
		
		while (kIterator.hasNext()) {
			
			if (heap.peek() == null) {
				System.out.println("InvalidOperation");	
			}
			System.out.print(heap.poll().toString());
		}
		
		System.out.println(sb.toString());
	}
}