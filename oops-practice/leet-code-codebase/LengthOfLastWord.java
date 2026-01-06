// Given a string s consisting of words and spaces, 
// return the length of the last word in the string.
class Solution {
    public int lengthOfLastWord(String s) {
        if(s.isEmpty()) return 0;

        String[] words = s.trim().split("\\s+");
        String ans = words[words.length-1];
        return ans.length();
    }
}