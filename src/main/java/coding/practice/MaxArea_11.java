package coding.practice;

import java.util.ArrayList;
import java.util.List;

public class MaxArea_11 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(run(list));
    }

    private static Integer run(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        int i = 0;
        int j = list.size() - 1;

        int maxArea = 0;

        while (i < j) {
            int area = 0;

            if (list.get(i) < list.get(j)) {
                area = list.get(i) * (j - i);
                i++;
            } else {
                area = list.get(j) * (j - i);
                j--;
            }

            maxArea = Math.max(maxArea, area);
        }

        return list.get(0);
    }


}
