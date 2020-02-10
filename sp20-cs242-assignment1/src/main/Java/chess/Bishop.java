package chess;

public class Bishop implements moveStrategy {

    @Override
    public boolean makeMove(int[][] chessboard, Piece currP, int x, int y) {
        int curr_x = currP.getX();
        int curr_y = currP.getY();
        if ((Math.abs(x - curr_x) == Math.abs(y - curr_y)) && (isEmpthD(chessboard, curr_x, curr_y, x, y))) {
            currP.move(x, y);
            return true;
        }
        return false;
    }

    public boolean makeMoveFake(int[][] chessboard, Piece currP, int x, int y) {
        int curr_x = currP.getX();
        int curr_y = currP.getY();
        if ((Math.abs(x - curr_x) == Math.abs(y - curr_y)) && (isEmpthD(chessboard, curr_x, curr_y, x, y))) {
            return true;
        }
        return false;
    }

    // check diagonal
    public boolean isEmpthD(int[][] chessboard, int currX, int currY, int newX, int newY) {
        if (currX < newX) {
            if (currY < newY) {
                for (int i = 1; i < newX - currX; i++) {
                    if (chessboard[currX + i][currY + i] != 0) {
                        return false;
                    }
                }
            } else {
                for (int i = 1; i < newX - currX; i++) {
                    if (chessboard[currX + i][currY - i] != 0) {
                        return false;
                    }
                }
            }
        } else {
            if (currY < newY) {
                for (int i = 1; i < currX - newX; i++) {
                    if (chessboard[currX - i][currY + i] != 0) {
                        return false;
                    }
                }
            } else {
                for (int i = 1; i < currX - newX; i++) {
                    if (chessboard[currX - i][currY - i] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
