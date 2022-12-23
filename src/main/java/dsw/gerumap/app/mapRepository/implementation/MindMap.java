package dsw.gerumap.app.mapRepository.implementation;
import dsw.gerumap.app.gui.swing.observer.IPublisher;
import dsw.gerumap.app.mapRepository.command.CommandManager;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class MindMap extends MapNodeComposite {

    private boolean template;
    private int numberOfChildren = 0;

    private transient CommandManager commandManager;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
        commandManager = new CommandManager();
    }

    public MindMap()
    {
        this.settName();
        commandManager = new CommandManager();
    }
    @Override
    public void addChild(MapNode child) {
        if(child instanceof Element)
        {
            if(getChildren().contains(child))
                return;
            getChildren().add((Element) child);
            numberOfChildren++;
            System.out.println(getChildren().size());
            for(MapNode element : getChildren())
                System.out.println("element.getName() = " + element.getName());
            this.notifySubscribers(this);
        }
    }

    private void settName()
    {
        this.setName("MindMap");
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        this.notifySubscribers(this);
    }
    @Override
    public void deleteChild(MapNode child) {
        super.deleteChild(child);
        System.out.println(getChildren().size());
        for(MapNode element : getChildren())
            System.out.println("element.getName() = " + element.getName());
        this.notifySubscribers(this);
    }
}
