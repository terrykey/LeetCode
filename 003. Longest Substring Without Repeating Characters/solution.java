public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s.length();
        
        int maxLength = 1;
        int firstChar = 1; 
        int lastChar = 0;
        char[] input = s.toCharArray();
        Map<Character, Integer>map = new HashMap<>();
        map.put(input[0], 0);
        
        while(firstChar < s.length()) {
            char key = input[firstChar];
            if(map.containsKey(key)) {
                maxLength = Integer.max(maxLength, firstChar - lastChar);
                int value = map.get(key);
                while(lastChar <= value) {
                    map.remove(input[lastChar++]);
                }
            }
            else
                map.put(key, firstChar++);
        }
        maxLength = Integer.max(maxLength, firstChar - lastChar);
        
        return maxLength;
    }
}