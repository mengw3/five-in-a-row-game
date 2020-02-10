package chess;

public class King implements moveStrategy {

    @Override
    public boolean makeMove(int[][] chessboard, Piece currP, int x, int y) {
        if ((Math.abs(x - currP.getX()) <= 1) && (Math.abs(y - currP.getY()) <= 1)) {
            currP.move(x, y);
            return true;
        }
        return false;
    }

    public boolean makeMoveFake(int[][] chessboard, Piece currP, int x, int y) {
        if ((Math.abs(x - currP.getX()) <= 1) && (Math.abs(y - currP.getY()) <= 1)) {
            return true;
        }
        return false;
    }

}
