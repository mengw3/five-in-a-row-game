package chess;

public interface moveStrategy {

    public boolean makeMove(int[][] chessboard, Piece currP, int x, int y);

    public boolean makeMoveFake(int[][] chessboard, Piece currP, int x, int y);

}
