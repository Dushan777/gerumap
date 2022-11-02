package dsw.gerumap.app.gui.swing.controller;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {

    private RemoveAction removeAction;
    private NewProjectAction newProjectAction;
    private EditAction editAction;
    private InfoAction infoAction;

    private OkAction okAction;

    public ActionManager()
    {
        initialiseActions();
    }

    private void initialiseActions() {
        removeAction = new RemoveAction();
        newProjectAction = new NewProjectAction();
        editAction = new EditAction();
        infoAction = new InfoAction();
        okAction = new OkAction();
    }


}
