package com.worldline.interview;

import java.math.BigDecimal;

public class WidgetMachine {
    private final Engine engine;

    public WidgetMachine(Engine engine) {
        this.engine = engine;
    }

    public BigDecimal produceWidgets(int quantity) {
        engine.start();
        BigDecimal cost = BigDecimal.ZERO;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();
        return cost;
    }

    private BigDecimal produce(int quantity) {
        int batchSize = engine.getBatchSize();
        int batchCount = (int) Math.ceil((double) quantity / batchSize);
        BigDecimal costPerBatch = engine.getCostPerBatch();

        return costPerBatch.multiply(BigDecimal.valueOf(batchCount));
    }
}
