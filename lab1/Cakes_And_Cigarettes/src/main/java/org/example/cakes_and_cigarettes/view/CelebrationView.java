package org.example.cakes_and_cigarettes.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class CelebrationView {

    private Stage stage;

    public CelebrationView(String videoPath) {
        stage = new Stage();
        stage.setTitle("Поздравляем! 1000 тортиков!");
        initialize(videoPath);
    }

    private void initialize(String videoPath) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new javafx.geometry.Insets(30));
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #ffe6ea, #fff0f5);");

        Label titleLabel = new Label("Вы достигли 1000 тортиков!");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        titleLabel.setStyle("-fx-text-fill: #d63384;");

        Label infoLabel = new Label("Открываем праздничное видео...");
        infoLabel.setFont(Font.font("Arial", 14));
        infoLabel.setStyle("-fx-text-fill: #6c757d;");

        Button btnOpenVideo = new Button("Открыть видео");
        btnOpenVideo.setFont(Font.font("Arial", 14));
        btnOpenVideo.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #28a745, #218838); " +
                        "-fx-text-fill: white; " +
                        "-fx-background-radius: 20; " +
                        "-fx-padding: 12 30 12 30; " +
                        "-fx-cursor: hand;"
        );
        btnOpenVideo.setOnAction(e -> openVideo(videoPath));

        Button btnClose = new Button("Закрыть");
        btnClose.setFont(Font.font("Arial", 14));
        btnClose.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #ff6b9d, #d63384); " +
                        "-fx-text-fill: white; " +
                        "-fx-background-radius: 20; " +
                        "-fx-padding: 12 30 12 30; " +
                        "-fx-cursor: hand;"
        );
        btnClose.setOnAction(e -> stage.close());

        root.getChildren().addAll(titleLabel, infoLabel, btnOpenVideo, btnClose);

        Scene scene = new Scene(root, 500, 350);
        stage.setScene(scene);
        stage.setResizable(false);

        openVideo(videoPath);
    }

    private void openVideo(String videoPath) {
        try {
            File videoFile = new File(videoPath);
            if (videoFile.exists()) {
                ProcessBuilder pb = new ProcessBuilder("xdg-open", videoPath);
                pb.start();
            } else {
                System.err.println("Видео файл не найден: " + videoPath);
            }
        } catch (Exception e) {
            System.err.println("Ошибка открытия видео: " + e.getMessage());
        }
    }

    public void show() {
        stage.show();
    }
}