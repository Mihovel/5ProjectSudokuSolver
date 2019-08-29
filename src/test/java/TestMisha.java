import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMisha {
    @Test
    public void testNeighbors11() {
        String[][] sudokuBoard = new String[9][9];
        Main.prePreFillArrayFirstTime(sudokuBoard);
        Main.preFillArrayFirstTime(sudokuBoard);
        List<String> list11 = Main.getAllPossibleNumbersForCurrentPosition(sudokuBoard, 1, 1);
        ArrayList<String> expectedList11 = new ArrayList<>();
        expectedList11.add("2");
        expectedList11.add("4");
        expectedList11.add("7");
        Assert.assertEquals(expectedList11, list11);
        Assert.assertTrue(equalLists(expectedList11, list11));
    }

    public boolean equalLists(List<String> one, List<String> two) {
        if (one == null && two == null) {
            return true;
        }

        if ((one == null && two != null)
                || one != null && two == null
                || one.size() != two.size()) {
            return false;
        }

        //to avoid messing the order of the lists we will use a copy
        //as noted in comments by A. R. S.
        one = new ArrayList<String>(one);
        two = new ArrayList<String>(two);

        Collections.sort(one);
        Collections.sort(two);
        return one.equals(two);
    }

    @Test
    public void testNeighbors111() {
        String[][] sudokuBoard = new String[9][9];
        Main.prePreFillArrayFirstTime(sudokuBoard);
        Main.preFillArrayFirstTime(sudokuBoard);
        List<String> list11 = Main.getAllPossibleNumbersForCurrentPosition(sudokuBoard, 4, 4);
        ArrayList<String> expectedList11 = new ArrayList<>();
        expectedList11.add("5");
        Assert.assertEquals(expectedList11, list11);
        Assert.assertTrue(equalLists(expectedList11, list11));
    }


    @Test
    public void testNeighbors25() {
        String[][] sudokuBoard = new String[9][9];
        Main.prePreFillArrayFirstTime(sudokuBoard);
        Main.preFillArrayFirstTime(sudokuBoard);
        List<String> list11 = Main.getAllPossibleNumbersForCurrentPosition(sudokuBoard, 2, 5);
        ArrayList<String> expectedList11 = new ArrayList<>();
        expectedList11.add("5");
        Assert.assertEquals(expectedList11, list11);
        Assert.assertTrue(equalLists(expectedList11, list11));
    }
    @Test
    public void testNeighbors03() {
        String[][] sudokuBoard = new String[9][9];
        Main.prePreFillArrayFirstTime(sudokuBoard);
        Main.preFillArrayFirstTime(sudokuBoard);
        Main.printArray(sudokuBoard);
        List<String> list11 = Main.getAllPossibleNumbersForCurrentPosition(sudokuBoard, 0, 3);
        ArrayList<String> expectedList11 = new ArrayList<>();
        expectedList11.add("2");
        Assert.assertEquals(expectedList11, list11);
        Assert.assertTrue(equalLists(expectedList11, list11));
    }


}
