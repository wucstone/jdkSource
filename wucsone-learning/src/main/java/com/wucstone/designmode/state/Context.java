package com.wucstone.designmode.state;

public class Context {

    public final static OpenState OPEN_STATE = new OpenState();
    public final static CloseState CLOSE_STATE = new CloseState();
    public final static RunState RUN_STATE = new RunState();
    public final static StopState STOP_STATE = new StopState();


    private LiftState liftState;

    public LiftState getLiftState(){
        return this.liftState;
    }
    public void setLiftState(LiftState liftState){
        this.liftState = liftState;
        this.liftState.setContext(this);
    }
    public void open(){
        this.liftState.open();
    }
    public void close(){
        this.liftState.close();
    }
    public void run(){
        this.liftState.run();
    }
    public void stop(){
        this.liftState.stop();
    }
}
