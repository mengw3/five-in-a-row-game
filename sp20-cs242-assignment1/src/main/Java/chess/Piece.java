package chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Piece {

    // image of the piece
    private ImageView imagePic;

    // location of the piece
    private int x;
    private int y;

    private double blocksize = 100;

    // type of the piece
    private pieceType type;

    // if the piece get selected
    private boolean selected;

    // how the piece move
    private moveStrategy strategy;

    // constructor
    public Piece(int x, int y, pieceType type, moveStrategy strategy) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.strategy = strategy;
        Image image = new Image(type.getImage());
        imagePic = new ImageView(image);
    }

    // get image
    public ImageView getImagePic() {
        return imagePic;
    }

    // set location
    public void setX(int newX) {
        this.x = newX;
    }
    public void setY(int newY) {
        this.y = newY;
    }

    // get location
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    // get type
    public pieceType getType() {
        return type;
    }

    // get selected status
    public boolean getSelected() {
        return selected;
    }

    // set selected status
    public void setSelected(boolean newSelected) {
        this.selected = newSelected;
    }

    // get move strategy
    public moveStrategy getMoveStrategy() {
        return strategy;
    }

    // move
    public void move(int x, int y) {
        this.setSelected(false);
        this.x = x;
        this.y = y;
        this.imagePic.setX(x * blocksize);
        this.imagePic.setY(y * blocksize);
    }

    // print out type
    public String toString() {
        return "chessPiece{" + "chessType=" + type + '}';
    }

}
