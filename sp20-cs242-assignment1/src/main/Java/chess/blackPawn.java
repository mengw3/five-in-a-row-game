package chess;

public class blackPawn implements moveStrategy {

    // count how mamy times make the whitePawn piece move
    private int moveCount = 0;
//    private int becomeQ = 0;

    @Override
    // blackPawn only can move from top to the bottom
    // 0 means the block is blank
    // 1 means the block has a black piece
    // 2 means the block has a white piece
    public boolean makeMove(int[][] chessboard, Piece currP, int x, int y) {
        // not eat a white piece
        if (chessboard[x][y] == 0) {
            if (moveCount == 0) {
                if ((x == currP.getX()) && (currP.getY() - y == 1)) {
                    currP.move(x, y);
                    moveCount++;
                    return true;
                }
                if ((x == currP.getX()) && (currP.getY() - y == 2) && (chessboard[currP.getX()][currP.getY() - 1] == 0)) {
                    currP.move(x, y);
                    moveCount++;
                    return true;
                }
            } else {
                if ((x == currP.getX()) && (currP.getY() - y == 1)) {
                    currP.move(x, y);
                    moveCount++;
                    // a Pawn becomes a Queen
//                    if (y == becomeQ) {
//                        changeType(currP);
//                    }
                    return true;
                }
            }
        }
        // eat a black piece
        if (chessboard[x][y] == 2) {
            if ((Math.abs(x - currP.getX()) == 1) && (currP.getY() - y == 1)) {
                currP.move(x, y);
                moveCount++;
                // a Pawn becomes a Queen
//                    if (y == becomeQ) {
//                        changeType(currP);
//                    }
                return true;
            }
        }
        return false;
    }

    public boolean makeMoveFake(int[][] chessboard, Piece currP, int x, int y) {
        // not eat a white piece
        if (chessboard[x][y] == 0) {
            if (moveCount == 0) {
                if ((x == currP.getX()) && (currP.getY() - y == 1)) {
                    return true;
                }
                if ((x == currP.getX()) && (currP.getY() - y == 2) && (chessboard[currP.getX()][currP.getY() - 1] == 0)) {
                    return true;
                }
            } else {
                if ((x == currP.getX()) && (currP.getY() - y == 1)) {
                    return true;
                }
            }
        }
        // eat a white piece
        if (chessboard[x][y] == 2) {
            if ((Math.abs(x - currP.getX()) == 1) && (currP.getY() - y == 1)) {
                return true;
            }
        }
        return false;
    }

    public void changeType(Piece pawn) {
        // make a pawn become a queen
    }

}
