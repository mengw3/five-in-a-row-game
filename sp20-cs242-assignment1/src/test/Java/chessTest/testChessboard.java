package chessTest;

import chess.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;

public class testChessboard extends TestCase {

    Chessboard chessboard = new Chessboard();

    @Test
    public void testBoard() {
        try {
            Assert.assertEquals(chessboard.board, new Canvas(800, 800));
        } catch (Exception e) {
            Assert.fail("Should create a chessboard");
        }
    }

//    @Test
//    public void testSide() {
//        try {
//            chessboard.setCurrSide("White");
//            Assert.assertEquals(chessboard.getCurrSide(), "White");
//        } catch (Exception e) {
//            Assert.fail("Should be white side move");
//        }
//
//        try {
//            chessboard.setCurrSide("Black");
//            Assert.assertEquals(chessboard.getCurrSide(), "Black");
//        } catch (Exception e) {
//            Assert.fail("Should be black side move");
//        }
//    }
//
//    public void testBoardColor() {
//        int rows = 8;
//        int cols = 8;
//        try {
//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j < cols; j++) {
//                    if ((i + j) % 2 == 0) {
//                        Assert.assertEquals(chessboard.gc.getFill(), Color.GRAY);
//                    } else {
//                        Assert.assertEquals(chessboard.gc.getFill(), Color.WHITE);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            Assert.fail("Get wrong chessboard color");
//        }
//    }

}
