import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        while(!queue.isEmpty()) {

            Node node = queue.poll();

            if(node.word.equals(target)) {
                return node.cnt;
            }

            for(int i=0; i<words.length; i++) {
                int cnt = 0;

                if(visited.contains(words[i])) continue;

                for(int j=0; j<words[i].length(); j++) {

                    if(node.word.charAt(j) == words[i].charAt(j)) {
                        cnt++;
                    }
                }
                if(cnt == words[i].length()-1) {
                    queue.add(new Node(words[i], node.cnt+1));
                    visited.add(words[i]);
                }

            }
        }

        return answer;
    }
    
    public class Node{
        String word;
        int cnt;
        Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}