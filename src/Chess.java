/**
 * Author: Rodrigo Marliere
 * Revision date: 10/1/14
 * Assignment: CheckTheCheck
 * Class: CSCD 350
 */

import Pieces.*;

import java.io.*;

public class Chess {

    static private String board[][] = new String[8][8];

    /**
     * This method reads the file on the input and put the board into object board.
     * After the board is complete, it will call the method tryTheAttack.
     *
     * @param args
     * @throws java.io.FileNotFoundException
     */
    public static void main(String args[]) throws FileNotFoundException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        String newLine = "";
        int lines = 0;
        int games = 0;

        try {
            while ((line = reader.readLine()) != null) {
                String board_line[] = new String[8];
                //remove whitespaces
                line = line.replaceAll("\\s+","");
                for (int line_char = 0; line_char < line.length(); line_char++)
                {
                    if (line.charAt(line_char) != ' ')
                    {
                        newLine = newLine + line.charAt(line_char);
                        board_line[line_char] = (String.valueOf(line.charAt(line_char)));
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
                        Pieces.tryTheAttack(board, games);
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}