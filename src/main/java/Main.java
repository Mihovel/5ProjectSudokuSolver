import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static boolean toExit = false;

    public static void prePreFillArrayFirstTime(String[][] SudokuBoard) {
        for (int i = 0; i < SudokuBoard.length; i++) {
            for (int j = 0; j < SudokuBoard.length; j++) {
                SudokuBoard[i][j] = ".";
            }
        }
    }

    public static void preFillArrayFirstTime(String[][] SudokuBoard) {
        SudokuBoard[0][0] = "5";
        SudokuBoard[0][1] = "3";
        SudokuBoard[0][4] = "7";
        SudokuBoard[1][0] = "6";
        SudokuBoard[1][3] = "1";
        SudokuBoard[1][4] = "9";
        SudokuBoard[1][5] = "5";
        SudokuBoard[2][1] = "9";
        SudokuBoard[2][2] = "8";
        SudokuBoard[2][7] = "6";
        SudokuBoard[3][0] = "8";
        SudokuBoard[3][4] = "6";
        SudokuBoard[3][8] = "3";
        SudokuBoard[4][0] = "4";
        SudokuBoard[4][3] = "8";
        SudokuBoard[4][5] = "3";
        SudokuBoard[4][8] = "1";
        SudokuBoard[5][0] = "7";
        SudokuBoard[5][4] = "2";
        SudokuBoard[5][8] = "6";
        SudokuBoard[6][1] = "6";
        SudokuBoard[6][6] = "2";
        SudokuBoard[6][7] = "8";
        SudokuBoard[7][3] = "4";
        SudokuBoard[7][4] = "1";
        SudokuBoard[7][5] = "9";
        SudokuBoard[7][8] = "5";
        SudokuBoard[8][4] = "8";
        SudokuBoard[8][7] = "7";
        SudokuBoard[8][8] = "9";
    }

    public static void printArray(String[][] SudokuBoard) {
        for (int i = 0; i < SudokuBoard.length; i++) {
            for (int j = 0; j < SudokuBoard.length; j++) {
                System.out.print(SudokuBoard[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static List<String> getAllPossibleNumbersForCurrentPosition(String[][] SudokuBoard, int I, int J) {
        List<String> getAllPossibleNumbersForCurrentPosition = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            getAllPossibleNumbersForCurrentPosition.add(Integer.toString(i));
        }
        for (int i = 0; i < SudokuBoard.length; i++) {
            if (SudokuBoard[i][J].matches("[1-9]?")) {
                getAllPossibleNumbersForCurrentPosition.remove(SudokuBoard[i][J]);
            }
        }
        for (int i = 0; i < SudokuBoard.length; i++) {
            if (SudokuBoard[I][i].matches("[1-9]?")) {
                getAllPossibleNumbersForCurrentPosition.remove(SudokuBoard[I][i]);
            }
        }
        int startingI = Math.floorDiv(I, 3) * 3;
        int startingJ = Math.floorDiv(J, 3) * 3;
        for (int i = startingI; i < startingI + 3; i++) {
            for (int j = startingJ; j < startingJ + 3; j++) {
                if (SudokuBoard[i][j].matches("[1-9]?")) {
                    getAllPossibleNumbersForCurrentPosition.remove(SudokuBoard[i][j]);
                }
            }
        }
        return getAllPossibleNumbersForCurrentPosition;
    }


    public static void solveSudoku(String[][] SudokuBoard, int posI, int posJ) {
        toExit = false;
        int bestI = 0;
        int bestJ = 0;
        List<String> listForNextIJ = new ArrayList<>();
        int smallestLength = 9;
        boolean isSudokuBoardFilled = true;
        for (int i = 0; i < SudokuBoard.length; i++) {
            for (int j = 0; j < SudokuBoard.length; j++) {
                if (SudokuBoard[i][j].equals(".")) {
                    isSudokuBoardFilled = false;
                }
            }
        }
        if (!isSudokuBoardFilled) {
            for (int i = 0; i < SudokuBoard.length; i++) {
                for (int j = 0; j < SudokuBoard.length; j++) {
                    if (SudokuBoard[i][j].equals(".")) {
                        List<String> getAllNumberForIJ =   getAllPossibleNumbersForCurrentPosition(SudokuBoard, i, j);
                        if (getAllNumberForIJ.size() == 0) {
                            toExit = true;
                            break;
                        }
                        if (toExit) {
                            break;
                        }
                        if (getAllNumberForIJ.size() == 1) {
                            SudokuBoard[i][j] = getAllNumberForIJ.get(0);
                        } else {
                            if (getAllNumberForIJ.size() < smallestLength) {
                                smallestLength = getAllNumberForIJ.size();
                                bestI = i;
                                bestJ = j;
                                listForNextIJ = getAllNumberForIJ;
                            }
                        }
                    }
                    if (toExit) {
                        break;
                    }
                }
                if (toExit) {
                    break;
                }
            }
            if (!toExit) {
                for (String s : listForNextIJ) {
                    SudokuBoard[bestI][bestJ] = s;
                    System.out.println("bestI = " + bestI);
                    System.out.println("bestJ = " + bestJ);
                    printArray(SudokuBoard);
                    System.out.println();
                    String[][] SudokuBoardRec = new String[9][9];
                    for (int i = 0; i < SudokuBoard.length; i++) {
                        System.arraycopy(SudokuBoard[i], 0, SudokuBoardRec[i], 0, SudokuBoard[i].length);
                    }
                    solveSudoku(SudokuBoardRec, bestI, bestJ);
                }
            }

        }
        else {
        }
    }

    public static void main(String[] args) {
        String[][] SudokuBoard = new String[9][9];
        prePreFillArrayFirstTime(SudokuBoard);
        preFillArrayFirstTime(SudokuBoard);
        //printArray(SudokuBoard);
        List<String> lst = new ArrayList<>();
        solveSudoku(SudokuBoard, 0, 0);
    }

}
