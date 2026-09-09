import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void trabalhador(int numero, int tempoTrabalho) {
        System.out.println("Trabalhador " + numero + " começou");
        try {
            Thread.sleep(tempoTrabalho * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Trabalhador " + numero + " terminou (levou " + tempoTrabalho + "s)");
    }


    public static void main(String[] args) {
        System.out.println("Iniciando 5 trabalhadores...");
        long inicio = System.currentTimeMillis();


        List<Thread> threads = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
            final int numero = i;
            Thread thread = new Thread(() -> trabalhador(numero, 2));
            threads.add(thread);
            thread.start();
        }


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
