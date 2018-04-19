package coding.practice;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArrayExceptSelf_238 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(run(list));
    }

    private static List<Integer> run(List<Integer> list) {

        if (list == null || list.isEmpty()) {
            return null;
        }

        List<Integer> result = new ArrayList<>(list.size());

        int mul = 1;
        for (int i = 0; i < list.size(); i++) {
            result.add(mul); //add
            mul = mul * list.get(i);
        }

        mul = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= 0; i--) {
            result.set(i, result.get(i) * mul); //set
            mul = mul * list.get(i);
        }


        return result;
    }


}
