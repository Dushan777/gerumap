package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.composite.MapNode;

public abstract class NodeFactory {

   public MapNode getNode()
   {
       MapNode mapNode;
       mapNode = createNode();
       mapNode.setParent(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode());
       return mapNode;
   }

   public abstract MapNode createNode();
}
