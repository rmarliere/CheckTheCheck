package Pieces;

/**
 * Created by RodrigoMarliere on 9/27/14.
 */
public class Pieces
{
    static private String board[][] = new String[8][8];
    static private int games;

    static private String TEAM_ATTACKED;
    static private String KING_ATTACKED;

    static private Boolean is_in_check  = false;

    static private final String KING    = "K";
    static private final String QUEEN   = "Q";
    static private final String BISHOP  = "B";
    static private final String KNIGHT  = "N";
    static private final String ROOK    = "R";
    static private final String PAWN    = "P";
    static private final String EMPTY   = ".";

    public static void test_attacks(String[][] board, int game)
    {
        Pieces.board = board;
        games = game;
        is_in_check = false;
        for (int i = 0; i < 8; i++)
        {
            int line = i;
            for (int k = 0; k < 8; k++)
            {
                int pos = k;
                String piece_type = board[i][k];
                set_team_and_king(piece_type);

                if (piece_type.equalsIgnoreCase(KING))
                {
                    King king = new King();
                    attack(pos, line, king.directions, king.squares, king.move, KING);
                }
                else if (piece_type.equalsIgnoreCase(QUEEN))
                {
                    Queen queen = new Queen();
                    attack(pos, line, queen.directions, queen.squares, queen.move, QUEEN);
                }
                else if (piece_type.equalsIgnoreCase(ROOK))
                {
                    Rook rook = new Rook();
                    attack(pos, line, rook.directions, rook.squares, rook.move, ROOK);
                }
                else if (piece_type.equalsIgnoreCase(BISHOP))
                {
                    Bishop bishop = new Bishop();
                    attack(pos, line, bishop.directions, bishop.squares, bishop.move, BISHOP);
                }
                else if (piece_type.equalsIgnoreCase(KNIGHT))
                {
                    Knight knight = new Knight();
                    attack(pos, line, knight.directions, knight.squares, knight.move, KNIGHT);
                }
                else if (piece_type.equalsIgnoreCase(PAWN))
                {
                    Pawn pawn = new Pawn(TEAM_ATTACKED);
                    attack(pos, line, pawn.directions, pawn.squares, pawn.move, PAWN);
                }

                //if is in check, break both for loops
                if (is_in_check)
                {
                    i = 8;
                    break;
                }
            }
        }
        if (!is_in_check)
        {
            System.out.println("Game #"+games+": No King is in check.");
        }
    }

    public static boolean attack(int position, int line, int directions, int squares, int move[][], String piece_type)
    {
        //test for each direction
        for (int i = 0; i < directions; i++)
        {
            //get how many squares it can go
            int new_position    = position;
            int new_line        = line;
            for (int k = 0; k < squares; k++)
            {
                new_position    = get_position(i, new_position, move);
                new_line        = get_line(i, new_line, move);
                //valid position
                if (is_valid_position(new_position, new_line))
                {
                    String piece = board[new_line][new_position];
                    if (!is_empty_position(piece))
                    {
                        if (is_in_check(piece))
                        {
                            System.out.println("Game #"+games+": " + TEAM_ATTACKED + " King is in check!");
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

    public static void set_team_and_king(String piece)
    {
        char ch = piece.charAt(0);
        if (!piece.equals(EMPTY))
        {
            if (Character.isUpperCase(ch))
            {
                TEAM_ATTACKED = "Black";
                KING_ATTACKED = "k";
            }
            else
            {
                TEAM_ATTACKED = "White";
                KING_ATTACKED = "K";
            }
        }
    }

    //helpers
    public static int get_position(int i, int position, int move[][])
    {
        position = position + move[i][0];
        return position;
    }

    public static int get_line(int i, int line, int move[][])
    {
        line = line + move[i][1];
        return line;
    }

    public static boolean is_valid_position(int pos, int line)
    {
        if (pos > 7 || pos < 0 || line > 7 || line < 0)
        {
            return false;
        }
        return true;
    }

    public static boolean is_empty_position(String piece)
    {
        return piece.equals(EMPTY);
    }

    public static boolean is_in_check(String piece)
    {
        if (piece.equals(KING_ATTACKED))
        {
            is_in_check = true;
            return true;
        }
        return false;
    }
}
