package src.test.java.com.worldline.interview;

import com.worldline.interview.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WidgetMachineTest {

    private Engine internalCombustionPetrol;
    private Engine internalCombustionDiesel;
    private Engine steamWood;
    private Engine steamCoal;

    @Before
    public void setup() {
        internalCombustionPetrol = new InternalCombustionEngine(FuelType.PETROL);
        internalCombustionPetrol.fill(FuelType.PETROL, 50);

        internalCombustionDiesel = new InternalCombustionEngine(FuelType.DIESEL);
        internalCombustionDiesel.fill(FuelType.DIESEL, 50);

        steamWood = new SteamEngine(FuelType.WOOD);
        steamWood.fill(FuelType.WOOD, 20);

        steamCoal = new SteamEngine(FuelType.COAL);
        steamCoal.fill(FuelType.COAL, 20);
    }

    @Test
    public void testProduceWidgetsInternalCombustionPetrol() {
        WidgetMachine wm = new WidgetMachine(internalCombustionPetrol);

        double cost = wm.produceWidgets(20);
        assertEquals(27.0, cost, 0.001);
    }

    @Test
    public void testProduceWidgetsInternalCombustionDiesel() {
        WidgetMachine wm = new WidgetMachine(internalCombustionDiesel);

        double cost = wm.produceWidgets(16);
        assertEquals(24.0, cost, 0.001);
    }

    @Test
    public void testProduceWidgetsSteamWood() {
        WidgetMachine wm = new WidgetMachine(steamWood);

        double cost = wm.produceWidgets(7);
        assertEquals(17.4, cost, 0.001);
    }

    @Test
    public void testProduceWidgetsSteamCoal() {
        WidgetMachine wm = new WidgetMachine(steamCoal);

        double cost = wm.produceWidgets(5);
        assertEquals(16.95, cost, 0.001);
    }

    @Test(expected = IllegalStateException.class)
    public void testEngineStartFails() {
        Engine engine = new InternalCombustionEngine(FuelType.PETROL);

        WidgetMachine wm = new WidgetMachine(engine);
        wm.produceWidgets(10);
    }
}