package FacadeDesignPattern.SubSystems;

import FacadeDesignPattern.Interfaces.AudioSystem;

public class Amplifier implements AudioSystem {
    @Override
    public void on() {
        System.out.println("Amplifier is ON");
    }

    @Override
    public void setVolume(int level) {
        System.out.println("Volume set to " + level);
    }

    @Override
    public void off() {
        System.out.println("Amplifier is OFF");
    }
}
