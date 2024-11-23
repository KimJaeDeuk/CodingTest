import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int sec = 0;
	static int nx[] = {0,1,0,-1}; // 동 남 서 북 // D right +1%4
	static int ny[] = {1,0,-1,0};			  //L left  0 3 2 1 if(direction -1 < 0 ) direction = 3 else direction--;
	static HashMap<Integer,String> map = new HashMap<Integer,String>();
	static Deque<Integer[]> snake = new LinkedList<Integer[]>();
	public static void main(String[] args) throws Exception{
		snake.add(new Integer[]{1,1});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		StringTokenizer st;
		for(int i=0; i < K ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		int L = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		int headx = 1;
		int heady = 1;
		int direction = 0;
		if(map.containsKey(sec)) {
			String operator = map.get(sec);
			if(operator.equals("D")) {
				direction = (direction+1)%4;
			}else {
				if(direction-1 < 0)
					direction = 3;
				else
					direction--;
			}
		}
		while(true) {
			sec++;
			
			int movex = nx[direction] + headx;
			int movey = ny[direction] + heady;
			
			if(movex==N+1 || movey == N+1 || movex==0 || movey==0) {	//move한곳이 벽에 닿는지 체크
				break;
			}
			snake.addFirst(new Integer[] {movex,movey});		//몸길이를 늘려 머리를 다음칸에 위치
			
			if(check(movex, movey)) {		//서로 닿는지 확인
				break;
			}
			if(arr[movex][movey]!=1) {		//사과가 아니라면 마지막꺼 poll
				snake.removeLast();
			}else {
				arr[movex][movey] = 0;		//사과가 있다면 사과자리 0으로 변환
			}
			
			
			headx = movex;
			heady = movey;
			
			if(map.containsKey(sec)) {
				String operator = map.get(sec);
				if(operator.equals("D")) {
					direction = (direction+1)%4;
				}else {
					if(direction-1 < 0)
						direction = 3;
					else
						direction--;
				}
			}
		}
		System.out.println(sec);
	}
	private static boolean check(int x, int y) {
		int  i=0;
		for(Integer[] position : snake) {
			if(i++==0) {
				continue;
			}
			if(position[0] == x && position[1]==y)
				return true;
			
		}
		
		return false;
	}

}
