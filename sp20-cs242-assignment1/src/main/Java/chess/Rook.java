package chess;

public class Rook implements moveStrategy {

    @Override
    public boolean makeMove(int[][] chessboard, Piece currP, int x, int y) {
        int curr_x = currP.getX();
        int curr_y = currP.getY();
        if ((curr_x == x && isEmptyY(chessboard, curr_x, curr_y, y)) || (curr_y == y && isEmptyX(chessboard, curr_x, curr_y, x))) {
            currP.move(x, y);
            return true;
        }
        return false;
    }

    public boolean makeMoveFake(int[][] chessboard, Piece currP, int x, int y) {
        int curr_x = currP.getX();
        int curr_y = currP.getY();
        if ((curr_x == x && isEmptyY(chessboard, curr_x, curr_y, y)) || (curr_y == y && isEmptyX(chessboard, curr_x, curr_y, x))) {
            return true;
        }
        return false;
    }

    // check x-axis
    public boolean isEmptyX(int[][] chessboard, int currX, int currY, int newX) {
        if (currX < newX) {
            for (int i = 1; i < newX - currX; i++) {
                // 0 means the block is blank
                if (chessboard[currX + i][currY] != 0) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < currX - newX; i++) {
                // 0 means the block is blank
                if (chessboard[currX - i][currY] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // check y-axis
    public boolean isEmptyY(int[][] chessboard, int currX, int currY, int newY) {
        if (currY < newY) {
            for (int i = 1; i < newY - currY; i++) {
                // 0 means the block is blank
                if (chessboard[currX][currY + i] != 0) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < currY - newY; i++) {
                // 0 means the block is blank
                if (chessboard[currX][currY - i] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
