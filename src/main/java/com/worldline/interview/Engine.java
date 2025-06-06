package com.worldline.interview;

import java.math.BigDecimal;

public interface Engine {
    void start();
    void stop();
    boolean isRunning();
    void fill(FuelType fuelType, int fuelLevel);
    int getBatchSize();
    BigDecimal getCostPerBatch();
    FuelType getFuelType();
    EngineType getEngineType();
}
