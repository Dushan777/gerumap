package dsw.gerumap.app.core;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApplicationFramework {

    protected Gui gui;
    protected MapRepository mapRepository;
    protected ErrorLogger errorLogger;
    private Serializer serializer;
    protected MessageGenerator messageGenerator;
    public void run(){
        this.gui.start();
    }

    public void initialise(Gui gui, MapRepository mapRepository,MessageGenerator messageGenerator,ErrorLogger errorLogger, Serializer serializer)
    {
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.messageGenerator = messageGenerator;
        this.errorLogger = errorLogger;
        this.serializer = serializer;
    }

    private static ApplicationFramework instance;

    private ApplicationFramework(){

    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }

}
