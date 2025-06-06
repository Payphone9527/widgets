package com.worldline.interview;

import java.math.BigDecimal;

public class InternalCombustionEngine implements Engine {

    private boolean running;
    private int fuelLevel;
    private final FuelType requiredFuelType;
    private FuelType fuelType;

    public static final int BATCH_SIZE = 8;
    private static final BigDecimal PETROL_COST = new BigDecimal("9.00");
    private static final BigDecimal DIESEL_COST = new BigDecimal("12.00");

    public InternalCombustionEngine(FuelType requiredFuelType) {
        this.requiredFuelType = requiredFuelType;
        running = false;
        fuelLevel = 0;
    }

    @Override
    public void start() {
        if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
            running = true;
        } else {
            throw new IllegalArgumentException("Not able to start engine.");
        }
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void fill(FuelType fuelType, int fuelLevel) {
        if (fuelLevel < 0) {
            this.fuelLevel = 0;
        } else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        } else {
            this.fuelLevel = fuelLevel;
        }

        this.fuelType = fuelType;
    }

    @Override
    public int getBatchSize() {
        return BATCH_SIZE;
    }

    @Override
    public BigDecimal getCostPerBatch() {
        return switch (requiredFuelType) {
            case PETROL -> PETROL_COST;
            case DIESEL -> DIESEL_COST;
            default -> throw new IllegalArgumentException("Invalid fuel type for internal combustion engine.");
        };
    }

    @Override
    public FuelType getFuelType() {
        return requiredFuelType;
    }

    @Override
    public EngineType getEngineType() {
        return EngineType.INTERNAL_COMBUSTION;
    }

}
