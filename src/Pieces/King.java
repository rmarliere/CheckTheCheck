package Pieces;

/**
 * Created by RodrigoMarliere on 9/27/14.
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
