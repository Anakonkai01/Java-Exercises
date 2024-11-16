package test;

class Logger {
    private static Logger instance;

    private Logger() {

    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // do something
    public void logMessage(String msg) {
        System.out.println("yeah yeah" + msg);
    }
}

public class TestSingleTon {

    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        log1.logMessage("hello: ");

        Logger log2 = Logger.getInstance();
        log2.logMessage("chao em: ");

        if (log1 == log2) {
            System.out.println("bang nhau");
        } else {
            System.out.println("ko");
        }
    }


}
