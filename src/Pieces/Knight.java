package Pieces;

/**
 * Created by RodrigoMarliere on 9/27/14.
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
