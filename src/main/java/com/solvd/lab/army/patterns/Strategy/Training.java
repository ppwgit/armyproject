package com.solvd.lab.army.patterns.Strategy;

public class Training {
    private ITrainingStrategy trainingStrategy;

    public void setTrainingStrategy(ITrainingStrategy trainingStrategy) {
        this.trainingStrategy = trainingStrategy;
    }

    public void train() {
        trainingStrategy.train();
    }
}
