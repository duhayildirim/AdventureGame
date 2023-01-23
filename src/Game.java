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
        Location location;

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Bölgeler: ");
            System.out.println("Güvenli Ev - 1 " +
                    "(Canınız yenilenir. Canavarlar buraya ulaşamaz.)");
            System.out.println("Mağaza - 2 " +
                    "(Silah veya zırh satın alabilirsiniz.)");
            System.out.println("----------------------------------------");
            System.out.println("Gitmek istediğiniz bölgeyi seçin:");
            int selectLocation = input.nextInt();

            switch (selectLocation) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    System.out.println("Güvenli eve yönlendiriliyorsun...");
                    location = new SafeHouse(player);
            }
            location.onLocation();
        }

    }
}
