package dsw.gerumap.app.core;

public abstract class ApplicationFramework {

    protected Gui gui;
    protected MapRepository mapRepository;
    public abstract void run();

    public void initialise(Gui gui, MapRepository mapRepository)
    {
        this.gui = gui;
        this.mapRepository = mapRepository;
    }


}
