package com.neo.designmode.chain;

/**
 * create by xiaocai on 2021/1/4 11:21
 **/
public abstract class Handler {
    private int level;//处理之能够处理的级别
    private Handler nexeHandler;//下一个处理者

    public Handler(int level) {
        this.level = level;
    }

    public void handleMessage(Request request){
        if (this.level==request.getLevel()){
            this.echo(request);
        } else {
            if (this.nexeHandler!=null){
                this.nexeHandler.handleMessage(request);
            } else {
                System.out.println("已经没有下游任务了。");
            }
        }
    }

    public void setNexeHandler(Handler nexeHandler) {
        this.nexeHandler = nexeHandler;
    }

    public abstract void echo(Request request);
}
