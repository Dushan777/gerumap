package dsw.gerumap.app.mapRepository.composite;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class MapNodeComposite extends MapNode{
    List<MapNode> children = new ArrayList<>();
    private int numberOfChildren = 1;

    public MapNodeComposite(String name, MapNode parent) {
        super(name, parent);
    }
    public MapNodeComposite() {}

    public abstract void addChild(MapNode child);

    public MapNode getChildByName(String name) {
        for (MapNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }

    public void deleteChild(MapNode child)
    {
        children.remove(child);

    }

}
