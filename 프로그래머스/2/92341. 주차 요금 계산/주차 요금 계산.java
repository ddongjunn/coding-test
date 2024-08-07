import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> parkingInfo = new HashMap<>();
        Map<String, Integer> parkingTime = new TreeMap<>();
        for(String record : records) {
            String[] r = record.split(" ");
            String time = r[0];
            String id = r[1];
            String type = r[2];

            if("IN".equals(type)) {
                parkingInfo.put(id, record);
            } else {
                String parkingInInfo = parkingInfo.get(id);
                parkingInfo.remove(id);

                int inMin = strToMin(parkingInInfo.split(" ")[0]);
                int outMin = strToMin(record.split(" ")[0]);
                int diffTime = outMin - inMin;
                parkingTime.put(id, parkingTime.getOrDefault(id, 0) + diffTime);
            }
        }

        // 아직 출차하지 않은 차량 처리
        for(Map.Entry<String, String> entry : parkingInfo.entrySet()) {
            String id = entry.getKey();
            int inMin = strToMin(entry.getValue().split(" ")[0]);
            int outMin = strToMin("23:59");
            int diffTime = outMin - inMin;
            parkingTime.put(id, parkingTime.getOrDefault(id, 0) + diffTime);
        }

        int idx = 0;
        int[] answer = new int[parkingTime.size()];
        for(int time : parkingTime.values()) {
            if(fees[0] <= time) {
                answer[idx++] = fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            } else {
                answer[idx++] = fees[1];
            }
        }

        return answer;
    }
    public int strToMin(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }
}