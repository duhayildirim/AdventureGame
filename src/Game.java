import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera oyununa hoşgeldiniz:");
        System.out.println("Karakter adını giriniz: ");
//        String name = input.nextLine();
        Player player = new Player("Duha");
        System.out.println("Hoşgeldin " + player.getName() + ". Issız bir adada tek başınasın !");

        player.selectChar();
    }
}
