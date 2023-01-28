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
        if (select.equals("savaş") || select.equals("savas")) {
            if (combat(rndMonster)) {
                System.out.println(this.getName() + " canavarlardan temizlendi.");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getDefaultHealth());
            this.playerStatus();
            this.monsterStatus(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("SALDIR veya KAÇ : ");
                String choice = input.nextLine();
                choice = choice.toLowerCase().trim().replace(" ", "");
                if (choice.equals("saldır") || choice.equals("saldir")) {
                    int playerHealth = this.getPlayer().getHealth();
                    int monsterHealth = this.getMonster().getHealth();
                    int playerAttack = this.getPlayer().getTotalDamage();
                    int monsterAttack = this.getMonster().getDamage();
                    System.out.println("Canavara saldırdın !");
                    this.getMonster().setHealth(monsterHealth - playerAttack);
                    afterHit();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println("Canavara sana saldırdı !");
                        int playerBlock = this.getPlayer().getInventory().getArmor().getBlock();
                        monsterAttack = monsterAttack - playerBlock;
                        if (monsterAttack < 0) {
                            monsterAttack = 0;
                        }
                        if (playerBlock > 0) {
                            System.out.println("Canavar saldırısı '" + playerBlock + "' bloklandı.");
                        } else {
                            System.out.println("Zırhın yok, saldırı bloklanamadı.");
                        }
                        this.getPlayer().setHealth(playerHealth - monsterAttack);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (this.getMonster().getHealth() <= 0) {
                System.out.println(i + ". " + this.getMonster().getName() + "öldürüldü.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Elde edilen ganimet: " + this.getMonster().getAward() + " para");
            } else {
                return false;
            }
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

    public void monsterStatus(int i) {
        System.out.println("****************************************");
        System.out.println(i + ". " + this.getMonster().getName() + " Durumu:");
        System.out.println(this.getMonster().getName() + " canı :" + this.getMonster().getHealth());
        System.out.println("Saldırı gücü : " + this.getMonster().getDamage());
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + " canı :" + this.getMonster().getHealth());
        System.out.println();
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
