package chessTest;

import chess.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;

public class testPiece {

    @Test
    public void testKing() {
        Piece blackKing = new Piece(4, 7, pieceType.blackKing,new King());
        Assert.assertEquals(blackKing.getX(), 4);
        Assert.assertEquals(blackKing.getY(), 7);
        Assert.assertEquals(blackKing.getType(), "King");
        Assert.assertFalse(blackKing.getSelected());
        blackKing.setSelected(true);
        Assert.assertTrue(blackKing.getSelected());
    }

}
