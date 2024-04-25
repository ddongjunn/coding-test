import java.util.HashSet;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        int answer = 0;
        Set<String> cacheKey = new HashSet<>();
        Deque<String> cache = new ArrayDeque();
        
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            
            if (cacheKey.contains(city)) {
                answer += 1;
                cache.remove(city);
                cache.offerFirst(city);
            } else {
                answer += 5;
                
                if (cache.size() == cacheSize) {
                    cacheKey.remove(cache.removeLast());  
                } 
                cache.offerFirst(city);
                cacheKey.add(city);
            }
        }
        
        return answer;
    }
}