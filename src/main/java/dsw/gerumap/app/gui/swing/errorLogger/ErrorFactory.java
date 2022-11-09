package dsw.gerumap.app.gui.swing.errorLogger;

import dsw.gerumap.app.core.ErrorLogger;

public class ErrorFactory {

    public ErrorLogger createLogger(String type)
    {
        if(type.toUpperCase().equals("CONSOLELOGGER"))
            return new ConsoleLogger();
        else if(type.toUpperCase().equals("FILELOGGER"))
            return new FileLogger();

        return null;
    }

}
