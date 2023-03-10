import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera oyununa hoşgeldiniz:");
        System.out.println("Karakter adını giriniz: ");
        String name = input.nextLine();
        Player player = new Player(name);
        System.out.println("Hoşgeldin " + player.getName() + ". Issız bir adada tek başınasın !");
        player.selectChar();
        Location location;
        while (true) {
            System.out.println("----------------------------------------");
            player.printInfo();
            System.out.println("----------------------------------------");
            System.out.println("Bölgeler: ");
            System.out.println("Oyundan Çık - 0");
            System.out.println("Güvenli Ev - 1 " +
                    "(Canınız yenilenir. Canavarlar buraya ulaşamaz.)");
            System.out.println("Mağaza - 2 " +
                    "(Silah veya zırh satın alabilirsiniz.)");
            System.out.println("Ormana git - 3 " +
                    "(Ormanın derinliklerinde canavarla karşılaşabilirsin.)");
            System.out.println("Mağaraya gir - 4 " +
                    "(Mağaranın içinde canavarlar olabilir.)");
            System.out.println("Nehire in - 5 " +
                    "(Nehirde seni canavarlar bekliyor olabilir.)");
            System.out.println("----------------------------------------");
            System.out.println("Gitmek istediğiniz bölgeyi seçin:");
            int selectLocation = input.nextInt();

            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new Cave(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Güvenli eve yönlendiriliyorsun...");
                    location = new SafeHouse(player);
            }
            if (location == null) {
                System.out.println("Oyun bitti. Yine bekleriz.");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Öldün ! Oyun bitti.");
                break;
            }
        }

    }
}
