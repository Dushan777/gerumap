package dsw.gerumap.app;

import dsw.gerumap.app.core.*;
import dsw.gerumap.app.gui.swing.SwingGui;
import dsw.gerumap.app.gui.swing.errorLogger.ErrorFactory;
import dsw.gerumap.app.mapRepository.MapRepositoryImpl;
import dsw.gerumap.app.messageGenerator.MessageGeneratorImplementation;


public class AppCore {


    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        Gui gui = new SwingGui();
        MapRepository repository = new MapRepositoryImpl();
        MessageGenerator messageGenerator = new MessageGeneratorImplementation() ;
        ErrorFactory errorFactory = new ErrorFactory();
        ErrorLogger errorLogger = errorFactory.createLogger("FileLOGGEr");
        appCore.initialise(gui,repository,messageGenerator,errorLogger);
        appCore.run();
    }

}
