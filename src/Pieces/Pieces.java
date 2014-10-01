package Pieces;

/**
 * Author: Rodrigo Marliere
 * Revision date: 10/1/14
 * Assignment: CheckTheCheck
 * Class: CSCD 350
 */

public class Pieces
{
    static private String board[][] = new String[8][8];
    static private int games;

    static private String team_attacked;
    static private String king_attacked;

    static private Boolean IsInCheck = false;

    static private final String KING    = "K";
    static private final String QUEEN   = "Q";
    static private final String BISHOP  = "B";
    static private final String KNIGHT  = "N";
    static private final String ROOK    = "R";
    static private final String PAWN    = "P";
    static private final String EMPTY   = ".";

    /**
     * This method will iterate through each row and column getting each piece, identifying it and trying to tryTheAttack
     * the opposite king. For each piece it will call the method attack.
     *
     * @param board - The board object from the input with rows and columns.
     * @param game - An integer that will increment for each board sent to this method
     */
    public static void tryTheAttack(String[][] board, int game)
    {
        Pieces.board = board;
        Pieces.games = game;
        IsInCheck = false;
        for (int row = 0; row < 8; row++)
        {
            for (int column = 0; column < 8; column++)
            {
                String piece_type = board[row][column];
                setTeamAndKing(piece_type);

                if (piece_type.equalsIgnoreCase(KING))
                {
                    King king = new King();
                    attack(column, row, king.directions, king.squares, king.move, KING);
                }
                else if (piece_type.equalsIgnoreCase(QUEEN))
                {
                    Queen queen = new Queen();
                    attack(column, row, queen.directions, queen.squares, queen.move, QUEEN);
                }
                else if (piece_type.equalsIgnoreCase(ROOK))
                {
                    Rook rook = new Rook();
                    attack(column, row, rook.directions, rook.squares, rook.move, ROOK);
                }
                else if (piece_type.equalsIgnoreCase(BISHOP))
                {
                    Bishop bishop = new Bishop();
                    attack(column, row, bishop.directions, bishop.squares, bishop.move, BISHOP);
                }
                else if (piece_type.equalsIgnoreCase(KNIGHT))
                {
                    Knight knight = new Knight();
                    attack(column, row, knight.directions, knight.squares, knight.move, KNIGHT);
                }
                else if (piece_type.equalsIgnoreCase(PAWN))
                {
                    Pawn pawn = new Pawn(team_attacked);
                    attack(column, row, pawn.directions, pawn.squares, pawn.move, PAWN);
                }

                //if is in check, break both for loops
                if (IsInCheck)
                {
                    row = 8;
                    break;
                }
            }
        }
        if (!IsInCheck)
        {
            System.out.println("Game #"+games+": No King is in check.");
        }
    }

    /**
     *
     *
     *
     * @param column - The column the piece is from the start
     * @param row - The row the piece is from the start
     * @param directions - How many directions it should go
     * @param squares - How many squares the piece can move
     * @param move - The piece's movement pattern
     * @param piece_type - The kind of piece
     *
     * @return - It will return false if the king is not in check.
     */
    public static boolean attack(int column, int row, int directions, int squares, int move[][], String piece_type)
    {
        //test for each direction
        for (int direction = 0; direction < directions; direction++)
        {
            //get how many squares it can go
            int new_column    = column;
            int new_row        = row;
            for (int moves = 0; moves < squares; moves++)
            {
                new_column    = getColumn(direction, new_column, move);
                new_row        = getRow(direction, new_row, move);
                //valid position
                if (isValidPosition(new_column, new_row))
                {
                    String piece = board[new_row][new_column];
                    if (!isEmptyPosition(piece))
                    {
                        if (isInCheck(piece))
                        {
                            System.out.println("Game #"+games+": " + team_attacked + " King is in check!");
                        }
                        else if (!piece_type.equals("Knight"))
                        {
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * This method will set the opposite team and king based on the param piece
     *
     * @param piece - The piece that is attacking.
     */
    private static void setTeamAndKing(String piece)
    {
        char ch = piece.charAt(0);
        if (!piece.equals(EMPTY))
        {
            if (Character.isUpperCase(ch))
            {
                team_attacked = "Black";
                king_attacked = "k";
            }
            else
            {
                team_attacked = "White";
                king_attacked = "K";
            }
        }
    }

    /**
     * This method will return the next column move based on direction, column and movement pattern
     *
     * @param direction - The direction the piece is testing
     * @param column - The column where the piece is
     * @param move - The piece's movement pattern
     *
     * @return - It will return the new column value
     */
    private static int getColumn(int direction, int column, int move[][])
    {
        column = column + move[direction][0];
        return column;
    }

    /**
     * This method will return the next row move
     *
     * @param direction - The direction the piece is testing
     * @param row - The row where the piece is
     * @param move - The piece's movement pattern
     *
     * @return - It will return the new row value
     */
    private static int getRow(int direction, int row, int move[][])
    {
        row = row + move[direction][1];
        return row;
    }

    /**
     * It will check if the new piece's position is out of the board
     *
     * @param column - Piece's column
     * @param row - Piece's row
     *
     * @return - It will return true if the position is valid
     */
    private static boolean isValidPosition(int column, int row)
    {
        return !(column > 7 || column < 0 || row > 7 || row < 0);
    }

    /**
     * It will check if the new position is empty
     *
     * @param position - The position
     *
     * @return - It will return true if the position is empty
     */
    private static boolean isEmptyPosition(String position)
    {
        return position.equals(EMPTY);
    }

    /**
     * It will check if the king is on check
     *
     * @param piece - The piece being attacked
     *
     * @return - It will return true if the king is on check
     */
    private static boolean isInCheck(String piece)
    {
        if (piece.equals(king_attacked))
        {
            IsInCheck = true;
            return true;
        }
        return false;
    }
}
