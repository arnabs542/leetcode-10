package StringRelated;


/**
 * Given two strings s and t, determine if they are both one edit distance apart.
 * <p>
 * Note:
 * <p>
 * There are 3 possiblities to satisify one edit distance apart:
 * <p>
 * Insert a character into s to get t
 * Delete a character from s to get t
 * Replace a character of s to get t
 * Example 1:
 * <p>
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * Example 2:
 * <p>
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * Example 3:
 * <p>
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 * <p>
 * <p>
 * 思路:
 * There're 3 possibilities to satisfy one edit distance apart:
 * <p>
 * 1) Replace 1 char:
 * s: a B c
 * t: a D c
 * 2) Delete 1 char from s:
 * s: a D  b c
 * t: a    b c
 * 3) Delete 1 char from t
 * s: a   b c
 * t: a D b c
 */

public class OneEditDistance {

    public boolean isOneEditDistance(String s, String t) {

        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t
        return Math.abs(s.length() - t.length()) == 1;
    }
}
