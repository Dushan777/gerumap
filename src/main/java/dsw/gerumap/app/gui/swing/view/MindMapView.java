package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.MindMap;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class MindMapView extends JPanel {

    private MindMap mindMap;

    public MindMapView(MindMap mindMap)
    {
        this.mindMap = mindMap;
    }




}
