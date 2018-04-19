package coding.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber_17 {

    public static void main(String[] args) {
        String phoneNum = "302"; //4383178
        Map<Integer, String> numMap = new HashMap<>();
        numMap.put(0, "0");
        numMap.put(1, "yz");
        numMap.put(2, "abc");
        numMap.put(3, "def");
        numMap.put(4, "ghi");
        numMap.put(5, "jkl");
        numMap.put(6, "mno");
        numMap.put(7, "pqr");
        numMap.put(8, "stu");
        numMap.put(9, "vwx");


        System.out.println(run(phoneNum, numMap));
    }

    /*
    can also use queue
    pop each time and multiply each char from next number and push again

     */

    private static List<String> run(String num, Map<Integer, String> numMap) {
        List<String> result = new ArrayList<>();
        if (num == null || num.isEmpty()) {
            return result;
        }

        run("", num, numMap, result);

        return result;
    }

    private static void run(String prefix, String num, Map<Integer, String> numMap, List<String> result) {
        if (prefix.length() == num.length()) {
            result.add(prefix);
            return;
        }

        int currNum = (int) num.charAt(prefix.length()) - (int) '0';
        String comb = numMap.get(currNum);
        for (int i = 0; i < comb.length(); i++) {

            run(prefix + comb.charAt(i), num, numMap, result);
        }
    }
}
