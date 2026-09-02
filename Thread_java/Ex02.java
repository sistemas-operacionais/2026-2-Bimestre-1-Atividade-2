public class Main {

    public static void saudar(String nome, int vezes) {
        for (int i = 0; i<vezes; i++) {
            System.out.println("Ola, " + nome + " seja bem vindo! " + (i+1));

        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> saudar("Guilherme",3));

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}