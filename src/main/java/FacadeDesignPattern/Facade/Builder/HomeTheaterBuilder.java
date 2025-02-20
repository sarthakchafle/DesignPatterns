package FacadeDesignPattern.Facade.Builder;

import FacadeDesignPattern.Facade.HomeTheaterFacade;
import FacadeDesignPattern.Interfaces.*;

public class HomeTheaterBuilder {
    private MediaPlayer mediaPlayer;
    private AudioSystem audioSystem;
    private Display display;
    private EnvironmentControl lights;
    private ScreenControl screen;

    public HomeTheaterBuilder setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        return this;
    }

    public HomeTheaterBuilder setAudioSystem(AudioSystem audioSystem) {
        this.audioSystem = audioSystem;
        return this;
    }

    public HomeTheaterBuilder setDisplay(Display display) {
        this.display = display;
        return this;
    }

    public HomeTheaterBuilder setLights(EnvironmentControl lights) {
        this.lights = lights;
        return this;
    }

    public HomeTheaterBuilder setScreen(ScreenControl screen) {
        this.screen = screen;
        return this;
    }

    public HomeTheaterFacade build() {
        return new HomeTheaterFacade(mediaPlayer, audioSystem, display, lights, screen);
    }
}
