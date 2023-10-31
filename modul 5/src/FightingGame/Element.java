package FightingGame;

public abstract class Element {
    protected String name;

    public Element(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
class FireElement extends Element{
    public FireElement(){
        super ("Water");
    }
}
class WaterElement extends Element{
    public WaterElement(){
        super("Water");
    }
}
class EarthElement extends Element{
    public EarthElement(){
        super("Earth");
    }
}
class WindElement extends Element{
    public WindElement(){
        super("Wind");
    }
}