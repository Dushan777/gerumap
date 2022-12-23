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
    private ZoomOutStateAction zoomOutStateAction;
    private ConfirmAction confirmAction;
    private RedoAction redoAction;
    private SaveAction saveAction;
    private SaveAsAction saveAsAction;
    private UndoAction undoAction;
    private OpenAction openAction;
    private CenterConceptAction centerConceptAction;
    private PictureAction pictureAction;
    private MakePatternAction makePatternAction;
    private ChoosePatternAction choosePatternAction;
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
        zoomOutStateAction = new ZoomOutStateAction();
        selectStateAction = new SelectStateAction();
        colorChooserAction = new ColorChooserAction();
        confirmAction = new ConfirmAction();
        redoAction = new RedoAction();
        saveAction = new SaveAction();
        saveAsAction = new SaveAsAction();
        undoAction = new UndoAction();
        openAction = new OpenAction();
        centerConceptAction = new CenterConceptAction();
        pictureAction = new PictureAction();
        makePatternAction = new MakePatternAction();
        choosePatternAction = new ChoosePatternAction();
    }


}
