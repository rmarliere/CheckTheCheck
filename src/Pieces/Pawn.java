package Pieces;

/**
 * Author: Rodrigo Marliere
 * Revision date: 10/1/14
 * Assignment: CheckTheCheck
 * Class: CSCD 350
 */

public class Pawn extends Pieces
{
    public int squares = 1;
    public int directions = 2;
    public int black_move[][] = {
                                {1, 1},
                                {-1, 1}};
    public int white_move[][] = {
                                {1, -1},
                                {-1, -1}};
    public int move[][] = {};

    /**
     * It will decide which move to use for the pawn
     *
     * @param team_attacked - The team that is being attacked
     */
    public Pawn(String team_attacked)
    {
        if (team_attacked.equals("Black"))
        {
            move = white_move;
        }
        else
        {
            move = black_move;
        }
    }
}
