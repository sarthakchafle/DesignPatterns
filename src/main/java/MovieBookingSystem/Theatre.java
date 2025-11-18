package MovieBookingSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Theatre {
    private final int id;
    private final String name;
    private List<Screen> screens;

    public Theatre(int id, String name) {
        this.id = id;
        this.name = name;
        this.screens = new ArrayList<>();
    }

    public void addScreen(Screen screen){
        this.screens.add(screen);
    }
}
