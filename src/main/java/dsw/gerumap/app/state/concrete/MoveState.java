package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.command.implementation.MoveCommand;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.state.State;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class MoveState extends State {

    private int clickedX, clickedY;

    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {
        clickedX = x;
        clickedY = y;
    }

    @Override
    public void misPrevucen(MindMapView mindMapView, int x, int y) {
        if (mindMapView.getMapSelectionModel().getSelectedElements().isEmpty() && mindMapView.getTimesZoomed() > 1) {
            for (MapNode e : mindMapView.getMindMap().getChildren()) {
                if (e instanceof Concept) {
                    Concept c = (Concept) e;
                    c.setPosition(new Point(c.getOriginalX() + x - clickedX, c.getOriginalY() + y - clickedY));
                }
            }
        } else {
            for (Element e : mindMapView.getMapSelectionModel().getSelectedElements()) {
                Concept c = (Concept) e;
                c.setPosition(new Point(c.getOriginalX() + x - clickedX, c.getOriginalY() + y - clickedY));
            }
        }
    }

    @Override
    public void misPusten(MindMapView mindMapView, int x, int y) {
        if (mindMapView.getMapSelectionModel().getSelectedElements().isEmpty() && mindMapView.getTimesZoomed() > 1) {
            for (MapNode e : mindMapView.getMindMap().getChildren()) {
                if (e instanceof Concept) {
                    Concept c = (Concept) e;
                    c.setOriginalX(c.getPosition().x);
                    c.setOriginalY(c.getPosition().y);
                }
            }
        } else {
            // provera da li se nalazi element tu gde je pusteno
            for (Element e : mindMapView.getMapSelectionModel().getSelectedElements()) {
                Concept c = (Concept) e;
                //c.setOriginalX(c.getPosition().x);
                //c.setOriginalY(c.getPosition().y);
            }

            int movedX = x - clickedX;
            int movedY = y - clickedY;
            System.out.println("movedX = " + movedX);
            System.out.println("movedY = " + movedY);
            AbstractCommand abstractCommand = new MoveCommand(mindMapView.getMindMap(), mindMapView.getMapSelectionModel().getSelectedElements(), movedX, movedY);
            mindMapView.getMindMap().getCommandManager().addCommand(abstractCommand);
        }

    }
}
