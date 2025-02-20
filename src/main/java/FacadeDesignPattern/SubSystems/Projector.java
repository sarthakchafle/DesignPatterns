package FacadeDesignPattern.SubSystems;

import FacadeDesignPattern.Interfaces.Display;

public class Projector implements Display {

    @Override
    public void on() {
        System.out.println("Projector is ON");
    }

    @Override
    public void setMode(String mode) {
        System.out.println("Projector mode: " + mode);
    }

    @Override
    public void off() {
        System.out.println("Projector is OFF");
    }

}
