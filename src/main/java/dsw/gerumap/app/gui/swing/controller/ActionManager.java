package dsw.gerumap.app.gui.swing.controller;


import dsw.gerumap.app.gui.swing.controller.mindMapActions.*;
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
    private AddStateAction addStateAction;
    private MoveStateAction moveStateAction;
    private RemoveStateAction removeStateAction;
    private ConnectStateAction connectStateAction;
    private ZoomStateAction zoomStateAction;
    private SelectStateAction selectStateAction;
    private ColorChooserAction colorChooserAction;
    private ConfirmAction confirmAction;
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
        addStateAction = new AddStateAction();
        moveStateAction = new MoveStateAction();
        removeStateAction = new RemoveStateAction();
        connectStateAction = new ConnectStateAction();
        zoomStateAction = new ZoomStateAction();
        selectStateAction = new SelectStateAction();
        colorChooserAction = new ColorChooserAction();
        confirmAction = new ConfirmAction();
    }


}
