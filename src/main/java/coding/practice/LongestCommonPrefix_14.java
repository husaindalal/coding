package coding.practice;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("LinkedIn", "Link", "Linkr", "Linked");


        System.out.println(longestCommonPrefix(strings));
    }

    private static String longestCommonPrefix(List<String> strings) {
        //TODO basic val
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < strings.get(0).length(); i++) {
            char c = strings.get(0).charAt(i);
            for (int j = 0; j < strings.size(); j++) {
                if (strings.get(j).length() == i) {
                    return prefix.toString();
                }
                if (c != strings.get(j).charAt(i)) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }

        return prefix.toString();
    }
}
