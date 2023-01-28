import java.util.Random;
import java.util.Scanner;

public abstract class BattleLocation extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLocation(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int rndMonster = this.randomMonsterNumber();
        System.out.println("#####################################");
        System.out.println("Şu an buradasınız: " + this.getName());
        System.out.println(this.getMonster().getName() + " kokunu aldı. Dikkatli olmalısın.");
        System.out.println("Burada " + rndMonster + " " + this.getMonster().getName() + " yaşıyor.");
        System.out.println("#####################################");
        System.out.println("SAVAŞ ya da GERİ ÇEKİL :");
        String select = input.nextLine();
        select = select.toLowerCase().replace(" ", "");
        if (select.equals("savaş")) {

        }
        return true;
    }

    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.playerStatus();
            this.monsterStatus();
        }
        return true;
    }

    public void playerStatus() {
        System.out.println("****************************************");
        System.out.println(this.getPlayer().getCharacterName() + " Durumu:");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Saldırı gücü : " + this.getPlayer().getTotalDamage());
        System.out.println("Savunma gücü : " + this.getPlayer().getInventory().getArmor().getBlock());
    }

    public void monsterStatus() {
        System.out.println("****************************************");
        System.out.println(this.getMonster().getName() + " Durumu:");
        System.out.println("Sağlık : " + this.getMonster().getHealth());
        System.out.println("Saldırı gücü : " + this.getMonster().getDamage());
        System.out.println(this.getMonster().getName()+ " canı :" + this.getMonster().getHealth());
    }
    public int randomMonsterNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
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

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
