package chess;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class Controller implements EventHandler<MouseEvent> {

    private Chessboard chessboard;
    private static int rows = 8, cols = 8;
    private double blockSize = 100;
    private int[][] chessControl = new int[rows][cols];
    private boolean gameover = false;
    private boolean blackKingWarning = false;
    private boolean whiteKingWarning = false;

    // constructor
    public Controller(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        getColorInfo();

        // get piece's location
        int x = 0;
        int y = 0;
        if (gameover == false) {
            x = (int)(mouseEvent.getX() / blockSize);
            y = (int)(mouseEvent.getY() / blockSize);
        }


        // if out of the range
        if (x >= rows || y >= cols) {
            return;
        }

        // if no piece is selected, select a piece
        if (isSelected() == null) {
            Piece selectedP = mouseSelected(x, y);
            if (selectedP == null) {
                return;
            }
            selectedP.setSelected(true);
            selectedP.getImagePic().setSmooth(true);
        }
        // otherwise, make a move
        else {
            Piece currP = isSelected();
            Piece newP = mouseSelected(x, y);
            // change the selected piece
            if (newP != null) {
                currP.setSelected(false);
                newP.setSelected(true);
            }
            // make a move
            else {
                moveStrategy MS = currP.getMoveStrategy();
                Piece targetP = targetPiece(x, y);
                // if make a move successfully, change side
                if (MS.makeMove(chessControl, currP, x, y)) {
                    getColorInfo();
                    if (targetP != null) {
                        isGameOver(targetP);
                        remove(targetP);
                    }
                    if (chessboard.getCurrSide().equals("White")) {
                        chessboard.setCurrSide("Black");
                    } else {
                        chessboard.setCurrSide("White");
                    }
                    blackKingWarning();
                    whiteKingWarning();
//                    checkmate();
                }
            }
        }

    }

    // 0 means the block is blank
    // 1 means the block has a black piece
    // 2 means the block has a white piece
    public void getColorInfo() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                chessControl[i][j] = 0;
            }
        }
        for (int i = 0; i < chessboard.getWhitePieceList().size(); i++) {
            Piece piece = (Piece) chessboard.getWhitePieceList().get(i);
            chessControl[piece.getX()][piece.getY()] = 2;
        }
        for (int i = 0; i < chessboard.getBlackPieceList().size(); i++) {
            Piece piece = (Piece) chessboard.getBlackPieceList().get(i);
            chessControl[piece.getX()][piece.getY()] = 1;
        }
    }

    // check if any piece of current side is selected
    public Piece isSelected() {
        // if current side is "white"
        if (chessboard.getCurrSide().equals("White")) {
            for (int i = 0; i < chessboard.getWhitePieceList().size(); i++) {
                Piece currP = (Piece) chessboard.getWhitePieceList().get(i);
                if (currP.getSelected()) {
                    return currP;
                }
            }
        }
        // if current side is "black"
        else {
            for (int i = 0; i < chessboard.getBlackPieceList().size(); i++) {
                Piece currP = (Piece) chessboard.getBlackPieceList().get(i);
                if (currP.getSelected()) {
                    return currP;
                }
            }
        }
        return null;
    }

    // check if select a piece correctly
    public Piece mouseSelected(int x, int y) {
        // if current side is "white"
        if (chessboard.getCurrSide().equals("White")) {
            for (int i = 0; i < chessboard.getWhitePieceList().size(); i++) {
                Piece currP = (Piece) chessboard.getWhitePieceList().get(i);
                if (x == currP.getX() && y == currP.getY()) {
                    return currP;
                }
            }
        }
        // if current side is "black"
        else {
            for (int i = 0; i < chessboard.getBlackPieceList().size(); i++) {
                Piece currP = (Piece) chessboard.getBlackPieceList().get(i);
                if (x == currP.getX() && y == currP.getY()) {
                    return currP;
                }
            }
        }
        return null;
    }

    // get a piece at target position
    public Piece targetPiece(int x, int y) {
        for (int i = 0; i < chessboard.getWhitePieceList().size(); i++) {
            Piece currP = (Piece) chessboard.getWhitePieceList().get(i);
            if (x == currP.getX() && y == currP.getY()) {
                return currP;
            }
        }
        for (int i = 0; i < chessboard.getBlackPieceList().size(); i++) {
            Piece currP = (Piece) chessboard.getBlackPieceList().get(i);
            if (x == currP.getX() && y == currP.getY()) {
                return currP;
            }
        }
        return null;
    }

    public void blackKingWarning() {
        // black king has checkmate warning
        blackKingWarning = false;
        int blackKingX = 0;
        int blackKingY = 0;
        for (int i = 0; i < chessboard.getBlackPieceList().size(); i++) {
            Piece currP = (Piece) chessboard.getBlackPieceList().get(i);
            if (currP.getType().equals(pieceType.blackKing)) {
                blackKingX = currP.getX();
                blackKingY = currP.getY();
//                System.out.println("blackKing location: " + "(" + blackKingX + "," + blackKingY + ")");
            }
        }
        for (int i = 0; i < chessboard.getWhitePieceList().size(); i++) {
            Piece currP = (Piece) chessboard.getWhitePieceList().get(i);
//            System.out.println(currP.toString());
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
//                    System.out.println("possible movements are:" + "(" + j + "," + k + ")" + currP.getMoveStrategy().makeMoveFake(chessControl, currP, j, k));
//                    System.out.println("BK threat:" + ((gameover == false) && currP.getMoveStrategy().makeMoveFake(chessControl, currP, j, k) && (j == blackKingX) && (k == blackKingY)));
                    if ((gameover == false) && currP.getMoveStrategy().makeMoveFake(chessControl, currP, j, k) && (j == blackKingX) && (k == blackKingY)) {
                        Alert output = new Alert(Alert.AlertType.INFORMATION);
                        String content = "Black King get checkmate warning!";
                        blackKingWarning = true;
                        output.setTitle("CHECKMATE WARNING");
                        output.setContentText(content);
                        output.show();
                        return;
                    }
                }
            }
        }
    }
    public void whiteKingWarning() {
        whiteKingWarning = false;
        int whiteKingX = 0;
        int whiteKingY = 0;
        for (int i = 0; i < chessboard.getWhitePieceList().size(); i++) {
            Piece currP = (Piece) chessboard.getWhitePieceList().get(i);
            if (currP.getType().equals(pieceType.whiteKing)) {
                whiteKingX = currP.getX();
                whiteKingY = currP.getY();
//                System.out.println("whiteKing location: " + "(" + whiteKingX + "," + whiteKingY + ")");
            }
        }
        for (int i = 0; i < chessboard.getBlackPieceList().size(); i++) {
            Piece currP = (Piece) chessboard.getBlackPieceList().get(i);
//            System.out.println(currP.toString());
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
//                    System.out.println("possible movements are:" + "(" + j + "," + k + ")" + currP.getMoveStrategy().makeMoveFake(chessControl, currP, j, k));
//                    System.out.println("WK threat:" + ((gameover == false) && currP.getMoveStrategy().makeMoveFake(chessControl, currP, j, k) && (j == whiteKingX) && (k == whiteKingY)));
                    if (gameover == false && currP.getMoveStrategy().makeMoveFake(chessControl, currP, j, k) && j == whiteKingX && k == whiteKingY) {
                        Alert output = new Alert(Alert.AlertType.INFORMATION);
                        String content = "White King get checkmate warning!";
                        whiteKingWarning = true;
                        output.setTitle("CHECKMATE WARNING");
                        output.setContentText(content);
                        output.show();
                        return;
                    }
                }
            }
        }
    }

    public void checkmate() {
        boolean canMoveBlack = false;
        boolean canMoveWhite = false;
        // black king get checkmate
        if (gameover == false) {
            allLoops:
            for (int i = 0; i < chessboard.getBlackPieceList().size(); i++) {
                Piece currP = (Piece) chessboard.getBlackPieceList().get(i);
                for (int j = 0; j < rows; j++) {
                    for (int k = 0; k < cols; k++) {
                        canMoveBlack = currP.getMoveStrategy().makeMoveFake(chessControl, currP, j, k);
                        if (canMoveBlack == true) {
                            break allLoops;
                        }
                    }
                }
            }
        }
        if (canMoveBlack == false && blackKingWarning == true) {
            Alert output = new Alert(Alert.AlertType.INFORMATION);
            String content = "Black King get checkmate! White wins!";
            gameover = true;
            output.setTitle("Game Over!");
            output.setContentText(content);
            output.show();
        }
        // white king get checkmate
        if (gameover == false) {
            allLoops:
            for (int i = 0; i < chessboard.getWhitePieceList().size(); i++) {
                Piece currP = (Piece) chessboard.getWhitePieceList().get(i);
                for (int j = 0; j < rows; j++) {
                    for (int k = 0; k < cols; k++) {
                        canMoveWhite = currP.getMoveStrategy().makeMoveFake(chessControl, currP, j, k);
                        if (canMoveWhite == true) {
                            break allLoops;
                        }
                    }
                }
            }
        }
        if (canMoveWhite == false && whiteKingWarning == true) {
            Alert output = new Alert(Alert.AlertType.INFORMATION);
            String content = "White King get checkmate! Black wins!";
            gameover = true;
            output.setTitle("Game Over!");
            output.setContentText(content);
            output.show();
        }
    }

    // check if game is over. Yes -- show info
    public void isGameOver(Piece targetP) {
        // king is eaten
        if (targetP.getType().equals(pieceType.blackKing) || targetP.getType().equals(pieceType.whiteKing)) {
            Alert output = new Alert(Alert.AlertType.INFORMATION);
            String content = chessboard.getCurrSide().equals("White")? "White wins!":"Black wins!";
            gameover = true;
            output.setTitle("Game Over!");
            output.setContentText(content);
            output.show();
        }
    }

    // remove the eaten piece
    public void remove(Piece targetP) {
        // remove the piece from chessboard
        targetP.getImagePic().setImage(null);
        // remove the white piece from piece list
        if (chessboard.getCurrSide().equals("White")){
            for(int i = 0; i < chessboard.getWhitePieceList().size(); i++) {
                Piece piece = (Piece) chessboard.getWhitePieceList().get(i);
                if(targetP.equals(piece)){
                    chessboard.getWhitePieceList().remove(i);
                    break;
                }
            }
        }
        // remove the black piece from piece list
        if (chessboard.getCurrSide().equals("Black")){
            for(int i = 0; i < chessboard.getBlackPieceList().size(); i++) {
                Piece piece = (Piece) chessboard.getBlackPieceList().get(i);
                if(targetP.equals(piece)){
                    chessboard.getBlackPieceList().remove(i);
                    break;
                }
            }
        }
    }
}
