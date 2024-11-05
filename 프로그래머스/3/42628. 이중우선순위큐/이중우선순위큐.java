import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> map  =new HashMap<>();
        for(int i=0; i<operations.length; i++) {

            String[] operation = operations[i].split(" ");
            int num = Integer.parseInt(operation[1]);
            if(operation[0].equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                minQueue.add(num);
                maxQueue.add(num);
            } else {
                if (num ==-1) {
                    removeQueue(minQueue, map);
                } else {
                    removeQueue(maxQueue, map);
                }
            }
        }
        if(map.size() != 0) {
            List<Integer> keyList = new ArrayList<>(map.keySet());
            answer = new int[]{Collections.max(keyList), Collections.min(keyList)};
        } else {
            answer = new int[2];
        }
        
        return answer;
    }
    
    private void removeQueue(PriorityQueue<Integer> queue, Map<Integer, Integer> map) {
        if (!queue.isEmpty()) {
            int num = 0;
            while(!queue.isEmpty()) {
                num = queue.poll();
                if(map.containsKey(num)) {
                    if (map.get(num) == 1) {
                        map.remove(num);
                    } else {
                        map.put(num, map.get(num) - 1);
                    }
                    break;
                }
            }
        }
    }
}