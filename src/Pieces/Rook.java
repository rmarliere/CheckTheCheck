package Pieces;

/**
 * Author: Rodrigo Marliere
 * Revision date: 10/1/14
 * Assignment: CheckTheCheck
 * Class: CSCD 350
 */

public class Rook
{
    public int squares = 8;
    public int directions = 4;
    public int move[][] = {
                            {0, -1},
                            {0, 1},
                            {-1, 0},
                            {1, 0},
                            {-1, 1},
                            {-1,-1},
                            {1, -1},
                            {1, 1} };
}
