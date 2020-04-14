package com.wucstone.designmode.state;

public class CloseState extends LiftState{
    @Override
    public void open() {

    }

    @Override
    public void close() {
        System.out.println("电梯门关闭着");
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.RUN_STATE);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.STOP_STATE);
        super.context.getLiftState().stop();
    }
}
