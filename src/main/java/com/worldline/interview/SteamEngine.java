package com.worldline.interview;

import java.math.BigDecimal;

public class SteamEngine implements Engine {

    private boolean running;
    private int fuelLevel;
    private final FuelType requiredFuelType;
    private FuelType fuelType;

    public static final int BATCH_SIZE = 2;
    private static final BigDecimal WOOD_COST = new BigDecimal("4.35");
    private static final BigDecimal COAL_COST = new BigDecimal("5.65");

    public SteamEngine(FuelType requiredFuelType) {
        if (requiredFuelType != FuelType.WOOD && requiredFuelType != FuelType.COAL) {
            throw new IllegalArgumentException("SteamEngine only supports WOOD or COAL.");
        }
        this.requiredFuelType = requiredFuelType;
        running = false;
        fuelLevel = 0;
    }

    @Override
    public void start() {
        if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
            running = true;
        } else {
            throw new IllegalArgumentException("Not able to start steam engine.");
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
        if (fuelType != FuelType.WOOD && fuelType != FuelType.COAL) {
            throw new IllegalArgumentException("SteamEngine only accepts WOOD or COAL.");
        }

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
            case WOOD -> WOOD_COST;
            case COAL -> COAL_COST;
            default -> throw new IllegalArgumentException("Invalid fuel type for steam engine.");
        };
    }

    @Override
    public FuelType getFuelType() {
        return requiredFuelType;
    }

    @Override
    public EngineType getEngineType() {
        return EngineType.STEAM;
    }

}
