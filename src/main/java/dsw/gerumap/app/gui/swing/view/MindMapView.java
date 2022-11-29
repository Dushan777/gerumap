package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.Painter;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class MindMapView extends JPanel {

    private MindMap mindMap;
    private List<Painter> painters = new ArrayList<>();

    public MindMapView(MindMap mindMap)
    {
        this.mindMap = mindMap;
        this.setBackground(Color.white);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Painter p : painters)
        {
            p.draw();
        }

    }
}
