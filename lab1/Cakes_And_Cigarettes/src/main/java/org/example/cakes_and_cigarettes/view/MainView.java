package org.example.cakes_and_cigarettes.view;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.example.cakes_and_cigarettes.model.CakeCalculatorModel;

public class MainView {

    private final Stage primaryStage;
    private final Button btnEnterData;
    private final Label lblTitle;
    private final Label lblCigarettesInfo;
    private final Label lblTarResult;
    private final Label lblNicotineResult;
    private final Label lblMoneyResult;
    private final Label lblCakesResult;
    private final Label lblOrangesResult;
    private final Label lblLastData;

    public MainView(CakeCalculatorModel model) {
        primaryStage = new Stage();
        btnEnterData = new Button("Ввести данные");
        lblTitle = new Label("Калькулятор Тортиков");
        lblCigarettesInfo = new Label("Последние данные: не введены");
        lblTarResult = new Label();
        lblNicotineResult = new Label();
        lblMoneyResult = new Label();
        lblCakesResult = new Label();
        lblOrangesResult = new Label();
        lblLastData = new Label("");
        initialize(model);
    }

    private void initialize(CakeCalculatorModel model) {
        primaryStage.setTitle("Калькулятор Тортиков");

        StackPane backgroundLayer = new StackPane();
        backgroundLayer.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #ffe6ea, #fff0f5);"
        );

        Label bgCake1 = new Label("🍰");
        bgCake1.setFont(Font.font("Arial", 100));
        bgCake1.setStyle("-fx-opacity: 0.12;");
        bgCake1.setTranslateX(-200);
        bgCake1.setTranslateY(-250);

        Label bgCake2 = new Label("🎂");
        bgCake2.setFont(Font.font("Arial", 120));
        bgCake2.setStyle("-fx-opacity: 0.10;");
        bgCake2.setTranslateX(220);
        bgCake2.setTranslateY(200);

        Label bgCake3 = new Label("🧁");
        bgCake3.setFont(Font.font("Arial", 90));
        bgCake3.setStyle("-fx-opacity: 0.08;");
        bgCake3.setTranslateX(-180);
        bgCake3.setTranslateY(280);

        Label bgCake4 = new Label("🍰");
        bgCake4.setFont(Font.font("Arial", 80));
        bgCake4.setStyle("-fx-opacity: 0.10;");
        bgCake4.setTranslateX(200);
        bgCake4.setTranslateY(-200);

        backgroundLayer.getChildren().addAll(bgCake1, bgCake2, bgCake3, bgCake4);

        VBox root = new VBox(15);
        root.setPadding(new Insets(25));
        root.setAlignment(Pos.CENTER);
        root.setMaxWidth(550);

        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        lblTitle.setStyle("-fx-text-fill: #d63384; -fx-effect: dropshadow(gaussian, rgba(214,51,132,0.3), 10, 0, 0, 2);");

        btnEnterData.setFont(Font.font("Arial", FontWeight.BOLD, 17));
        btnEnterData.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #ff6b9d, #d63384); " +
                        "-fx-text-fill: white; " +
                        "-fx-background-radius: 30; " +
                        "-fx-padding: 14 40 14 40; " +
                        "-fx-effect: dropshadow(gaussian, rgba(214,51,132,0.4), 10, 0, 0, 3); " +
                        "-fx-cursor: hand;"
        );
        btnEnterData.setOnMouseEntered(e ->
                btnEnterData.setStyle(
                        "-fx-background-color: linear-gradient(to bottom, #ff85a8, #e84899); " +
                                "-fx-text-fill: white; " +
                                "-fx-background-radius: 30; " +
                                "-fx-padding: 14 40 14 40; " +
                                "-fx-effect: dropshadow(gaussian, rgba(214,51,132,0.5), 15, 0, 0, 5); " +
                                "-fx-cursor: hand;"
                )
        );
        btnEnterData.setOnMouseExited(e ->
                btnEnterData.setStyle(
                        "-fx-background-color: linear-gradient(to bottom, #ff6b9d, #d63384); " +
                                "-fx-text-fill: white; " +
                                "-fx-background-radius: 30; " +
                                "-fx-padding: 14 40 14 40; " +
                                "-fx-effect: dropshadow(gaussian, rgba(214,51,132,0.4), 10, 0, 0, 3); " +
                                "-fx-cursor: hand;"
                )
        );

        lblCigarettesInfo.setFont(Font.font("Arial", 14));
        lblCigarettesInfo.setStyle("-fx-text-fill: #6c757d; -fx-background-color: rgba(255,255,255,0.7); -fx-padding: 12; -fx-background-radius: 12;");

        lblTarResult.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        lblTarResult.setStyle("-fx-text-fill: #495057; -fx-background-color: rgba(255,255,255,0.8); -fx-padding: 14; -fx-background-radius: 14;");

        lblNicotineResult.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        lblNicotineResult.setStyle("-fx-text-fill: #495057; -fx-background-color: rgba(255,255,255,0.8); -fx-padding: 14; -fx-background-radius: 14;");

        lblMoneyResult.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        lblMoneyResult.setStyle("-fx-text-fill: #495057; -fx-background-color: rgba(255,255,255,0.8); -fx-padding: 14; -fx-background-radius: 14;");

        lblCakesResult.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        lblCakesResult.setStyle(
                "-fx-text-fill: #d63384; " +
                        "-fx-background-color: linear-gradient(to right, #fff0f5, #ffe6ea); " +
                        "-fx-padding: 18; " +
                        "-fx-background-radius: 18; " +
                        "-fx-effect: dropshadow(gaussian, rgba(214,51,132,0.3), 8, 0, 0, 2);"
        );

        lblOrangesResult.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        lblOrangesResult.setStyle(
                "-fx-text-fill: #d63384; " +
                        "-fx-background-color: linear-gradient(to right, #fff0f5, #ffe6ea); " +
                        "-fx-padding: 18; " +
                        "-fx-background-radius: 18; " +
                        "-fx-effect: dropshadow(gaussian, rgba(214,51,132,0.3), 8, 0, 0, 2);"
        );

        lblLastData.setFont(Font.font("Arial", 12));
        lblLastData.setStyle("-fx-text-fill: #adb5bd;");

        root.getChildren().addAll(
                lblTitle, btnEnterData, createSeparator(), lblCigarettesInfo,
                createSeparator(), lblTarResult, lblNicotineResult, lblMoneyResult,
                createSeparator(), lblCakesResult, lblOrangesResult,
                createSeparator(), lblLastData
        );

        StackPane mainContainer = new StackPane();
        mainContainer.getChildren().addAll(backgroundLayer, root);
        StackPane.setAlignment(root, Pos.CENTER);

        Scene scene = new Scene(mainContainer, 650, 720);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(650);
        primaryStage.setMinHeight(720);

        bindToModel(model);
    }

    private Region createSeparator() {
        Region separator = new Region();
        separator.setPrefHeight(2);
        separator.setStyle("-fx-background-color: linear-gradient(to right, transparent, #ff6b9d, transparent);");
        return separator;
    }

    public void show() {
        primaryStage.show();
    }

    public Button getBtnEnterData() {
        return btnEnterData;
    }

    public void bindToModel(CakeCalculatorModel model) {
        lblTarResult.textProperty().bind(model.totalTarProperty().asString("Смолы: %.2f г"));
        lblNicotineResult.textProperty().bind(model.totalNicotineProperty().asString("Никотин: %.2f г"));
        lblMoneyResult.textProperty().bind(model.totalMoneySpentProperty().asString("Потрачено: %.2f BYN"));
        lblCakesResult.textProperty().bind(model.cakesCountProperty().asString("Могли купить тортиков: %.0f шт"));
        lblOrangesResult.textProperty().bind(model.orangesCountProperty().asString("Могли купить апельсинов: %.0f шт"));

        lblCigarettesInfo.textProperty().bind(
                Bindings.format("Последние данные: %d сигарет/день, стаж %d лет",
                        model.cigarettesPerDayProperty(),
                        model.yearsSmokingProperty())
        );
    }

    public void updateLastDataInfo(String info) {
        lblLastData.setText(info);
    }
}