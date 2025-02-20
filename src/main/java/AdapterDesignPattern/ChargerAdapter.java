package AdapterDesignPattern;

public class ChargerAdapter implements TypeCCharger{
    private final OldUsbACharger usbACharger;
    public ChargerAdapter(OldUsbACharger usbACharger) {
        this.usbACharger = usbACharger;
    }

    @Override
    public void chargeWithTypeC() {
        System.out.println("Adapter converting USB-A to Type-C...");
        usbACharger.chargeWithUsbA(); // Using old USB-A charger
    }
}