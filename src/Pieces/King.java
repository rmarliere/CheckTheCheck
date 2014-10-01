package Pieces;

/**
 * Author: Rodrigo Marliere
 * Revision date: 10/1/14
 * Assignment: CheckTheCheck
 * Class: CSCD 350
 */

public class King
{
    public int squares = 1;
    public int directions = 8;
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
