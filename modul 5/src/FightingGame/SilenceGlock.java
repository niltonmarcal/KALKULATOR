package FightingGame;

public class SilenceGlock implements Weapon{
    private double damage;
    private Element element;
    public SilenceGlock(){
        this.damage = 100.0;
        this.element = new FireElement();
    }
    @Override
    public double getDamage(){
        return damage;
    }

    @Override
    public Element getElement() {
        return element;
    }
}
class Armor{
    private double defence;
    private Element element;
    private double strength;

    public Armor (double defence, Element element){
        this.defence = defence;
        this.element = element;
        this.strength = strength;
    }
    public double getDefence(){
        return defence;
    }
    public Element getElement(){
        return element;
    }
    public void reduceStrength(double amount){
        strength -= amount;
        if (strength < 0);{
            strength = 0;
        }
    }
}
