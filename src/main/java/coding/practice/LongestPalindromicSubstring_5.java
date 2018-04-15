package coding.practice;

public class LongestPalindromicSubstring_5 {

    public static void main(String[] args) {
        String str = "wesggssoidipofhwy";

        System.out.println(run(str));
    }

    private static Integer run(String str) {

        if (str == null || str.isEmpty()) {
            return null;
        }
        str = str.toLowerCase();

        int maxLen = 0;
        int maxIdx = -1;
        for (int i = 0; i < str.length(); i++) {
            int palLen = Math.max(getPaliLen(str, i, i), getPaliLen(str, i, i + 1));
            if (palLen > maxLen) {
                maxLen = palLen;
                maxIdx = i;
            }
        }
        System.out.println(maxIdx);
        return maxLen;

    }

    private static int getPaliLen(String str, int st, int en) {
        if (st > en) {
            return 0;
        }

        while (st >= 0 && en < str.length() && str.charAt(st) == str.charAt(en)) {
            st--;
            en++;
        }

        return en - st - 1;
    }
}
