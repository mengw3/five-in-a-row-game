package chess;

public enum pieceType {
    blackKing("/picture/blackKing.png"),
    blackRook("/picture/blackRook.png"),
    blackBishop("/picture/blackBishop.png"),
    blackQueen("/picture/blackQueen.png"),
    blackKnight("/picture/blackKnight.png"),
    blackPawn("/picture/blackPawn.png"),
    whiteKing("/picture/whiteKing.png"),
    whiteRook("/picture/whiteRook.png"),
    whiteBishop("/picture/whiteBishop.png"),
    whiteQueen("/picture/whiteQueen.png"),
    whiteKnight("/picture/whiteKnight.png"),
    whitePawn("/picture/whitePawn.png");

    private String imagePath;

    private pieceType(String s) {
        this.imagePath = s;
    }

    public String getImage() {
        return imagePath;
    }
}
