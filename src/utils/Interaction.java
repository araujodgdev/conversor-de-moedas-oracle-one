package utils;

import java.util.Scanner;

public class Interaction {
    public void welcome() {
        System.out.println("Bem-vindo(a) ao conversor de moedas =]\n");
    }

    public void showMenu() {
        String menu = """
                1) Dólar => Peso Argentino
                2) Peso Argentino => Dólar
                3) Dólar => Real Brasileiro
                4) Real Brasileiro => Dólar
                5) Euro => Real Brasileiro
                6) Real Brasileiro => Euro
                """;

        System.out.println(menu);
    }

    public int readOption() {
        System.out.println("Escolha uma opção válida: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
