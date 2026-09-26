package org.example.cakes_and_cigarettes.view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.cakes_and_cigarettes.model.CakeCalculatorModel;

public class InputDialogView {

    private TextField txtCigarettesPerDay;
    private TextField txtPricePerPack;
    private TextField txtTarPerCigarette;
    private TextField txtNicotinePerCigarette;
    private TextField txtYearsSmoking;
    private TextField txtCakePrice;
    private TextField txtOrangePrice;
    private boolean okPressed = false;

    private CakeCalculatorModel model;
    private Stage currentStage;

    public InputDialogView(CakeCalculatorModel model) {
        this.model = model;
    }

    public boolean showAndWait() {
        if (currentStage != null && currentStage.isShowing()) {
            currentStage.close();
            currentStage = null;
        }

        txtCigarettesPerDay = new TextField();
        txtPricePerPack = new TextField();
        txtTarPerCigarette = new TextField();
        txtNicotinePerCigarette = new TextField();
        txtYearsSmoking = new TextField();
        txtCakePrice = new TextField();
        txtOrangePrice = new TextField();

        okPressed = false;

        currentStage = new Stage();
        currentStage.initModality(Modality.APPLICATION_MODAL);
        currentStage.initStyle(StageStyle.DECORATED);
        currentStage.setTitle("Ввод данных курильщика");

        StackPane backgroundLayer = new StackPane();
        backgroundLayer.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #2c2c2c, #1a1a1a);"
        );

        Label bgDecor1 = new Label("\uD83D\uDEAC");
        bgDecor1.setFont(Font.font("Arial", 80));
        bgDecor1.setStyle("-fx-opacity: 0.1; -fx-text-fill: white;");
        bgDecor1.setTranslateX(-150);
        bgDecor1.setTranslateY(-200);

        Label bgDecor2 = new Label("\uD83D\uDEAC");
        bgDecor2.setFont(Font.font("Arial", 100));
        bgDecor2.setStyle("-fx-opacity: 0.08; -fx-text-fill: white;");
        bgDecor2.setTranslateX(180);
        bgDecor2.setTranslateY(150);

        Label bgDecor3 = new Label("\uD83D\uDCA8");
        bgDecor3.setFont(Font.font("Arial", 120));
        bgDecor3.setStyle("-fx-opacity: 0.06; -fx-text-fill: white;");
        bgDecor3.setTranslateX(-100);
        bgDecor3.setTranslateY(250);

        backgroundLayer.getChildren().addAll(bgDecor1, bgDecor2, bgDecor3);

        VBox root = new VBox(15);
        root.setPadding(new Insets(30, 30, 40, 30));
        root.setAlignment(Pos.CENTER_LEFT);
        root.setMaxWidth(500);

        VBox headerBox = new VBox(8);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setMaxWidth(Double.MAX_VALUE);

        Label titleLabel = new Label("Данные курильщика");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        titleLabel.setStyle("-fx-text-fill: #ff6b6b; -fx-effect: dropshadow(gaussian, rgba(255,107,107,0.5), 10, 0, 0, 2);");

        Label subtitleLabel = new Label("Введите информацию для расчёта");
        subtitleLabel.setFont(Font.font("Arial", 13));
        subtitleLabel.setStyle("-fx-text-fill: #888888;");

        headerBox.getChildren().addAll(titleLabel, subtitleLabel);

        setupTextField(txtCigarettesPerDay, "Например: 10");
        setupTextField(txtPricePerPack, "Например: 5.50");
        setupTextField(txtTarPerCigarette, "Например: 7");
        setupTextField(txtNicotinePerCigarette, "Например: 0.6");
        setupTextField(txtYearsSmoking, "Например: 5");
        setupTextField(txtCakePrice, "Например: 25");
        setupTextField(txtOrangePrice, "Например: 3");

        txtCigarettesPerDay.setText(model.getCigarettesPerDay() > 0 ? String.valueOf(model.getCigarettesPerDay()) : "");
        txtPricePerPack.setText(model.getPricePerPack() > 0 ? String.valueOf(model.getPricePerPack()) : "");
        txtTarPerCigarette.setText(model.getTarPerCigarette() > 0 ? String.valueOf(model.getTarPerCigarette()) : "");
        txtNicotinePerCigarette.setText(model.getNicotinePerCigarette() > 0 ? String.valueOf(model.getNicotinePerCigarette()) : "");
        txtYearsSmoking.setText(model.getYearsSmoking() > 0 ? String.valueOf(model.getYearsSmoking()) : "");
        txtCakePrice.setText(model.getCakePrice() > 0 ? String.valueOf(model.getCakePrice()) : "");
        txtOrangePrice.setText(model.getOrangePrice() > 0 ? String.valueOf(model.getOrangePrice()) : "");

        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(25, 0, 0, 0));

        Button btnOK = new Button("Рассчитать");
        btnOK.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        btnOK.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #ff6b6b, #c92a2a); " +
                        "-fx-text-fill: white; " +
                        "-fx-background-radius: 25; " +
                        "-fx-padding: 12 35 12 35; " +
                        "-fx-effect: dropshadow(gaussian, rgba(255,107,107,0.5), 10, 0, 0, 3); " +
                        "-fx-cursor: hand;"
        );

        Button btnCancel = new Button("Отмена");
        btnCancel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        btnCancel.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #495057, #343a40); " +
                        "-fx-text-fill: white; " +
                        "-fx-background-radius: 25; " +
                        "-fx-padding: 12 35 12 35; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 2); " +
                        "-fx-cursor: hand;"
        );

        btnOK.setOnAction(e -> {
            okPressed = true;
            closeStage();
        });
        btnCancel.setOnAction(e -> {
            okPressed = false;
            closeStage();
        });

        buttonBox.getChildren().addAll(btnOK, btnCancel);

        Region separator1 = createSeparator();
        Region separator2 = createSeparator();

        root.getChildren().addAll(
                headerBox, separator1,
                createFieldBox("Сигарет в день:", txtCigarettesPerDay),
                createFieldBox("Цена пачки (BYN):", txtPricePerPack),
                createFieldBox("Смолы в сигарете (мг):", txtTarPerCigarette),
                createFieldBox("Никотин в сигарете (мг):", txtNicotinePerCigarette),
                createFieldBox("Стаж курения (лет):", txtYearsSmoking),
                createFieldBox("Цена тортика (BYN):", txtCakePrice),
                createFieldBox("Цена апельсина (BYN):", txtOrangePrice),
                separator2, buttonBox
        );

        StackPane mainContainer = new StackPane();
        mainContainer.getChildren().addAll(backgroundLayer, root);
        StackPane.setAlignment(root, Pos.CENTER);

        Scene scene = new Scene(mainContainer, 550, 750);
        currentStage.setScene(scene);
        currentStage.setResizable(false);

        currentStage.setOnCloseRequest(e -> {
            okPressed = false;
            closeStage();
        });

        currentStage.showAndWait();
        return okPressed;
    }

    private void closeStage() {
        if (currentStage != null) {
            Stage stageToClose = currentStage;
            currentStage = null;
            stageToClose.close();
        }
    }

    private void setupTextField(TextField textField, String placeholder) {
        textField.setPromptText(placeholder);
        textField.setFont(Font.font("Arial", 14));
        textField.setMaxWidth(400);
        textField.setStyle(
                "-fx-background-color: #3a3a3a; " +
                        "-fx-text-fill: white; " +
                        "-fx-prompt-text-fill: #777777; " +
                        "-fx-border-color: #ff6b6b; " +
                        "-fx-border-radius: 10; " +
                        "-fx-background-radius: 10; " +
                        "-fx-padding: 10 15 10 15; " +
                        "-fx-effect: dropshadow(gaussian, rgba(255,107,107,0.2), 5, 0, 0, 1);"
        );
        textField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (isNowFocused) {
                textField.setStyle(
                        "-fx-background-color: #4a4a4a; " +
                                "-fx-text-fill: white; " +
                                "-fx-prompt-text-fill: #777777; " +
                                "-fx-border-color: #ff8787; " +
                                "-fx-border-radius: 10; " +
                                "-fx-background-radius: 10; " +
                                "-fx-padding: 10 15 10 15; " +
                                "-fx-effect: dropshadow(gaussian, rgba(255,107,107,0.4), 10, 0, 0, 2);"
                );
            } else {
                textField.setStyle(
                        "-fx-background-color: #3a3a3a; " +
                                "-fx-text-fill: white; " +
                                "-fx-prompt-text-fill: #777777; " +
                                "-fx-border-color: #ff6b6b; " +
                                "-fx-border-radius: 10; " +
                                "-fx-background-radius: 10; " +
                                "-fx-padding: 10 15 10 15; " +
                                "-fx-effect: dropshadow(gaussian, rgba(255,107,107,0.2), 5, 0, 0, 1);"
                );
            }
        });
    }

    private VBox createFieldBox(String labelText, TextField textField) {
        VBox box = new VBox(6);
        box.setAlignment(Pos.CENTER_LEFT);
        Label label = new Label(labelText);
        label.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        label.setStyle("-fx-text-fill: #cccccc;");
        box.getChildren().addAll(label, textField);
        return box;
    }

    private Region createSeparator() {
        Region separator = new Region();
        separator.setPrefHeight(1);
        separator.setMaxWidth(500);
        separator.setStyle("-fx-background-color: linear-gradient(to right, transparent, #ff6b6b, transparent);");
        return separator;
    }

    public String getCigarettesPerDay() { return txtCigarettesPerDay.getText(); }
    public String getPricePerPack() { return txtPricePerPack.getText(); }
    public String getTarPerCigarette() { return txtTarPerCigarette.getText(); }
    public String getNicotinePerCigarette() { return txtNicotinePerCigarette.getText(); }
    public String getYearsSmoking() { return txtYearsSmoking.getText(); }
    public String getCakePrice() { return txtCakePrice.getText(); }
    public String getOrangePrice() { return txtOrangePrice.getText(); }
}