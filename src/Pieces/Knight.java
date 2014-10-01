package Pieces;

/**
 * Author: Rodrigo Marliere
 * Revision date: 10/1/14
 * Assignment: CheckTheCheck
 * Class: CSCD 350
 */

public class Knight extends Pieces
{
    public int squares = 1;
    public int directions = 8;
    public int move[][] = {
                            {-2, -1},
                            {-1, -2},
                            {2, -1},
                            {1, -2},
                            {-2, 1},
                            {-1, 2},
                            {2, 1},
                            {1, 2} };
}
