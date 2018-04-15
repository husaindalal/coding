package coding.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public static void main(String[] args) {
        String str = "wesgsoidfhwy";

        System.out.println(run(str));
    }

    private static String run(String str) {

        if (str == null || str.isEmpty()) {
            return null;
        }
        str = str.toLowerCase();

        int j = 0;
        Integer maxLen = 0;
        String maxStr = "";

        Map<Character, Integer> map = new HashMap<>();
        List<Character> chars = str.chars().mapToObj(it -> (char) it).collect(Collectors.toList());

        for (int i = 0; i < chars.size(); i++) {
            if (!map.containsKey(chars.get(i))) {
                map.put(chars.get(i), i);
                System.out.println("putting " + chars.get(i) + "  " + i);
            } else {
                j = Math.max(map.remove(chars.get(i)), j) + 1;
                System.out.println("removing " + chars.get(i) + "  " + i + "  " + j);
                map.put(chars.get(i), i);
            }
            Integer len = i - j;
            System.out.println("ij_len " + i + "  " + j + "  " + len);
            if (len > maxLen) {
                maxLen = len;
                maxStr = str.substring(j, i);
                System.out.println("maxLen " + maxLen + "  " + maxStr);
            }

        }

        return maxStr;
    }

}
