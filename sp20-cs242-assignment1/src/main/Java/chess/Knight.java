package chess;

public class Knight implements moveStrategy {

    @Override
    public boolean makeMove(int[][] chessboard, Piece currP, int x, int y) {
        int curr_x = currP.getX();
        int curr_y = currP.getY();
        if ((Math.abs(x - curr_x) + Math.abs(y - curr_y)) == 3) {
            currP.move(x, y);
            return true;
        }
        return false;
    }

    public boolean makeMoveFake(int[][] chessboard, Piece currP, int x, int y) {
        int curr_x = currP.getX();
        int curr_y = currP.getY();
        if ((Math.abs(x - curr_x) + Math.abs(y - curr_y)) == 3) {
            return true;
        }
        return false;
    }

}
