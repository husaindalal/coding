import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum_1 {
    public static void main(String[] args) {
        //twoSum()
    }

    private static Indices twoSum(List<Integer> list, Integer sum) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
        }

        for (int i = 0; i < list.size() - 1; i++) {
            Integer key = list.get(i);
            Integer findVal = sum - key;
            Integer val = map.getOrDefault(key, 0);
            map.put(key, val + 1);

            if ((findVal.equals(key) && map.get(findVal) > 1) ||
                    (!findVal.equals(key) && map.getOrDefault(findVal, 0) > 0)) {
                return new Indices(i, findVal);//TODO need to return both indices
            }
        }
        return null;
    }

    private static class Indices {
        private Integer i;
        private Integer j;

        public Indices(Integer i, Integer j) {
            this.i = i;
            this.j = j;
        }

        public Integer getI() {
            return i;
        }

        public void setI(Integer i) {
            this.i = i;
        }

        public Integer getJ() {
            return j;
        }

        public void setJ(Integer j) {
            this.j = j;
        }
    }
}
