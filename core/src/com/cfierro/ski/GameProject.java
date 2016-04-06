package com.cfierro.ski;

import com.badlogic.gdx.Game;
import com.cfierro.ski.views.MainMenu;

public class GameProject extends Game {
    public static final String TITLE="Ski Game"; 
    
    @Override
    public void create() {
            setScreen(new MainMenu());
    }
}
