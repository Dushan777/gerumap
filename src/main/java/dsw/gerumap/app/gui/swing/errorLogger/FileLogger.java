package dsw.gerumap.app.gui.swing.errorLogger;

import dsw.gerumap.app.core.ErrorLogger;

public class FileLogger implements ErrorLogger {
    @Override
    public String log() {
        System.out.println("brojeve");
        return null;
    }
}
