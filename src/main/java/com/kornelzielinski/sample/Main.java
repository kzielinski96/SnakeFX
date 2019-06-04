package com.kornelzielinski.sample;

import com.kornelzielinski.core.Game;
import com.kornelzielinski.core.Grid;
import com.kornelzielinski.core.Snake;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int WIDTH = 500;
    private static final int HEIGTH = 500;

    private Game game;
    private Grid grid;
    private GraphicsContext context;

    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        Canvas canvas = new Canvas(WIDTH, HEIGTH);
        context = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(e -> {
            Snake snake = grid.getSnake();
            if (game.isKeyIsPressed()) {
                return;
            }
            game.setKeyIsPressed(true);
            switch (e.getCode()) {
                case UP:
                    snake.setUp();
                    break;
                case DOWN:
                    snake.setDown();
                    break;
                case LEFT:
                    snake.setLeft();
                    break;
                case RIGHT:
                    snake.setRight();
                    break;
                case ENTER:
                    if (game.isPaused()) {
                        reset();
                        (new Thread(game)).start();
                    }
            }
        });

        reset();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);

        stage.setResizable(false);
        stage.setTitle("SnakeFX");
        stage.setOnCloseRequest(e -> System.exit(0));
        stage.setScene(scene);
        stage.show();

        (new Thread(game)).start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void reset() {
        grid = new Grid(WIDTH, HEIGTH);
        game = new Game(grid, context);
        Painter.paint(grid, context);
    }
}