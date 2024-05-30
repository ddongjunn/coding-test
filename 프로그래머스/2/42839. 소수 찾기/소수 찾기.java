import java.util.Set;
import java.util.HashSet;

class Solution {
    public Set<Integer> primes = new HashSet<>();
    public boolean visit[] = new boolean[7];
        
    public int solution(String numbers) {
        for(int i = 0; i < numbers.length(); i++) {
            dfs(numbers, "", i + 1);
        }
        return primes.size();
    }
    
    public void dfs(String numbers, String tmp, int depth) {
        if(tmp.length() == depth) {
            int number = Integer.parseInt(tmp);
            if(!primes.contains(number) && isPrime(number)) {
                primes.add(number);
            }
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visit[i]) {
                visit[i] = true;
                tmp += numbers.charAt(i);
                dfs(numbers, tmp, depth);
                tmp = tmp.substring(0, tmp.length() - 1);
                visit[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if(n == 0 || n == 1) {
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}