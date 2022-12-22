package dsw.gerumap.app.mapRepository.command.implementation;

import dsw.gerumap.app.mapRepository.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;

import java.util.ArrayList;
import java.util.List;

public class RemoveCommand extends AbstractCommand {
    private MindMap mindMap;
    private List<Element> mindMapElements = new ArrayList<>();


    public RemoveCommand(MindMap mindMap, List<Element> mindMapElements) {
        this.mindMap = mindMap;
        this.mindMapElements.addAll(mindMapElements);

    }

    @Override
    public void doCommand() {
        if(mindMapElements == null || mindMap == null)
            return;

        for (Element element : mindMapElements) {
            mindMap.deleteChild(element);
        }
    }

    @Override
    public void undoCommand() {
        if(mindMapElements == null || mindMap == null)
            return;

        for (Element element : mindMapElements) {
            mindMap.addChild(element);
        }
    }
}
