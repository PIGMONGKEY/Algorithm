import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        String[] singleRecord = {};
        String[] time = {};
        
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int perTime = fees[2];
        int perFee = fees[3];
        int parkMinute, carNum, i = 0;
        
        HashMap<Integer, Integer> inOutMap = new HashMap<>();   // 입차 시간 HashMap
        HashMap<Integer, Integer> carFeeMap = new HashMap<>();  // 주차 시간 HashMap
        
        HashSet<Integer> carNumSet = new HashSet<>();   // 차 번호 Set
        
        for (String record : records) {
            // 시간, 차번호, 입출차 로 나눔
            singleRecord = record.split(" ");
            // [시간, 분] 으로 나눔
            time = singleRecord[0].split(":");
            // 분으로 환산하여 저장
            parkMinute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            // 차 번호 int 변환
            carNum = Integer.parseInt(singleRecord[1]);
            
            if (singleRecord[2].equals("IN")) { // 입차 - 입차 시간 HashMap에 입차 시간 기록 / 차번호 Set에 차 번호 저장
                inOutMap.put(carNum, parkMinute);
                carNumSet.add(carNum);
            } else {    // 출차 - 입차 시간 HashMap에서 입차 시간 가져와서 출차 시간에서 빼준후 주차 시간 HashMap에 저장
                carFeeMap.put(carNum, carFeeMap.getOrDefault(carNum, 0) + (parkMinute - inOutMap.get(carNum)));
                inOutMap.remove(carNum);
            }
        }
        
        answer = new int[carNumSet.size()];
        
        // 차 번호 Set을 오름차순으로 정렬한 후 Integer 배열로 만들어서 순회하며 요금 계산
        for (Integer c : carNumSet.stream().sorted().toArray(Integer[]::new)) {
            // 만약 출차 기록이 없다면 23시 59분에 출차로 계산하여 주차 시간 HashMap에 추가
            if (inOutMap.containsKey(c)) {
                carFeeMap.put(c, carFeeMap.getOrDefault(c, 0) + (23 * 60 + 59) - inOutMap.get(c));
                inOutMap.remove(c);
            }
            
            parkMinute = carFeeMap.get(c);
            
            if (parkMinute <= defaultTime)  // 기본 시간 이내면 기본 요금
                answer[i++] = defaultFee;
            else    // 기본 시간 벗어나면 요금 계산
                answer[i++] = defaultFee + ((int) Math.ceil((double) (parkMinute - defaultTime) / (double) perTime) * perFee);
        }
        
        return answer;
    }
}