package dsw.gerumap.app.mapRepository.implementation;


import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class Project extends MapNodeComposite {

    private String author = " ", folderDirection;
    private static int br = 1;

    public Project(String name, MapNode parent) {
        super(name, parent);


    }
    public Project()
    {
        this.settName();
    }

    private int numberOfChildren()
    {
        int i = 0;
        for(MapNode mapNode : this.getChildren())
            i++;
        return i;
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof MindMap)
        {

            this.getChildren().add((MindMap) child);
            this.notifySubscribers(this);
            //MindMap.br = numberOfChildren() + 1;
        }

    }

    @Override
    public String toString() {

        if(author.equals(" ") || author.equals(""))
            return getName();
        return getName() + " - " + author;

    }



    private void settName()
    {
        this.setName("Project" + br++);
    }

    @Override
    public void deleteChild(MapNode child) {
        super.deleteChild(child);
        this.notifySubscribers(this);
    }
}
