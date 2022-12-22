package dsw.gerumap.app.mapRepository.command.implementation;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.mapRepository.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;

import java.util.List;

public class AddConceptCommand extends AbstractCommand {

    private MindMap mindMap;
    private Concept concept;
    private List<Element> selected;

    public AddConceptCommand(MindMap mindMap, Concept concept, List<Element> selected) {
        this.mindMap = mindMap;
        this.concept = concept;
        this.selected = selected;
    }

    @Override
    public void doCommand() {
        if(concept == null || selected == null ||  mindMap == null)
            return;

        int numChildern = mindMap.getChildren().size();


        mindMap.addChild(concept);
        String name = concept.getName();
        while (numChildern == mindMap.getChildren().size()) {
            concept.setName(name + mindMap.getNumberOfChildren());
            mindMap.addChild(concept);
        }


    }

    @Override
    public void undoCommand() {
        if(concept == null || selected == null ||  mindMap == null)
            return;

        selected.remove(concept);
        mindMap.deleteChild(concept);

    }
}
