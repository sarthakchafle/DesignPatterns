package FacadeDesignPattern.Facade;

import FacadeDesignPattern.Interfaces.*;

public class HomeTheaterFacade {
    private final MediaPlayer mediaPlayer;
    private final AudioSystem audioSystem;
    private final Display display;
    private final EnvironmentControl lights;
    private final ScreenControl screen;

    public HomeTheaterFacade(MediaPlayer mediaPlayer, AudioSystem audioSystem,
                             Display display, EnvironmentControl lights,
                             ScreenControl screen) {
        this.mediaPlayer = mediaPlayer;
        this.audioSystem = audioSystem;
        this.display = display;
        this.lights = lights;
        this.screen = screen;
    }

    public void watchMovie(String movie) {
        System.out.println("\n🎬 Starting Movie Mode...");
        configureHomeTheater(true);
        mediaPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("\n🎬 Ending Movie Mode...");
        configureHomeTheater(false);
    }

    private void configureHomeTheater(boolean start) {
        if (start) {
            lights.dim(30);
            screen.down();
            display.on();
            display.setMode("Cinema");
            audioSystem.on();
            audioSystem.setVolume(10);
            mediaPlayer.on();
        } else {
            mediaPlayer.off();
            audioSystem.off();
            display.off();
            screen.up();
            lights.dim(100);
        }
    }
}
