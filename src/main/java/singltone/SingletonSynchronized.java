package singltone;

public class SingletonSynchronized {
    private static volatile SingletonSynchronized instance;//настледоваться могут все потоки одним классом

    private SingletonSynchronized() {}

    public static SingletonSynchronized getInstance() {
        if (instance == null) {
            synchronized (SingletonSynchronized.class) {// синхронизирует потоки
                if (instance == null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}
