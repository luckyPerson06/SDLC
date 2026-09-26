package org.example.cakes_and_cigarettes.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.example.cakes_and_cigarettes.model.CakeCalculatorModel;
import org.example.cakes_and_cigarettes.view.InputDialogView;
import org.example.cakes_and_cigarettes.view.MainView;

public class CalculatorController {

    private CakeCalculatorModel model;
    private MainView mainView;
    private InputDialogView inputDialog;

    public CalculatorController(CakeCalculatorModel model, MainView mainView) {
        this.model = model;
        this.mainView = mainView;
        this.inputDialog = new InputDialogView(model);
    }

    public void handleEnterData() {
        boolean result = inputDialog.showAndWait();

        if (result) {
            String cigarettesStr = inputDialog.getCigarettesPerDay();
            String pricePackStr = inputDialog.getPricePerPack();
            String tarStr = inputDialog.getTarPerCigarette();
            String nicotineStr = inputDialog.getNicotinePerCigarette();
            String yearsStr = inputDialog.getYearsSmoking();
            String cakePriceStr = inputDialog.getCakePrice();
            String orangePriceStr = inputDialog.getOrangePrice();

            if (validateAndProcess(cigarettesStr, pricePackStr, tarStr, nicotineStr,
                    yearsStr, cakePriceStr, orangePriceStr)) {
                model.calculate();
                updateLastDataInfo();
            }
        }
    }

    private boolean validateAndProcess(String cigarettesStr, String pricePackStr,
                                       String tarStr, String nicotineStr, String yearsStr,
                                       String cakePriceStr, String orangePriceStr) {
        try {
            if (cigarettesStr.isEmpty() || pricePackStr.isEmpty() || tarStr.isEmpty() ||
                    nicotineStr.isEmpty() || yearsStr.isEmpty() || cakePriceStr.isEmpty() ||
                    orangePriceStr.isEmpty()) {
                showError("Все поля должны быть заполнены!");
                return false;
            }

            int cigarettes = Integer.parseInt(cigarettesStr);
            double pricePack = Double.parseDouble(pricePackStr);
            double tar = Double.parseDouble(tarStr);
            double nicotine = Double.parseDouble(nicotineStr);
            int years = Integer.parseInt(yearsStr);
            double cakePrice = Double.parseDouble(cakePriceStr);
            double orangePrice = Double.parseDouble(orangePriceStr);

            if (cigarettes <= 0 || pricePack <= 0 || tar <= 0 || nicotine <= 0 ||
                    years <= 0 || cakePrice <= 0 || orangePrice <= 0) {
                showError("Все значения должны быть положительными числами!");
                return false;
            }

            if (cigarettes > 100) {
                showError("Количество сигарет не может быть больше 100 в день!");
                return false;
            }

            if (years > 100) {
                showError("Стаж курения не может быть больше 100 лет!");
                return false;
            }

            model.setCigarettesPerDay(cigarettes);
            model.setPricePerPack(pricePack);
            model.setTarPerCigarette(tar);
            model.setNicotinePerCigarette(nicotine);
            model.setYearsSmoking(years);
            model.setCakePrice(cakePrice);
            model.setOrangePrice(orangePrice);

            return true;

        } catch (NumberFormatException e) {
            showError("Некорректный формат данных! Введите числа.");
            return false;
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Ошибка ввода");
        alert.setHeaderText("Некорректные данные");
        alert.setContentText(message);
        alert.initOwner(mainView.getBtnEnterData().getScene().getWindow());
        alert.getDialogPane().setStyle("-fx-background-color: linear-gradient(to bottom, #fff0f5, #ffe6ea);");
        alert.showAndWait();
    }

    private void updateLastDataInfo() {
        String info = String.format(
                "Сигарет: %d/день | Цена пачки: %.2f BYN | Смолы: %.1f мг | Никотин: %.1f мг | Стаж: %d лет",
                model.getCigarettesPerDay(),
                model.getPricePerPack(),
                model.getTarPerCigarette(),
                model.getNicotinePerCigarette(),
                model.getYearsSmoking()
        );
        mainView.updateLastDataInfo(info);
    }
}