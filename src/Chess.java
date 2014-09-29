/**
 * Created by RodrigoMarliere on 9/27/14.
 */

import Pieces.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Chess {

    static private String board[][] = new String[8][8];

    public static void main(String args[]) throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new FileReader("/Users/RodrigoMarliere/game.txt"));
        String line = null;
        String newLine = "";
        int lines = 0;

        try {
            while ((line = reader.readLine()) != null) {
                String board_line[] = new String[8];
                for (int i = 0; i < line.length(); i++)
                {
                    if (line.charAt(i) != ' ')
                    {
                        newLine = newLine + line.charAt(i);
                        board_line[i] = (String.valueOf(line.charAt(i)));
                    }
                }
                board[lines] = board_line;
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pieces.test_attacks(board);
    }


}