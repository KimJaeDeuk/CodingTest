package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1 {
	static String N="";
	static String x="";
	static String y="";
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
	
		int T = Integer.parseInt(br.readLine());
	
		for(int t=1; t<=T; t++) {
		
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = st.nextToken();
			long len = N.length();
			x=st.nextToken();
			y=st.nextToken();
			String result="";
			boolean check = true;

			if(len < 2) {
				if(Integer.parseInt(x) > Integer.parseInt(N) || 
						(Integer.parseInt(y) > Integer.parseInt(N) && x.equals("0"))) {
					sb.append("#"+t+" -1").append("\n");
					continue;
				}
			}
			
			for(int i=0; i<len;i++) {
				if(Integer.parseInt(x) > N.charAt(i)-'0') { //x보다 작을때
					result = getSmall(i, len);
					check = false;
					break;
				}else if(Integer.parseInt(y) < N.charAt(i)-'0') { //y보다 클때
					result = getBig(i, len);
					check = false;
					break;
					//x랑 y 사이값일떄
				}else if(Integer.parseInt(x) < N.charAt(i)-'0' && Integer.parseInt(y) > N.charAt(i)-'0') { // x랑 y 사이값일때
					if(i==0&&x.equals("0"))	// 사이값이면서 N의 첫번째를 체크하면서 x가 0일경우
						result = getSmall(i, len);
					else
						result = getMiddle(i,len);
					check = false;
					break;
				}
			}
			if(check) {
				result = N;
			}

			sb.append("#"+t+" "+result).append("\n");
            
		}
		System.out.println(sb);
	}
	
	private static String getBig(int point, long len) {
		StringBuilder sb = new StringBuilder(N.substring(0,point));	//point까지 substring 초기값
		
		for(long i=point; i<len; i++) {	//point부터 len까지 쭉 y만 append
			sb.append(y);
		}
		return sb.toString();
	}

	private static String getSmall(int point, long len) {
		
			
		StringBuilder sb = new StringBuilder();
		
		if(point == 0 ) {		//만약 point가 0이라면 자릿수 하나 줄여서 y만 append
			
			for(long i= 1; i<len; i++) {
				sb.append(y);
			}
		}
		else {
			int checkPoint = -1;
			for(int i=point-1; i>=0 ;i--) {	//point는 작은것이 확실하니 point-1부터 0까지 역순회로 checkPoint지점 확인
				if(N.charAt(i)-'0' > Integer.parseInt(x)) {	//N의 i번째가 x보다 큰경우를 찾음
					checkPoint = i;		
					break;	//찾으면 break
				}
			}
			
			if(checkPoint== -1) {	//찾지 못하고 checkPoint가 -1일경우
				for(long i= 1; i<len; i++) {	//자릿수 하나 줄여서 y만 append
					sb.append(y);
				}
			}else {
				if(checkPoint!=0) {	//checkPoint가 0이 아니라면 초기값 세팅
					sb.append(N.substring(0, checkPoint));
				}
				sb.append(x);	//이후 x 한번 append
				for(long i= checkPoint+1; i<len; i++) {	//뒤에 쭉 y append
					sb.append(y);
				}
			
			}
			
			
		}
		
		
		return sb.toString();
	}
	
	private static String getMiddle(int point, long len) {
		StringBuilder sb = new StringBuilder(N.substring(0,point));
		sb.append(x);	//그 포인트는 x로 대체
		for(long i=point+1; i<len; i++)	//이후 y로 쭉 append
			sb.append(y);
		
		return sb.toString();
	}
}
