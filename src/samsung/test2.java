package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2 {

  public static String findMaxResult(String maxValue, int x, int y) {
    
    StringBuffer sb = new StringBuffer();
    
    String X = String.valueOf(x);
    String Y = String.valueOf(y);
    
    boolean flag = false;
    for(int i = 0; i < maxValue.length(); i++) {
      
      if(!flag) {
        int currentNum = maxValue.codePointAt(i) - '0';      
        String appendNum = getValue(currentNum, x, y);
        flag = appendNum.startsWith("+") || appendNum.equals("-"); // 문자열이 - 혹은 +로 시작하는경우 계산 필요 X => flag 변경
        sb.append(appendNum.replace("+0", "").replace("+", ""));        
      } else { // flag(문자열이 + 혹은 -이후인 경우)값에 따라 무조건 Y값으로 추가
        sb.append(Y);
      }
    }
    
    String result = sb.toString();
    
    int minusIndex = result.indexOf("-");
    System.out.println(minusIndex);
    if(minusIndex != -1) { // 문자열에 -값이 있을 경우 그 전의 문자열 검사
      String beforeMinusStr = result.substring(0, minusIndex);
      String afterMinusStr = result.substring(minusIndex).replace("-", Y);

      int lastYindex = beforeMinusStr.lastIndexOf(Y);
      if (beforeMinusStr.length() == 0) {
        afterMinusStr = afterMinusStr.substring(1);
      } else if (lastYindex == -1) {
        beforeMinusStr = beforeMinusStr.replace(X, Y).substring(1);
      } else {
        String beforeYStr = beforeMinusStr.substring(0, lastYindex);
        String afterYStr = beforeMinusStr.substring(lastYindex);

        beforeMinusStr = beforeYStr + afterYStr.replace(X, "-").replace(Y, X).replace("-", Y);
      }
      result = beforeMinusStr + afterMinusStr;
    }
    return result.length() == 0 || result.equals("0") ? "-1" : result;
  }

  public static String getValue(int currentNum, int x, int y) {

    String result = null;

    if (currentNum < x) {
      result = "-";
    } else if (x == currentNum) {
      result = String.valueOf(x);
    } else if (x < currentNum && currentNum < y) {
      result = String.format("+%d", x);
    } else if (y == currentNum) {
      result = String.valueOf(y);
    } else if (y < currentNum) {
      result = String.format("+%d", y);
    }

    return result;
  }

  public static void main(String[] args) throws IOException {

    // N, x, y(1 ≤ N ≤ 10100,000, 0 ≤ x < y ≤ 9)

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCaseCount;
    testCaseCount = Integer.parseInt(br.readLine());

    StringBuffer resultSb = new StringBuffer();

    for (int testCaseIndex = 1; testCaseIndex <= testCaseCount; testCaseIndex++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String maxValue = st.nextToken();
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      String result = findMaxResult(maxValue, x, y);
      resultSb.append(String.format("#%2d %s\n", testCaseIndex, result));
    }
    System.out.println(resultSb.toString());
    br.close();
  }
}