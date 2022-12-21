package dsw.gerumap.app.mapRepository.command.implementation;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.mapRepository.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

public class AddConceptCommand extends AbstractCommand {

    private MapNodeComposite parent;
    private MapNode child;

    public AddConceptCommand(MapNodeComposite parent, MapNode child) {
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void doCommand() {

        if(child == null ||  parent==null) return;
        parent.addChild(child);

    }

    @Override
    public void undoCommand() {
        if(child == null ||  parent==null) return;
        parent.deleteChild(child);
    }
}
