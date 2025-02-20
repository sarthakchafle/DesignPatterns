package FacadeDesignPattern.Factory;

import FacadeDesignPattern.Interfaces.*;
import FacadeDesignPattern.SubSystems.*;

public class HomeTheaterFactory {
    public static MediaPlayer createMediaPlayer() {
        return new DvdPlayer();
    }

    public static AudioSystem createAudioSystem() {
        return new Amplifier();
    }

    public static Display createDisplay() {
        return new Projector();
    }

    public static EnvironmentControl createLights() {
        return new Lights();
    }

    public static ScreenControl createScreen() {
        return new Screen();
    }
}
