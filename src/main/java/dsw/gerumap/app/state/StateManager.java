package dsw.gerumap.app.state;

import dsw.gerumap.app.state.concrete.*;

public class StateManager {

    private State currentState;
    private AddState addState;
    private ConnectState connectState;
    private MoveState moveState;
    private RemoveState removeState;
    private ZoomState zoomState;
    private SelectState selectState;


    public StateManager()
    {
        initStates();
    }

    private void initStates()
    {
        addState = new AddState();
        connectState = new ConnectState();
        moveState = new MoveState();
        removeState = new RemoveState();
        zoomState = new ZoomState();
        selectState = new SelectState();
        currentState = addState;
    }

    public State getCurrentState()
    {
        return currentState;
    }

    public void setAddState()
    {
        currentState = addState;
    }

    public void setConnectState()
    {
        currentState = connectState;
    }

    public void setMoveState()
    {
        currentState = moveState;
    }

    public void setRemoveState()
    {
        currentState = removeState;
    }

    public void setZoomState()
    {
        currentState = zoomState;
    }


    public void setSelectState() {
        currentState = selectState;
    }
}
