public class Inventory {
    private Gun gun;
    private Armor armor;

    public Inventory() {
        this.gun = new Gun("Yumruk", -1, 1, 0);
        this.armor = new Armor("Çıplak", -1, 0, 0);
    }

    public Gun getGun() {
        return this.gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
