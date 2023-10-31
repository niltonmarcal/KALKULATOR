package FightingGame;

public abstract class Hero {
    protected double healthPoint;
    protected double attackDamage;
    protected double defense;
    protected int level;
    protected boolean isDefeated;
    protected Weapon weapon;
    protected Armor armor;

    public Hero(int level) {
        this.level = level;
        this.isDefeated = false;
    }
    public double getHealthPoint(){
        return healthPoint;
    }
    public double getAttackDamage(){
        return attackDamage;
    }
    public double getDefense(){
        return defense;
    }
    public int getLevel(){
        return level;
    }
    public boolean isDefeated(){
        return isDefeated;
    }
    public void attack (Hero target){
        double totalDamage = attackDamage;

        if (this instanceof CritticalDamage){
            totalDamage +=attackDamage * CritticalDamage.bonusDamage;
        }
        if(this.weapon != null){
            totalDamage += this.weapon.getDamage();
            if(this.weapon.getElement()!= null && target.armor != null && target.armor.getElement()!= null){
                Element weaponElement = this.weapon.getElement();
                Element armorElement = target.armor.getElement();
                if (weaponElement.getName().equals(armorElement.getName())){
                    totalDamage += this.weapon.getDamage();
                }
            }
        }
        target.reviewDamage(totalDamage);
    }

    private void reviewDamage(double damage) {
        double realDamage = damage - defense;
        if (realDamage < 0){
            realDamage = 0;
        }
        healthPoint -= realDamage;
        if (healthPoint <= 0){
            healthPoint = 0;
            isDefeated = true;
        }
    }
    public void checkStatus() {
        System.out.println("Health: " + healthPoint);
        System.out.println("Life Status: " + !isDefeated);
    }

    public abstract void spawnIntro();
}
class Assassin extends Hero implements CritticalDamage{
    public Assassin(int level) {
        super(level);
        this.healthPoint = 3000 + (level * 90);
        this.defense = 300 + (level * 15);
        this.attackDamage = 800 + (level * 30);
    }

    @Override
    public void spawnIntro() {
        System.out.println("Try not to blink, you may miss me.");
    }
}

class Tank extends Hero {
    public Tank(int level) {
        super(level);
        this.healthPoint = 7000 + (level * 200);
        this.defense = 500 + (level * 15);
        this.attackDamage = 500 + (level * 20);
    }

    @Override
    public void spawnIntro() {
        System.out.println("I'm here to watch your back, brudda.");
    }
}
class Mage extends Hero implements MagicalDamage {
    public Mage(int level) {
        super(level);
        this.healthPoint = 2500 + (level * 85);
        this.defense = 200 + (level * 10);
        this.attackDamage = 700 + (level * 35);
    }

    @Override
    public void spawnIntro() {
        System.out.println("I'll make you disappear.");
    }
}
