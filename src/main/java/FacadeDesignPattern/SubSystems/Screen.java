package FacadeDesignPattern.SubSystems;

import FacadeDesignPattern.Interfaces.ScreenControl;

public class Screen implements ScreenControl {
    @Override
    public void down() {
        System.out.println("Screen is DOWN");
    }

    @Override
    public void up() {
        System.out.println("Screen is UP");
    }
}
