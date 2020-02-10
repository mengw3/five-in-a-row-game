package chess;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class Chessboard extends Pane {

    private ArrayList whitePieceList = new ArrayList<Piece>();
    private ArrayList blackPieceList = new ArrayList<Piece>();

    private String currSide = "White";

    public Canvas board;
    public GraphicsContext gc;
    private double blockSize = 100;

    private static int rows = 8, cols = 8;

    // constructor
    public Chessboard() {
        this.board = new Canvas(blockSize * rows, blockSize * cols);
        this.gc = board.getGraphicsContext2D();
        getChildren().add(board);

        // initial chessboard
        initialBackground();
        initialPieces();
    }

    public void setCurrSide(String newCurrSide) {
        this.currSide = newCurrSide;
    }

    public String getCurrSide() {
        return currSide;
    }

    public void initialBackground() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.GRAY);
                } else {
                    gc.setFill(Color.WHITE);
                }
                gc.fillRect(i * blockSize, j * blockSize, blockSize, blockSize);
            }
        }
    }

    public void initialPieces() {
        initBlackKing();
        initBlackRook();
        initBlackBishop();
        initBlackQueen();
        initBlackKnight();
        initBlackPawn();
        initWhiteKing();
        initWhiteRook();
        initWhiteBishop();
        initWhiteQueen();
        initWhiteKnight();
        initWhitePawn();
    }

    public void initBlackKing() {
        Piece blackKing = new Piece(4, 7,pieceType.blackKing,new King());
        blackPieceList.add(blackKing);
        setPiece(blackKing, 4, 7);
        getChildren().add(blackKing.getImagePic());
    }

    public void initBlackRook() {
        Piece blackRook1 = new Piece(0, 7,pieceType.blackRook,new Rook());
        blackPieceList.add(blackRook1);
        setPiece(blackRook1, 0, 7);
        getChildren().add(blackRook1.getImagePic());
        Piece blackRook2 = new Piece(7, 7,pieceType.blackRook,new Rook());
        blackPieceList.add(blackRook2);
        setPiece(blackRook2, 7, 7);
        getChildren().add(blackRook2.getImagePic());
    }

    public void initBlackBishop() {
        Piece blackBishop1 = new Piece(2, 7,pieceType.blackBishop,new Bishop());
        blackPieceList.add(blackBishop1);
        setPiece(blackBishop1, 2, 7);
        getChildren().add(blackBishop1.getImagePic());
        Piece blackBishop2 = new Piece(5, 7,pieceType.blackBishop,new Bishop());
        blackPieceList.add(blackBishop2);
        setPiece(blackBishop2, 5, 7);
        getChildren().add(blackBishop2.getImagePic());
    }

    public void initBlackQueen() {
        Piece blackQueen = new Piece(3, 7,pieceType.blackQueen,new Queen());
        blackPieceList.add(blackQueen);
        setPiece(blackQueen, 3, 7);
        getChildren().add(blackQueen.getImagePic());
    }

    public void initBlackKnight() {
        Piece blackKnight1 = new Piece(1, 7,pieceType.blackKnight,new Knight());
        blackPieceList.add(blackKnight1);
        setPiece(blackKnight1, 1, 7);
        getChildren().add(blackKnight1.getImagePic());
        Piece blackKnight2 = new Piece(6, 7,pieceType.blackKnight,new Knight());
        blackPieceList.add(blackKnight2);
        setPiece(blackKnight2, 6, 7);
        getChildren().add(blackKnight2.getImagePic());
    }

    public void initBlackPawn() {
        for(int i = 0; i < 8; i++){
            Piece blackPawn = new Piece(i, 6, pieceType.blackPawn,new blackPawn());
            blackPieceList.add(blackPawn);
            setPiece(blackPawn, i, 6);
            getChildren().add(blackPawn.getImagePic());
        }
    }

    public void initWhiteKing() {
        Piece whiteKing = new Piece(4, 0,pieceType.whiteKing,new King());
        whitePieceList.add(whiteKing);
        setPiece(whiteKing, 4, 0);
        getChildren().add(whiteKing.getImagePic());
    }

    public void initWhiteRook() {
        Piece whiteRook1 = new Piece(0, 0,pieceType.whiteRook,new Rook());
        whitePieceList.add(whiteRook1);
        setPiece(whiteRook1, 0, 0);
        getChildren().add(whiteRook1.getImagePic());
        Piece whiteRook2 = new Piece(7, 0,pieceType.whiteRook,new Rook());
        whitePieceList.add(whiteRook2);
        setPiece(whiteRook2, 7, 0);
        getChildren().add(whiteRook2.getImagePic());
    }

    public void initWhiteBishop() {
        Piece whiteBishop1 = new Piece(2, 0,pieceType.whiteBishop,new Bishop());
        whitePieceList.add(whiteBishop1);
        setPiece(whiteBishop1, 2, 0);
        getChildren().add(whiteBishop1.getImagePic());
        Piece whiteBishop2 = new Piece(5, 0,pieceType.whiteBishop,new Bishop());
        whitePieceList.add(whiteBishop2);
        setPiece(whiteBishop2, 5, 0);
        getChildren().add(whiteBishop2.getImagePic());
    }

    public void initWhiteQueen() {
        Piece whiteQueen = new Piece(3, 0,pieceType.whiteQueen,new Queen());
        whitePieceList.add(whiteQueen);
        setPiece(whiteQueen, 3, 0);
        getChildren().add(whiteQueen.getImagePic());
    }

    public void initWhiteKnight() {
        Piece whiteKnight1 = new Piece(1, 0,pieceType.whiteKnight,new Knight());
        whitePieceList.add(whiteKnight1);
        setPiece(whiteKnight1, 1, 0);
        getChildren().add(whiteKnight1.getImagePic());
        Piece whiteKnight2 = new Piece(6, 0,pieceType.whiteKnight,new Knight());
        whitePieceList.add(whiteKnight2);
        setPiece(whiteKnight2, 6, 0);
        getChildren().add(whiteKnight2.getImagePic());
    }

    public void initWhitePawn() {
        for(int i = 0; i < 8; i++){
            Piece whitePawn = new Piece(i, 1, pieceType.whitePawn,new whitePawn());
            whitePieceList.add(whitePawn);
            setPiece(whitePawn, i, 1);
            getChildren().add(whitePawn.getImagePic());
        }
    }

    public void setPiece(Piece piece, int x, int y) {
        piece.getImagePic().setX(x*blockSize);
        piece.getImagePic().setY(y*blockSize);
        piece.getImagePic().setFitHeight(blockSize);
        piece.getImagePic().setFitWidth(blockSize);
    }

    public ArrayList getWhitePieceList() {
        return whitePieceList;
    }

    public ArrayList getBlackPieceList() {
        return blackPieceList;
    }

}
