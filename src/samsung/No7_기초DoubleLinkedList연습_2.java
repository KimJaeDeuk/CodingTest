package samsung;

class Nod2 {
	public int data;
	public Nod2 prev;
	public Nod2 next;

	public Nod2(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

public class No7_기초DoubleLinkedList연습_2 {
	
	private final static int MAX_NODE = 10000;

	private Nod2[] node = new Nod2[MAX_NODE];
	private int nodeCnt = 0;
	private Nod2 head;
    
	public Nod2 getNode(int data) {
		node[nodeCnt] = new Nod2(data);
		return node[nodeCnt++];
	}

	public void init() {
		head = new Nod2(0);
		nodeCnt = 0;
	}
	
	public void addNode2Head(int data) {
		Nod2 newNod2 = getNode(data);
		if(head.next!=null) {
			head.next.prev = newNod2;
		}
		newNod2.next = head.next;
		head.next = newNod2;
		newNod2.prev = head;
		
	}

	public void addNode2Tail(int data) {
		Nod2 newNod2 = getNode(data);
		Nod2 nextNod2 = head;
		while(true) {
			if(nextNod2.next==null) {
				nextNod2.next = newNod2;
				newNod2.prev = nextNod2;
				break;
			}
			nextNod2 = nextNod2.next;
		}
		
	}

	public void addNode2Num(int data, int num) {
		Nod2 newNod2 = getNode(data);
		Nod2 nextNod2 = head;
		int n=1;
		
		if(num > nodeCnt+1) return;
		
		while(n++ != num) {
			nextNod2 = nextNod2.next;
		}
		
		Nod2 after = nextNod2.next;
		if(after!=null) {
			after.prev = newNod2;
		}else {
			newNod2.next = after;
		}
		newNod2.next = after;
		nextNod2.next = newNod2;
		newNod2.prev = nextNod2;
	}
	
	public int findNode(int data) {
		Nod2 nextNod2 = head.next;
		int n =1;
		while(true) {
			
			if(nextNod2.data==data) {
				return n;
			}
			
			if(nextNod2.next==null) {
				return -1;
			}
			
			nextNod2 = nextNod2.next;
			n++;
		}
	}
	
	public void removeNode(int data) {
		Nod2 nextNod2 = head.next;
		
		while(true) {
			
			if(nextNod2.data==data) {
			
				if(nextNod2.next==null) {
					nextNod2.prev.next = null;
					nodeCnt--;
					return;
				}
				Nod2 prevNod2 = nextNod2.prev;
				
				prevNod2.next = nextNod2.next;
				nextNod2.next.prev = prevNod2;
				nodeCnt--;
				return;
			}
			
			if(nextNod2.next== null) {
				return;
			}
			
			nextNod2 = nextNod2.next;
		}
	}

	public int getList(int[] output) {
		Nod2 nextNod2 = head.next;
		for(int i=0; i<nodeCnt; i++) {
			
			output[i] = nextNod2.data;
			
			
			nextNod2 = nextNod2.next;
		}
		
		return nodeCnt;
	}
	
	public int getReversedList(int[] output) {
		
		Nod2 lastNod2 = head.next;
		
		while(true) {
			if(lastNod2.next==null) break;
			lastNod2 = lastNod2.next;
		}
		
		for(int i=0; i<nodeCnt; i++) {
			output[i] = lastNod2.data;
			
			
			lastNod2 = lastNod2.prev;
		}
		return nodeCnt;
	}
}