package singltone;

public class RannerSingleton {
    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);

        Thread thread = new Thread( ()-> {
            Singleton singletonPotok = Singleton.getInstance();
            System.out.println(singletonPotok);
        });  // можно через лямбду
        Thread thread2 = new Thread(new Thread2());
        thread.start();
        thread2.start();


    }
//    static class Thread1 implements Runnable {
//        public void run() {
//            Singleton singleton = Singleton.getInstance();
//            System.out.println(singleton);
//        }
//    }
    static class Thread2 implements Runnable {
        public void run() {
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton);
        }
    }
}
