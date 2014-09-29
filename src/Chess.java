/**
 * Created by RodrigoMarliere on 9/27/14.
 */

import Pieces.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Chess {

    static private String board[][] = new String[8][8];

    public static void main(String args[]) throws FileNotFoundException
    {
        //String filename = args[0];
        //System.out.println(filename);
        BufferedReader reader = new BufferedReader(new FileReader("/Users/RodrigoMarliere/game.txt"));
        String line = null;
        String newLine = "";
        int lines = 0;
        int games = 0;

        try {
            while ((line = reader.readLine()) != null) {
                String board_line[] = new String[8];
                line = line.replaceAll("\\s+",""); //remove whitespaces
                for (int i = 0; i < line.length(); i++)
                {
                    if (line.charAt(i) != ' ')
                    {
                        newLine = newLine + line.charAt(i);
                        board_line[i] = (String.valueOf(line.charAt(i)));
                    }
                }
                if (line.length() == 8)
                {
                    board[lines] = board_line;
                    lines++;
                    if (lines == 8)
                    {
                        games++;
                        lines = 0;
                        Pieces.test_attacks(board, games);
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}