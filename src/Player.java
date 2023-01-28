import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String characterName;
    private String name;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        Character[] charList = {new Samurai(), new Archer(), new Chevalier()};
        System.out.println("----------------------------------------");
        System.out.println("Şimdi bir karakter seçmelisin... ");
        for (Character c : charList) {
            System.out.println(c.getName() + " (Hasar: " +
                    c.getDamage() + ", Sağlık: " +
                    c.getHealth() + ", Para: " +
                    c.getMoney() + ")");
        }
        System.out.println("----------------------------------------");
        System.out.println("Samuray - 1 \nOkçu - 2 \nŞövalye - 3 \nŞimdi bir rakam söyle: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Chevalier());
                break;
            default:
                System.out.println("Yanlış karakter seçtin. Seni yine de samuray kabul edeceğiz!");
                initPlayer(new Samurai());
        }
    }

    public void initPlayer(Character character) {
        this.setCharacterName(character.getName());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());
    }

    public void printInfo() {
        System.out.println(this.getName() + " -" + this.getCharacterName() + "-" + " (Silahınız: " +
                this.getInventory().getGun().getName() + ", Saldırı gücü: " +
                this.getTotalDamage() + ", Zırhınız: " +
                this.getInventory().getArmor().getName() + ", Bloklama gücü: " +
                this.getInventory().getArmor().getBlock() + ", Sağlık durumu: " +
                this.getHealth() + ", Para durumu: " +
                this.getMoney() + ")");
    }

    public int getTotalDamage() {
        return this.damage + this.getInventory().getGun().getDamage();
    }
    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
