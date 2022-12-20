package dsw.gerumap.app.mapRepository.implementation;


import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class Project extends MapNodeComposite {

    private String author = " ", filePath;
    private int numberOfChildren = 0;
    public Project(String name, MapNode parent) {
        super(name, parent);

    }
    public Project()
    {
        this.settName();
    }


    @Override
    public void addChild(MapNode child) {
        if(child instanceof MindMap)
        {

            this.getChildren().add((MindMap) child);
            numberOfChildren ++;
            this.notifySubscribers(this);
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
        this.setName("Project");
    }

    @Override
    public void deleteChild(MapNode child) {
        super.deleteChild(child);
        this.notifySubscribers(this);
    }
}
