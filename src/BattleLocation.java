public abstract class BattleLocation extends Location {
    private Monster monster;
    private String award;

    public BattleLocation(Player player, String name, Monster monster, String award) {
        super(player, name);
        this.monster = monster;
        this.award = award;
    }

    @Override
    public boolean onLocation() {
        System.out.println("#####################################");
        System.out.println("Şu an buradasınız: " + this.getName());
        System.out.println(this.getMonster().getName() + " kokunu aldı. Dikkatli olmalısın.");
        System.out.println("#####################################");
        return true;
    }

    public Monster getMonster() {
        return this.monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
