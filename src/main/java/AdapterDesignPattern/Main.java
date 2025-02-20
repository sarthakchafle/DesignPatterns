package AdapterDesignPattern;

public class Main {
    public static void main(String[] args) {
        OldUsbACharger oldCharger = new OldUsbACharger();

        // Using an adapter to convert USB-A to Type-C
        TypeCCharger adapter = new ChargerAdapter(oldCharger);

        // Charging the laptop with Type-C using the adapter
        adapter.chargeWithTypeC();
    }
}
