package coding.practice;

import java.util.*;

public class MazeRunner {

    private static final int moves[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        List<List<Boolean>> grid = null;
        Location goal = null;
        List<List<Boolean>> result = null;


        //Reachable
        grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(true, false)));
        grid.add(new ArrayList<>(Arrays.asList(true, true)));
        goal = new Location(1, 1);

        System.out.println("\n\ngrid \n" + grid);
        result = modifyReachableGoal(grid, goal);
        System.out.println("result \n" + result);


        //Not Reachable
        grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(true, false)));
        grid.add(new ArrayList<>(Arrays.asList(true, true)));
        goal = new Location(1, 1);

        System.out.println("\n\ngrid \n" + grid);
        result = modifyReachableGoal(grid, goal);
        System.out.println("result \n" + result);


        //3*2 grid Reachable
        grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(true, false)));
        grid.add(new ArrayList<>(Arrays.asList(false, true)));
        grid.add(new ArrayList<>(Arrays.asList(true, true)));
        goal = new Location(1, 1);

        System.out.println("\n\ngrid \n" + grid);
        result = modifyReachableGoal(grid, goal);
        System.out.println("result \n" + result);


        //3*3 grid Reachable
        grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(true, false, true)));
        grid.add(new ArrayList<>(Arrays.asList(false, true, false)));
        grid.add(new ArrayList<>(Arrays.asList(true, true, false)));
        goal = new Location(2, 1);

        System.out.println("\n\ngrid \n" + grid);
        result = modifyReachableGoal(grid, goal);
        System.out.println("result \n" + result);

        //TODO unhappy path tests like invalid goal or grid

    }

    /**
     * Modified the grid to true if the given location can reach the goal
     * and false if the location cannot reach goal
     *
     * @param grid
     * @param goal
     * @return
     */

    private static List<List<Boolean>> modifyReachableGoal(List<List<Boolean>> grid, Location goal) {

        if (grid.isEmpty()) {
            return grid;
        }

        //validate goal is in bounds and not false
        if (goal.x < 0 || goal.x >= grid.size() || goal.y < 0 || goal.y >= grid.get(0).size() || !grid.get(goal.x).get(goal.y)) {
            throw new IllegalArgumentException("Incorrect location of goal");
        }

        //Initialize visited to false
        List<List<Boolean>> visited = new ArrayList<>(grid.size());
        for (List<Boolean> aGrid : grid) {
            visited.add(new ArrayList<>(Collections.nCopies(aGrid.size(), false)));
        }


        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) && !visited.get(i).get(j)) {
                    goalHelper(grid, goal, i, j, visited);
                }
            }

        }

        return grid;


    }

    private static Boolean goalHelper(List<List<Boolean>> grid, Location goal, int x, int y, List<List<Boolean>> visited) {

        //Edges or false space
        if (x < 0 || y < 0 || x >= grid.size() || y >= grid.get(x).size() || !grid.get(x).get(y)) {
            return false;
        }

        //Goal reached
        if (x == goal.x && y == goal.y) {
            return true;
        }

        if (visited.get(x).get(y)) {
            return grid.get(x).get(y);
        }


        visited.get(x).set(y, true);

        Boolean isGoalReachable = false;
        for (int[] mv : moves) {

            Boolean reached = goalHelper(grid, goal, x + mv[0], y + mv[1], visited);
            if (reached) {
                isGoalReachable = true;
                break; //minor optimization
            }
        }

        grid.get(x).set(y, isGoalReachable);

        return grid.get(x).get(y);
    }


    static class Location {
        //Ideally should be private
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return x == location.x &&
                    y == location.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }
}
