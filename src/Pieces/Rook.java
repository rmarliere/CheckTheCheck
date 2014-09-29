package Pieces;

/**
 * Created by RodrigoMarliere on 9/27/14.
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
