package FacadeDesignPattern;

import FacadeDesignPattern.Facade.Builder.HomeTheaterBuilder;
import FacadeDesignPattern.Facade.HomeTheaterFacade;
import FacadeDesignPattern.Factory.HomeTheaterFactory;
import FacadeDesignPattern.Interfaces.*;

public class Main {
    public static void main(String[] args) {
        // Use Factory to create subsystem components
        MediaPlayer dvdPlayer = HomeTheaterFactory.createMediaPlayer();
        AudioSystem amplifier = HomeTheaterFactory.createAudioSystem();
        Display projector = HomeTheaterFactory.createDisplay();
        EnvironmentControl lights = HomeTheaterFactory.createLights();
        ScreenControl screen = HomeTheaterFactory.createScreen();

        // ✅ Use Separate Builder to create the HomeTheaterFacade
        HomeTheaterFacade homeTheater = new HomeTheaterBuilder()
                .setMediaPlayer(dvdPlayer)
                .setAudioSystem(amplifier)
                .setDisplay(projector)
                .setLights(lights)
                .setScreen(screen)
                .build();

        // ✅ Use Facade to control the system
        homeTheater.watchMovie("Interstellar");
        homeTheater.endMovie();
    }
}
