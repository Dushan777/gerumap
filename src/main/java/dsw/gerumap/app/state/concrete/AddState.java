package dsw.gerumap.app.state.concrete;


import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.ConceptPainter;
import dsw.gerumap.app.messageGenerator.MessageGeneratorImplementation;
import dsw.gerumap.app.state.State;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class AddState extends State {


    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y)
    {
        int br = MainFrame.getInstance().getActionManager().getConfirmAction().getDimensionX();
        int br2 = MainFrame.getInstance().getActionManager().getConfirmAction().getDimensionY();
        MindMap mindMap = mindMapView.getMindMap();
      //  int num = mindMap.getNumberOfChildren()+1;
        String name = MainFrame.getInstance().getActionManager().getConfirmAction().getText2();
        Color color = MainFrame.getInstance().getActionManager().getConfirmAction().getColor();
        if(br != 0 && br2 != 0)
        {
            Concept concept = new Concept(name, new Point(x, y), br, br2);
            concept.setColor(color);
            mindMapView.getPainters().add(new ConceptPainter(concept));
            mindMap.addChild(concept);
        }
        else
        {
            ((MessageGeneratorImplementation) ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.CANNOT_ADD_CHILD);
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
        }
    }
}

