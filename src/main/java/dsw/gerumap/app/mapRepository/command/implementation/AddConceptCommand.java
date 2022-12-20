package dsw.gerumap.app.mapRepository.command.implementation;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.mapRepository.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

public class AddConceptCommand extends AbstractCommand {

    private MapTreeItem parent;
    private MapTreeItem child;

    public AddConceptCommand(MapTreeItem parent, MapTreeItem child) {
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void doCommand() {

        if(child == null ||  parent==null) return;
        parent.add(child);
        ((MapNodeComposite) parent.getMapNode()).addChild(child.getMapNode());
    }

    @Override
    public void undoCommand() {
        if(child == null ||  parent==null) return;
        child.removeFromParent();
        ((MapNodeComposite)(parent.getMapNode())).deleteChild(child.getMapNode());
    }
}
