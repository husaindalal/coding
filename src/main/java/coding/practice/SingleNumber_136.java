import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class SingleNumber_136 {

    public static void main(String[] args) {

    }

    private static Optional<Integer> findSingle(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list.size());

        for (Integer key : list) {
            if (set.contains(key)) {
                set.remove(key);
            } else {
                set.add(key);
            }
        }

        return set.stream().findFirst();

    }
}
