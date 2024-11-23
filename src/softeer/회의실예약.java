package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 회의실예약 {
	static int N, M;
	
	static class Node{
		int start;
		int end;
		
		Node(int s, int e){
			this.start = s;
			this.end = e;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map<String, ArrayList<Node>> roomMap = new HashMap<>();
		
		
		
		
		for(int i=0; i<N; i++) {
			String roomName = br.readLine();
			roomMap.put(roomName, new ArrayList<>());
		}
		
		List<String> keySet = new ArrayList<>(roomMap.keySet());
		
		Collections.sort(keySet);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			roomMap.get(name).add(new Node(start, end));
			
		}
		
		for(int i=0; i<N; i++) {
			String roomName = keySet.get(i);
			ArrayList<String> ableTimeList = new ArrayList<>();
			sb.append("Room ").append(roomName).append(":\n");
			
			ArrayList<Node> targetRoom = roomMap.get(roomName);
			
			if(targetRoom.size() == 0 ) {
				sb.append("1 available:\n");
				sb.append("09-18\n");
				if(i != N-1) {
					sb.append("-----\n");
				}
				continue;
			}
			
			Collections.sort(targetRoom, new Comparator<Node>() {
				public int compare(Node o1, Node o2) {
					return o1.start - o2.start;
				}
			});
			
			int nowStartTime = targetRoom.get(0).start;
			int nowEndTime = targetRoom.get(0).end;
			if(nowStartTime != 9) {
				String time = "09-"+String.valueOf(nowStartTime);
				ableTimeList.add(time);
			}
			for(int j=1; j<targetRoom.size(); j++) {
				Node node = targetRoom.get(j);
				if(nowEndTime != node.start) {
					ableTimeList.add(String.valueOf(nowEndTime)+"-"+String.valueOf(node.start));
				}
				
				nowEndTime = node.end;
			}
			
			if(nowEndTime != 18) {
				ableTimeList.add(String.valueOf(nowEndTime)+"-18");
			}
			
			if(ableTimeList.size() == 0 ) {
				sb.append("Not available\n");
			} else {
				sb.append(ableTimeList.size()).append(" available:\n");
				
				for(String time : ableTimeList) {
					sb.append(time).append("\n");
				}
			}
			
			if(i != N-1) {
				sb.append("-----\n");
			}
		}
		
		
		
		System.out.println(sb);
	}
	
}
