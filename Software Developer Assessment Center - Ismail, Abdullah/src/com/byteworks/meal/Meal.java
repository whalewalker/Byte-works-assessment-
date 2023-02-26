package com.byteworks.meal;

public class Meal {
    private String name;
    private double proteinContentInMiligram;
    private double carbonHydrateContentInMiligram;
    private double fatContentInMiligram;

    public Meal(String name) {
        this.name = name;
    }

    public Meal(String name, double proteinContentInMiligram, double carbonHydrateContentInMiligram, double fatContentInMiligram) {
        this.name = name;
        this.proteinContentInMiligram = proteinContentInMiligram;
        this.carbonHydrateContentInMiligram = carbonHydrateContentInMiligram;
        this.fatContentInMiligram = fatContentInMiligram;
    }


    public String getName() {
        return name;
    }

    public double getProteinContentInMiligram() {
        return proteinContentInMiligram;
    }

    public double getCarbonHydrateContentInMiligram() {
        return carbonHydrateContentInMiligram;
    }

    public double getFatContentInMiligram() {
        return fatContentInMiligram;
    }

    @Override
    public String toString() {
        return name;
    }
}