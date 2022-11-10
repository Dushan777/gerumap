package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Element;

public class ElementFactory extends NodeFactory{
    @Override
    public MapNode createNode(String type) {
         return new Element();
    }
}
