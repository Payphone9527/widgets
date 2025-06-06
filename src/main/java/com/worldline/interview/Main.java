package com.worldline.interview;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Engine internalCombustion = new InternalCombustionEngine(FuelType.PETROL);
        internalCombustion.fill(FuelType.PETROL, 50);

        WidgetMachine wmIce = new WidgetMachine(internalCombustion);
        BigDecimal costIce = wmIce.produceWidgets(20);
        System.out.println("Internal Combustion Engine cost: £" + costIce);

        Engine steam = new SteamEngine(FuelType.WOOD);
        steam.fill(FuelType.WOOD, 30);

        WidgetMachine wmSteam = new WidgetMachine(steam);
        BigDecimal costSteam = wmSteam.produceWidgets(7);
        System.out.println("Steam Engine cost: £" + costSteam);
    }
}
