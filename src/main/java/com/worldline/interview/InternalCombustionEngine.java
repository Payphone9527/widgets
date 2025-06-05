package com.worldline.interview;

public class InternalCombustionEngine implements Engine {

    private boolean running;
    private int fuelLevel;
    private FuelType requiredFuelType;
    private FuelType fuelType;

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
            throw new IllegalStateException("Not able to start engine.");
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
        return 8;
    }

    @Override
    public double getCostPerBatch() {
        return switch (requiredFuelType) {
            case PETROL -> 9.00;
            case DIESEL -> 12.00;
            default -> throw new IllegalStateException("Invalid fuel type for internal combustion engine.");
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
