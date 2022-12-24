package dsw.gerumap.app.gui.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dsw.gerumap.app.core.Serializer;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonSerializer implements Serializer {

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(MapNode.class, new MapNodeSerialization()).create();


    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, Project.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public MindMap loadMindMap(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, MindMap.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project project) {

        try (FileWriter writer = new FileWriter(project.getFilePath())) {
            gson.toJson(project, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveMindMap(MindMap mindMap) {
        try (FileWriter writer = new FileWriter(mindMap.getFilePath())) {
            gson.toJson(mindMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
