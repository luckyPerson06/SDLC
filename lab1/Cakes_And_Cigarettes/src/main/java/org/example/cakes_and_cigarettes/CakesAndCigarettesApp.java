package org.example.cakes_and_cigarettes;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.cakes_and_cigarettes.controller.CalculatorController;
import org.example.cakes_and_cigarettes.model.CakeCalculatorModel;
import org.example.cakes_and_cigarettes.view.CelebrationView;
import org.example.cakes_and_cigarettes.view.MainView;

public class CakesAndCigarettesApp extends Application {

    private boolean videoShown = false;
    private static final String VIDEO_PATH = "/home/luckyperson/5 sem/IMG_1591.MOV";

    @Override
    public void start(Stage primaryStage) {
        CakeCalculatorModel model = new CakeCalculatorModel();
        MainView view = new MainView(model);
        CalculatorController controller = new CalculatorController(model, view);

        view.bindToModel(model);
        view.getBtnEnterData().setOnAction(e -> controller.handleEnterData());

        model.cakesCountProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.doubleValue() >= 1000 && !videoShown) {
                CelebrationView celebration = new CelebrationView(VIDEO_PATH);
                celebration.show();
                videoShown = true;
            }
        });

        view.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}