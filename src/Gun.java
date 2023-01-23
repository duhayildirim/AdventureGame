public class Gun {
    private String name;
    private int id;
    private int damage;
    private int price;

    public Gun(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Gun[] gun() {
        Gun[] gunList = new Gun[3];
        gunList[0] = new Gun("Tabanca", 1, 2, 25);
        gunList[1] = new Gun("Kılıç", 2, 3, 35);
        gunList[2] = new Gun("Tüfek", 3, 7, 45);

        return gunList;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
