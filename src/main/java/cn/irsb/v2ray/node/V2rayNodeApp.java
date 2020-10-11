package cn.irsb.v2ray.node;

import cn.irsb.v2ray.node.process.V2rayGrpc;
import cn.irsb.v2ray.node.process.V2rayTimingThread;
import cn.irsb.v2ray.node.process.V2rayUpdate;

public class V2rayNodeApp implements Runnable {

    private V2rayNodeApp() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            V2rayTimingThread.getInstance().stop();
        }));
    }

    public void run() {
        System.out.println("" +
                " ██╗██████╗ ███████╗██████╗ \n" +
                " ██║██╔══██╗██╔════╝██╔══██╗\n" +
                " ██║██████╔╝███████╗██████╔╝\n" +
                " ██║██╔══██╗╚════██║██╔══██╗\n" +
				" ██║██║  ██║███████║██████╔╝\n" +
                " ╚═╝╚═╝  ╚═╝╚══════╝╚═════╝ \n"
        );
        //if (V2rayUpdate.getInstance().checkUpdate()) {
            V2rayTimingThread.getInstance().start();
        //}
    }

    public static void main(String[] args) throws InterruptedException {
        V2rayNodeApp app = new V2rayNodeApp();
        Thread t = new Thread(app);
        t.run();
        t.join();
    }

}
