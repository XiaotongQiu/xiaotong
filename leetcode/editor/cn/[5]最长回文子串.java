//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3322 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String panlindrom(String s, int l, int r) {
        char[] str = s.toCharArray();
        // System.out.println(s);
        // System.out.println(l);
        // System.out.println(r);
        while (l >= 0 && r < s.length() && str[l] == str[r]) {
            l--;
            r++;
        }
        // System.out.println(l+1);
        // System.out.println(r-1);
        if (l+1 <= r-1) {
            return s.substring(l+1, r);
        }
        return "";
    }
    public String longestPalindrome(String s) {
        String res="";
        if (s == null || s.length() == 0) {
            return "";
        }
        for (int i=0; i < s.length(); i++) {
            String odd = panlindrom(s, i, i);
            String even = panlindrom(s, i, i+1);
            res = res.length() > odd.length() ? res : odd;
            res = res.length() > even.length() ? res :even;
        }

        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
