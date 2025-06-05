package com.worldline.interview;

public class WidgetMachine {
    private final Engine engine;

    public WidgetMachine(Engine engine) {
        this.engine = engine;
    }

    public double produceWidgets(int quantity) {
        engine.start();

        double cost = 0.0;
        if (engine.isRunning()) {
            int batchSize = engine.getBatchSize();
            int batchCount = (int) Math.ceil((double) quantity / batchSize);
            cost = batchCount * engine.getCostPerBatch();
        }

        engine.stop();
        return cost;
    }
}
