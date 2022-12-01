package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.observer.ISubscriber;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.Painter;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class MindMapView extends JPanel implements ISubscriber {

    private MindMap mindMap;
    private List<Painter> painters = new ArrayList<>();

    public MindMapView(MindMap mindMap)
    {
        this.mindMap = mindMap;
        this.setBackground(Color.white);
        this.addMouseListener(new MouseController());

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Painter p : painters)
        {
            p.draw();
        }

    }

    @Override
    public void update(Object notification) {
        repaint();
    }

    private class MouseController extends MouseAdapter {

        private MindMapView mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent();

        @Override
        public void mousePressed(MouseEvent e) {
            Point position = e.getPoint();
            MainFrame.getInstance().getProjectView().mousePressed(mindMapView, position.x, position.y);
        }

        //todo
        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
        }

        //todo
        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
        }
    }
}
