package coding.practice;

import java.util.ArrayList;
import java.util.List;

public class _template {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(run(list));
    }

    private static Integer run(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }


}
