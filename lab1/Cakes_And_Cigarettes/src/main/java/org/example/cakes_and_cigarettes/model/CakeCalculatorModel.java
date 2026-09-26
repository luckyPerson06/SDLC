package org.example.cakes_and_cigarettes.model;

import javafx.beans.property.*;

public class CakeCalculatorModel {

    private IntegerProperty cigarettesPerDay = new SimpleIntegerProperty(0);
    private DoubleProperty pricePerPack = new SimpleDoubleProperty(0);
    private DoubleProperty tarPerCigarette = new SimpleDoubleProperty(0);
    private DoubleProperty nicotinePerCigarette = new SimpleDoubleProperty(0);
    private IntegerProperty yearsSmoking = new SimpleIntegerProperty(0);
    private DoubleProperty cakePrice = new SimpleDoubleProperty(0);
    private DoubleProperty orangePrice = new SimpleDoubleProperty(0);

    private DoubleProperty totalTar = new SimpleDoubleProperty(0);
    private DoubleProperty totalNicotine = new SimpleDoubleProperty(0);
    private DoubleProperty totalMoneySpent = new SimpleDoubleProperty(0);
    private DoubleProperty cakesCount = new SimpleDoubleProperty(0);
    private DoubleProperty orangesCount = new SimpleDoubleProperty(0);

    public void calculate() {
        int totalCigarettes = cigarettesPerDay.get() * 365 * yearsSmoking.get();

        totalTar.set((totalCigarettes * tarPerCigarette.get()) / 1000.0);
        totalNicotine.set((totalCigarettes * nicotinePerCigarette.get()) / 1000.0);
        totalMoneySpent.set((totalCigarettes / 20.0) * pricePerPack.get());

        cakesCount.set(cakePrice.get() > 0 ? totalMoneySpent.get() / cakePrice.get() : 0);
        orangesCount.set(orangePrice.get() > 0 ? totalMoneySpent.get() / orangePrice.get() : 0);
    }

    public IntegerProperty cigarettesPerDayProperty() { return cigarettesPerDay; }
    public IntegerProperty yearsSmokingProperty() { return yearsSmoking; }

    public DoubleProperty totalTarProperty() { return totalTar; }
    public DoubleProperty totalNicotineProperty() { return totalNicotine; }
    public DoubleProperty totalMoneySpentProperty() { return totalMoneySpent; }
    public DoubleProperty cakesCountProperty() { return cakesCount; }
    public DoubleProperty orangesCountProperty() { return orangesCount; }

    public int getCigarettesPerDay() { return cigarettesPerDay.get(); }
    public double getPricePerPack() { return pricePerPack.get(); }
    public double getTarPerCigarette() { return tarPerCigarette.get(); }
    public double getNicotinePerCigarette() { return nicotinePerCigarette.get(); }
    public int getYearsSmoking() { return yearsSmoking.get(); }
    public double getCakePrice() { return cakePrice.get(); }
    public double getOrangePrice() { return orangePrice.get(); }

    public void setCigarettesPerDay(int v) { cigarettesPerDay.set(v); }
    public void setPricePerPack(double v) { pricePerPack.set(v); }
    public void setTarPerCigarette(double v) { tarPerCigarette.set(v); }
    public void setNicotinePerCigarette(double v) { nicotinePerCigarette.set(v); }
    public void setYearsSmoking(int v) { yearsSmoking.set(v); }
    public void setCakePrice(double v) { cakePrice.set(v); }
    public void setOrangePrice(double v) { orangePrice.set(v); }
}