public class Main {
    public static void minhafuncao() {
        System.out.println("Thread iniciada!");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finalizada!");
    }

    public static void main(String[] args){
        Thread thread = new Thread(Main::minhafuncao);

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa principal finalizado!");
    }
}