package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Info {
	String name;
	int lv;
	
	Info(int l, String m) {
		this.name = m;
		this.lv = l;
	}
}

public class No20006_랭킹전대기열 {
	static int p;
	static int m;
	static ArrayList< ArrayList<Info>> roomInfo = new ArrayList<ArrayList<Info>>();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		p = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		
		for(int i = 0; i< p ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Info user = new Info(Integer.parseInt(st.nextToken()), st.nextToken());
			
			if(roomInfo.size() == 0 ) {
				createNewRoom(user);
				continue;
			}
			boolean enter = false;
			for(int j = 0; j < roomInfo.size(); j++) {
				ArrayList<Info> room = roomInfo.get(j);
				if(room.size() >=m) continue;
				
				int mainLv = room.get(0).lv;
				if(mainLv +10 >= user.lv && mainLv -10 <= user.lv) {
					room.add(user);
					enter = true;
					break;
				}
			}
			if(!enter) {
				createNewRoom(user);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<roomInfo.size(); i++) {
			ArrayList<Info> room = roomInfo.get(i);
			if(i!=0) {
				sb.append("\n");
			}
			if(room.size()==m) {
				sb.append("Started!");
			}else {
				sb.append("Waiting!");
			}
			sortedByNameAsc(room);
			
			for(Info j : room ) {
				sb.append("\n").append(j.lv).append(" ").append(j.name);
			}
		}
		
		System.out.println(sb.toString());
	}
	private static void createNewRoom(Info user) {
		ArrayList<Info> list = new ArrayList<Info>();
		list.add(user);
		roomInfo.add(list);
	}
	
	private static void sortedByNameAsc(ArrayList<Info> room) {
		Collections.sort(room, new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		
	}
}
