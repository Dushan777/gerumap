package dsw.gerumap.app.mapRepository.command.implementation;

import dsw.gerumap.app.mapRepository.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveCommand extends AbstractCommand {

    private MindMap mindMap;
    private List<Element> elements = new ArrayList<>();
    private int movedX, movedY;

    public MoveCommand(MindMap mindMap, List<Element> elements, int movedX, int movedY) {
        this.mindMap = mindMap;
        this.elements.addAll(elements);
        this.movedX = movedX;
        this.movedY = movedY;
    }

    @Override
    public void doCommand() {
        for(Element e : elements)
        {
            Concept concept = (Concept) e;
            concept.setPosition(new Point(concept.getOriginalX() + movedX, concept.getOriginalY() + movedY));
            concept.setOriginalX(concept.getOriginalX() + movedX);
            concept.setOriginalY(concept.getOriginalY() + movedY);
        }
    }

    @Override
    public void undoCommand() {

        for(Element e : elements)
        {
            Concept concept = (Concept) e;
            concept.setPosition(new Point(concept.getOriginalX() - movedX, concept.getOriginalY() - movedY));
            concept.setOriginalX(concept.getOriginalX() - movedX);
            concept.setOriginalY(concept.getOriginalY() - movedY);

        }
    }
}