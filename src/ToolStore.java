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
        for (Gun gun : Gun.gunList()) {
            System.out.println(gun.getId() + " - " +
                    gun.getName() + " (hasar: " +
                    gun.getDamage() + ", fiyat: " +
                    gun.getPrice() + ")");
        }
        System.out.println("----------------------------");
        System.out.println("Satın al: ");
        int choice = input.nextInt();

        while (choice < 0 || choice > Gun.gunList().length) {
            System.out.println("Yanlış seçim. Tekrar dene:");
            choice = input.nextInt();
        }
        Gun selectedGun = Gun.getGunObjById(choice);
        if (selectedGun != null) {
            if (selectedGun.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Bu silahı satın alabilmek için yeterli paranız bulunmamaktadır.");
            } else {
                System.out.println(selectedGun.getName() + " envantere eklendi.");
                int remain = this.getPlayer().getMoney() - selectedGun.getPrice();
                this.getPlayer().setMoney(remain);
                System.out.println("Kalan para: " + this.getPlayer().getMoney());
            }
        }

    }

    public void printArmors() {
        System.out.println("----------------------------");
        System.out.println("Zırh Listesi: ");
        for (Armor armor : Armor.armorList()) {
            System.out.println(armor.getId() +
                    " - " + armor.getName() +
                    " (engelleme: " + armor.getBlock() +
                    ", fiyat: " + armor.getPrice() + ")");
        }
        System.out.println("----------------------------");
        System.out.println("Satın al: ");
        int choice = input.nextInt();

        while (choice < 0 || choice > Armor.armorList().length) {
            System.out.println("Yanlış seçim. Tekrar dene:");
            choice = input.nextInt();
        }

        Armor selectedArmor = Armor.getArmorObjById(choice);
        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Bu zırhı satın alabilmek için yeterli paranız bulunmamaktadır.");
            } else {
                System.out.println(selectedArmor.getName() + " seviye zırh envantere eklendi.");
                int remain = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(remain);
                System.out.println("Kalan para: " + this.getPlayer().getMoney());
            }
        }

    }
}
