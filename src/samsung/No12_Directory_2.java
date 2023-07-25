package samsung;

import java.util.HashMap;
import java.util.Map;

class No12_Directory_2 {

	private final static int NAME_MAXLEN	= 6;
	private final static int PATH_MAXLEN	= 1999;
	private int maxDir;
	private Node root;
	
	
	private class Node{
		String title;
		Map<String,Node> child;
		
		public Node(String title) {
			this.title = title;
			child = new HashMap<>();
		}
		
		public Node deepCopy() {
			Node copyNode = new Node(this.title);
			for(Map.Entry<String,Node> entry : this.child.entrySet()) {
				copyNode.child.put(entry.getKey(), entry.getValue().deepCopy());
			}
			return copyNode;
		}
	}
	
	private int cnt=0;
//	 The below commented methods are for your reference. If you want 
//	 to use it, uncomment these methods.
//	
//	int mstrcmp(char[] a, char[] b) {
//		int i;
//		for (i = 0; a[i] != '\0'; i++) {
//			if (a[i] != b[i])
//				return a[i] - b[i];
//		}
//		return a[i] - b[i];
//	}
//
//	int mstrncmp(char[] a, char[] b, int len) {
//		for (int i = 0; i < len; i++) {
//			if (a[i] != b[i])
//				return a[i] - b[i];
//		}
//		return 0;
//	}
//
//	int mstrlen(char[] a) {
//		int len = 0;
//
//		while (a[len] != '\0')
//			len++;
//
//		return len;
//	}
//
//	void mstrcpy(char[] dest, char[] src) {
//		int i = 0;
//		while (src[i] != '\0') {
//			dest[i] = src[i];
//			i++;
//		}
//		dest[i] = src[i];
//	}
//
//	void mstrncpy(char[] dest, char[] src, int len) {
//		for (int i = 0; i < len; i++) {
//			dest[i] = src[i];
//		}
//		dest[len] = '\0';
//	}
	
	// 각 testcase 시작 시, 초기화를 위해 1번 호출되고 루트 디렉터리를 생성한다.
	// n은 각 tc의 root directory를 포함한 최대 디렉터리 개수
	void init(int n) {
		maxDir = n;
		this.root = new Node("/");
	}
	
	// path[] 디렉터리의 하위에 name[] 이름을 가진 새로운 디렉터리를 생성한다.
	// path[2000]: 생성할 디렉터리의 상위 디렉터리의 경로 (1 ≤ length ≤ 1,999)
	// name[7]: 생성할 디렉터리의 이름 (2 ≤ length ≤ 6)
	void cmd_mkdir(char[] path, char[] name) {
		Node searchNode = getStart(path);
		int i=0;
		StringBuilder sb = new StringBuilder();
		while(name[i]!='\0') {
			sb.append(name[i]);
			i++;
		}
		searchNode.child.put(sb.toString(), new Node(sb.toString()));
	}
	
	private Node getStart(char[] path) {
		Node node = this.root;
		if(path.length > 3) {
			int i =1;
			StringBuilder sb = new StringBuilder();
			while(path[i] != '\0') {
				if(path[i]=='/') {
					node = node.child.get(sb.toString());
					sb = new StringBuilder();
				}else {
					sb.append(path[i]);
				}
				i++;
			}
		}
		return node;
	}

	// path[] 디렉터리와 그 모든 하위 디렉터리를 삭제한다.
	// path[2000]: 삭제할 디렉터리의 경로 (1 ≤ length ≤ 1,999)
	void cmd_rm(char[] path) {
		Node node = this.root;
		Node before = this.root;
		String rmTitle = "";
		if(path.length > 2) {
			int i=1;
			StringBuilder sb=  new StringBuilder();
			while(path[i]!='\0') {
				if(path[i]=='/') {
					before = node;
					rmTitle = sb.toString();
					node = node.child.get(sb.toString());
					
					sb = new StringBuilder();
				}else {
					sb.append(path[i]);
				}
				i++;
			}
			before.child.remove(rmTitle);
		}else {
			node.child = new HashMap<String,Node>();
		}
	}
	
	//	dstPath[] 디렉터리의 하위에 srcPath[] 의 디렉터리와 그 모든 하위 디렉터리를 복사한다.
	//	srcPath[2000]: 복사할 디렉터리의 경로 (1 ≤ length ≤ 1,999)
	//	dstPath[2000]: srcPath[] 디렉터리가 복사 될 위치의 상위 디렉터리 경로 (1 ≤ length ≤ 1,999)
	void cmd_cp(char[] srcPath, char[] dstPath) {
		Node cpPlace = getStart(dstPath);
		
		
		Node targetPlace = getStart(srcPath);
		
		Node newNode = targetPlace.deepCopy();
		
		cpPlace.child.put(newNode.title,newNode);
		
	}
	// dstPath[] 디렉터리의 하위에 srcPath[] 의 디렉터리와 그 모든 하위 디렉터리를 이동한다.
	//	srcPath[2000]: 이동할 디렉터리의 경로 (1 ≤ length ≤ 1,999)
	//	dstPath[2000]: srcPath[] 디렉터리가 이동 될 위치의 상위 디렉터리 경로 (1 ≤ length ≤ 1,999)
	void cmd_mv(char[] srcPath, char[] dstPath) {
		Node mvPlace = getStart(dstPath);
		
		
		
		Node targetPlace = getStart(srcPath);
		Node newNode = targetPlace.deepCopy();
		mvPlace.child.put(newNode.title, newNode);
		cmd_rm(srcPath);
	}
	
	// path[] 디렉터리의 모든 하위 디렉터리 개수를 반환한다.
	// path[2000] : 디렉토리의 경로 (1 <= length <= 1999)
	int cmd_find(char[] path) {
		Node search = getStart(path);
		
		cnt = 0;
		getCnt(search, 0);
		//System.out.println("현재 개수 : " + cnt + " searchTitle : "  + search.title);
		return cnt;
	}

	private void getCnt(Node search, int depth) {
		
		if(search.child.size()==0) {
			return;
		}		
		
		cnt += search.child.size();
		for(String key : search.child.keySet()) {
			getCnt(search.child.get(key), depth+1);
		}

	}
}
