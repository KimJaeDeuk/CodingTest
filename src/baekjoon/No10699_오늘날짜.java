package baekjoon;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class No10699_오늘날짜 {

	public static void main(String[] args) {

		ZoneId zoneId = ZoneId.of("UTC+0");
		
		LocalDateTime time = LocalDateTime.now(zoneId);
		StringBuilder sb= new StringBuilder();
		sb.append(time.getYear()).append("-").append(time.getMonthValue()<10 ? "0"+time.getMonthValue() : time.getMonthValue())
		.append("-").append(time.getDayOfMonth() < 10 ? "0"+time.getDayOfMonth() : time.getDayOfMonth());
		System.out.println(sb);
	}

}
