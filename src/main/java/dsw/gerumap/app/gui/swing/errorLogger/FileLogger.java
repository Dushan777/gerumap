package dsw.gerumap.app.gui.swing.errorLogger;

import dsw.gerumap.app.core.ErrorLogger;
import dsw.gerumap.app.messageGenerator.Message;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileLogger implements ErrorLogger {

    private File file;
    private Path path;

    public FileLogger()
    {
        URL filePath = this.getClass().getResource("/log.txt");
        if(filePath != null)
        {
            file = new File(filePath.getFile());
            path = file.toPath();
        }
    }

    @Override
    public void log(Message msg) {
        try {
            if (Files.exists(path)) {
                Writer fw = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fw);
                    fw.write(msg.toString() + "\n");
                    bufferedWriter.close();
                }
            else
                Files.createFile(path);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void update(Object notification) {
        log((Message) notification);
    }
}
