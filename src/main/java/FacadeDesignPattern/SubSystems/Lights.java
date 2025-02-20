package FacadeDesignPattern.SubSystems;

import FacadeDesignPattern.Interfaces.EnvironmentControl;

public class Lights implements EnvironmentControl {
    @Override
    public void dim(int level) {
        System.out.println("Lights dimmed to " + level + "%");
    }
}
