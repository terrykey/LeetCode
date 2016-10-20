public class Solution {
    
    /****brute force****/
    public String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        int length = s.length();
        int maxLength1 = 0;
        int maxLength2 = 0;
        int maxPos1 = 0;
        int maxPos2 = 0;
        for(int i = 0; i < length; i++) {
            int back = i - 1, front = i + 1;
            int palindromicLength = 1;
            while(0 <= back && front < length)
                if(input[back--] == input[front++])
                    palindromicLength += 2;
                else break;
            if(maxLength1 < palindromicLength) {
                maxLength1 = palindromicLength;
                maxPos1 = i;
            }
        }
        for(int i = 0; i < length - 1; i++) {
            int back = i, front = i + 1;
            int palindromicLength = 0;
            while(0 <= back && front < length)
                if(input[back--] == input[front++])
                    palindromicLength += 2;
                else break;
            if(maxLength2 < palindromicLength) {
                maxLength2 = palindromicLength;
                maxPos2 = i;
            }
        }
        if(maxLength2 < maxLength1) 
            return s.substring(maxPos1 - maxLength1 / 2, maxPos1 + 1 + maxLength1 / 2);
        else
            return s.substring(maxPos2 + 1 - maxLength2 / 2, maxPos2 + 1 + maxLength2 / 2);
    }
    
    /****dynamic programming****/
    /*
    public String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        int length = s.length();
        int[][] pal = new int[length][length];
        int maxLength = 0;
        int maxStart = 0;
        int maxEnd = 0;

        for(int j = 0; j < length; j++)
            for(int i = j; 0 <= i; i--) {
                if(i == j)
                    pal[i][j] = 1;
                else if(input[i] != input[j])
                    pal[i][j] = 0;
                else if(i + 1 == j){
                    pal[i][j] = 2;
                    if(maxLength < 2) {
                        maxLength = 2;
                        maxStart = i;
                        maxEnd = j;
                    }
                }
                else if(pal[i + 1][j - 1] > 0) {
                    pal[i][j] = pal[i + 1][j - 1] + 2;
                    if(maxLength < pal[i][j]) {
                        maxLength = pal[i][j];
                        maxStart = i;
                        maxEnd = j;
                    }
                }
                else
                    pal[i][j] = 0;
            }
            
        return s.substring(maxStart, maxEnd + 1);
    }
    */
}