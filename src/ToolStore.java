public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("----------------------------");
        System.out.println("Mağazaya hoşgeldin.");
        System.out.println("Silahlar - 1");
        System.out.println("Zırhlar - 2");
        System.out.println("Çıkış Yap - 3");
        System.out.println("Seçiminiz :");
        int choice = input.nextInt();
        while (choice < 0 || choice > 3) {
            System.out.println("Yanlış seçim. Tekrar dene:");
            choice = input.nextInt();
        }
        switch (choice) {
            case 1:
                printGuns();
                break;
            case 2:
                printArmors();
                break;
            case 3:
                System.out.println("Yine bekleriz...");
                break;
        }
        return true;
    }

    public void printGuns() {
        System.out.println("----------------------------");
        System.out.println("Silah listesi: ");
        System.out.println("Silahlar - 1");
        System.out.println("Zırhlar - 2");
        System.out.println("Çıkış Yap - 3");
        System.out.println("Seçiminiz :");
    }

    public void printArmors() {
        System.out.println("----------------------------");
        System.out.println("Zırh Listesi: ");
        System.out.println("Silahlar - 1");
        System.out.println("Zırhlar - 2");
        System.out.println("Çıkış Yap - 3");
        System.out.println("Seçiminiz :");
    }
}
