package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.observer.ISubscriber;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.*;
import dsw.gerumap.app.mapRepository.painters.ConceptPainter;
import dsw.gerumap.app.mapRepository.painters.ConnectionPainter;
import dsw.gerumap.app.mapRepository.painters.Painter;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class MindMapView extends JPanel implements ISubscriber {

    private MindMap mindMap;
    private List<Painter> painters = new ArrayList<>();
    private MapSelectionModel mapSelectionModel = new MapSelectionModel();

    private AffineTransform affineTransform = new AffineTransform();

    private double timesZoomed = 1;


    public MindMapView(MindMap mindMap)
    {
        this.mindMap = mindMap;
        this.setBackground(Color.white);
        MouseController mouseController = new MouseController();
        this.addMouseListener(mouseController);
        this.addMouseMotionListener(mouseController);
        mapSelectionModel.addSubscribers(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.scale(timesZoomed, timesZoomed);
        graphics2D.transform(affineTransform);
        for(Painter p : painters)
        {
            p.draw(graphics2D, p.getElement());

        }

    }

    @Override
    public void update(Object notification) {
        if (notification instanceof MindMap) {
            MindMap mindMap = (MindMap) notification;
            if (mindMap.getChildren().size() > this.getPainters().size()) {
                addElement(mindMap);
            }
            else if (mindMap.getChildren().size() < this.getPainters().size()) {
                removeElement(mindMap);
            }
        }
        repaint();
    }

    public void addElement(MindMap mindMap) {

        Element element = (Element) mindMap.getChildren().get(mindMap.getChildren().size() - 1);

        if (element instanceof Concept)
            this.getPainters().add(new ConceptPainter(element));
        else
            this.getPainters().add(new ConnectionPainter(element));
    }
    public void removeElement(MindMap mindMap)
    {
        for (int j = 0; j < this.getPainters().size(); j++) {
            boolean flag = false;
            for (MapNode mapNode : mindMap.getChildren())
            {
                Element element = (Element) mapNode;

                    if (this.getPainters().get(j).getElement().equals2(element)) {
                        flag = true;
                        break;
                    }
            }
            if (!flag) {
                this.getPainters().remove(j);
                this.getMapSelectionModel().getSelectedElements().clear();

            }
        }
    }


    private class MouseController extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            MindMapView mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent();
            Point position = e.getPoint();
            MainFrame.getInstance().getProjectView().misKliknut(mindMapView, position.x, position.y);
        }


        @Override
        public void mouseReleased(MouseEvent e) {
            MindMapView mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent();
            Point position = e.getPoint();
            MainFrame.getInstance().getProjectView().misPusten(mindMapView, position.x, position.y);
        }


        @Override
        public void mouseDragged(MouseEvent e) {
            MindMapView mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent();
            Point position = e.getPoint();
            MainFrame.getInstance().getProjectView().misPrevucen(mindMapView, position.x, position.y);

        }
    }
}
