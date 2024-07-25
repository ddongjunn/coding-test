import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> userReports = new HashMap<>();
        Map<String, Integer> reportCounts = Arrays.stream(id_list).collect(Collectors.toMap(id -> id, id -> 0));
        Set<String> uniqueReports = new HashSet<>();
        for(String rep : report) {
            String[] parts = rep.split(" ");
            String reporter = parts[0];
            String reportedUser = parts[1];

            if(uniqueReports.add(rep)) {
                reportCounts.put(reportedUser, reportCounts.getOrDefault(reportedUser, 0) + 1);
            }

            userReports.computeIfAbsent(reporter, v -> new HashSet<>()).add(reportedUser);
        }

        Set<String> stoppedIds = reportCounts.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        int[] answer = new int[id_list.length];
        for(int i = 0; i < answer.length; i++) {
            Set<String> ids = userReports.get(id_list[i]);
            if(ids != null) {
                for(String id : ids) {
                    if(stoppedIds.contains(id)) {
                        answer[i]++;
                    }
                }
            }
        }
        
        return answer;
    }
}