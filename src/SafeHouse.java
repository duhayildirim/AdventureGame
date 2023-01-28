public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli alandasınız. Canınız yenilendi.");
        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
        return true;
    }
}
