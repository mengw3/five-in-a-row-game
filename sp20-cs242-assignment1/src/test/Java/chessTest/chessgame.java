package chessTest;

import chess.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;

public class chessgame extends Application {

    private int boardSize = 800;

    @Test
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chessboard Game");
        Chessboard chessboard = new Chessboard();
        chessboard.setOnMouseClicked(new Controller(chessboard));
        primaryStage.setScene(new Scene(chessboard, boardSize, boardSize));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
