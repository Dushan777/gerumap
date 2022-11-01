package main.java.dsw.gerumap.app;

import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.core.Gui;
import main.java.dsw.gerumap.app.core.MapRepository;
import main.java.dsw.gerumap.app.gui.swing.SwingGui;
import main.java.dsw.gerumap.app.mapRepository.MapRepositoryImpl;


public class AppCore {


    public static void main(String[] args) {
        Gui gui = new SwingGui();
        MapRepository repository = new MapRepositoryImpl();
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        appCore.initialise(gui,repository);
        appCore.run();
    }

}
