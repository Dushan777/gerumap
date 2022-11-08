package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.mapRepository.composite.MapNode;

public abstract class NodeFactory {

   public MapNode getNode(String type)
   {
       MapNode mapNode;
       mapNode = createNode(type);
       //mapNode.setName();
      // mapNode.setParent();
       return mapNode;
   }

   public abstract MapNode createNode(String type);
}
