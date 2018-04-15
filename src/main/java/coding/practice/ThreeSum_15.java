package coding.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum_15 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(run(list));
    }

    private static List<List<Integer>> run(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            return result;
        }
        Collections.sort(list);

        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i) > 0) {
                break;
            }

            if (i > 0 && list.get(i).equals(list.get(i - 1))) {
                continue;
            }

            int st = i + 1;
            int en = list.size() - 1;
            int sum = 0 - list.get(i);

            while (st < en) {

                if (list.get(st) + list.get(en) > sum) {
                    en--;
                } else if (list.get(st) + list.get(en) < sum) {
                    st++;
                } else {
                    result.add(Arrays.asList(list.get(i), list.get(st), list.get(en)));

                    while (st < en && list.get(st).equals(list.get(st + 1))) st++; //IMPORTANT
                    while (st < en && list.get(en).equals(list.get(en - 1))) en--; //IMPORTANT

                    st++;
                    en--;
                }

            }
        }

        return result;
    }

}
