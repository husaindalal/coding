package coding.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GridReachable {

    List<List<Boolean>> grid = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Boolean>> test = new ArrayList<>();
        test.add(Collections.singletonList(false));
    }

    private static void processGrid(List<List<Boolean>> input, int row, int col) {
        //validation

        List<List<Boolean>> visited = new ArrayList<>();
        List<List<Integer>> move = new ArrayList<>();
        move.add(Arrays.asList(0, 1));
        move.add(Arrays.asList(0, -1));
        move.add(Arrays.asList(1, 0));
        move.add(Arrays.asList(-1, 0));
        //{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).size(); j++) {
                if (visited.get(i).get(j) || !input.get(i).get(j)) {
                    continue;
                } else {
                    processHelper(input, i, j, row, col, visited, move);
                }
            }

        }


    }

    private static Boolean processHelper(List<List<Boolean>> input, int i, int j, int row, int col, List<List<Boolean>> visited, List<List<Integer>> moves) {


        if (i < 0 || j < 0 || i >= input.size() || j >= input.get(i).size() || !input.get(i).get(j)) { // ||
            return false;
        }

        if (i == row && j == col) {
            return true;
        }

        if (!visited.get(i).get(j)) {

            visited.get(i).set(j, true);


            Boolean isGoalReachable = false;

            for (List<Integer> mv : moves) {

                Boolean reached = processHelper(input, i + mv.get(0), j + mv.get(1), row, col, visited, moves);
                if (reached) {
                    isGoalReachable = true;
                }
            }
            input.get(i).set(j, isGoalReachable);

            return isGoalReachable;

        }

        return input.get(i).get(j);

    }


}
