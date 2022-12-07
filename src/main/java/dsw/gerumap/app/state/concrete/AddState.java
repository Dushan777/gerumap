package dsw.gerumap.app.state.concrete;


import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.ConceptPainter;
import dsw.gerumap.app.mapRepository.painters.Painter;
import dsw.gerumap.app.messageGenerator.MessageGeneratorImplementation;
import dsw.gerumap.app.state.State;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

@Getter
@Setter
public class AddState extends State {


    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y)
    {
        if(MainFrame.getInstance().getActionManager().getColorChooserAction().getFlag()) {
            ((MessageGeneratorImplementation) ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.CANNOT_ADD_CHILD);
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
            return;
        }
        int br = MainFrame.getInstance().getActionManager().getConfirmAction().getDimensionX();
        int br2 = MainFrame.getInstance().getActionManager().getConfirmAction().getDimensionY();

        MindMap mindMap = mindMapView.getMindMap();
        String name = MainFrame.getInstance().getActionManager().getConfirmAction().getText2();
        Color color = MainFrame.getInstance().getActionManager().getConfirmAction().getColor();

        if(br != 0 && br2 != 0 )
        {
            int stroke = Integer.parseInt(MainFrame.getInstance().getActionManager().getColorChooserAction().getTextField().getText()) ;
            Concept concept = new Concept(name, new Point(x, y), br, br2);
            concept.setColor(color);
            concept.setLineStroke(stroke);
            Rectangle2D shape = new Rectangle2D.Float(x,y,br,br2);
            for(Painter p : mindMapView.getPainters())
            {
                if(p instanceof ConceptPainter)
                {
                    // ne radi za razlicite dimenzije
                    Concept c = (Concept) p.getElement();
                    Rectangle2D shape1 = new Rectangle2D.Float(c.getPosition().x, c.getPosition().y, c.getHeight(), c.getWidth());
                    if(shape.intersects(shape1))
                        return;
                }
            }
            mindMapView.getPainters().add(new ConceptPainter(concept));
            concept.setParent(mindMap);
            concept.addSubscribers(mindMapView);
            mindMap.addChild(concept);
        }
        else
        {
            ((MessageGeneratorImplementation) ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.CANNOT_ADD_CHILD);
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
        }
    }
}

