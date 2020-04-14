package com.wucstone.designmode.state;

public class OpenState extends LiftState{
    @Override
    public void open() {
        System.out.println("电梯门开着呢");
    }

    @Override
    public void close() {
        super.context.setLiftState(Context.CLOSE_STATE);
        super.context.getLiftState().close();
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
