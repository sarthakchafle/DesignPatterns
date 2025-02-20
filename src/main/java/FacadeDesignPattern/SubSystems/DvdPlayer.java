package FacadeDesignPattern.SubSystems;

import FacadeDesignPattern.Interfaces.MediaPlayer;

public class DvdPlayer implements MediaPlayer {
    @Override
    public void on() {
        System.out.println("DVD Player is ON");
    }

    @Override
    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    @Override
    public void off() {
        System.out.println("DVD Player is OFF");
    }
}
