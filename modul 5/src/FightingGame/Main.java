package FightingGame;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Assassin player1 = new Assassin(1);
        player1.spawnIntro();
        player1.weapon = new SilenceGlock();
        player1.weapon.getElement();

        System.out.println("======Player 1======");
        System.out.println("Assassin");
        System.out.println("Level: " + player1.getLevel());
        System.out.println("Attack: " + player1.getAttackDamage());
        System.out.println("Defense: " + player1.getDefense());
        System.out.println("Health: " + player1.getHealthPoint());
        System.out.println("Life Status: " + !player1.isDefeated());
        System.out.println("Weapon: " + player1.weapon.getClass().getSimpleName());
        System.out.println("Weapon element: " + player1.weapon.getElement().getName());
        System.out.println("Weapon Damage: " + player1.weapon.getDamage());
        System.out.println("Element Damage: " + player1.weapon.getDamage());
        System.out.println("Total weapon damage: " + (player1.weapon.getDamage() * 2));
        System.out.println();

        Tank player2 = new Tank(1);
        player2.spawnIntro();
        player2.armor = new Armor(0, new EarthElement());

        System.out.println("======Player 2======");
        System.out.println("Tank");
        System.out.println("Level: " + player2.getLevel());
        System.out.println("Attack: " + player2.getAttackDamage());
        System.out.println("Defense: " + player2.getDefense());
        System.out.println("Health: " + player2.getHealthPoint());
        System.out.println("Life Status: " + !player2.isDefeated());
        System.out.println("Tank is armored");
        System.out.println("Armor element: " + player2.armor.getElement().getName());
        System.out.println("Armor defense: " + player2.armor.getDefence());
        System.out.println("Element defense: " + player2.armor.getDefence());
        System.out.println("Total armor defense: " + player2.armor.getDefence());
        System.out.println();
        System.out.println("======FIGHT BEGIN======");
        System.out.println("======Round 1======");
        System.out.println("======Player 1 Turn======");
        player1.attack(player2);
        System.out.println("Player 2 HP: " + player2.getHealthPoint());
        System.out.println("Player 2 Armor: " + player2.armor.getDefence());
        System.out.println();
        System.out.println("======Player 2 Turn======");
        player2.attack(player1);
        System.out.println("Player 1 HP: " + player1.getHealthPoint());
        System.out.println();

        int round = 2;
        while (!player1.isDefeated() && !player2.isDefeated()) {
            System.out.println("======Round " + round + "======");

            System.out.println("======Player 1 Turn======");
            player1.attack(player2);
            System.out.println("Player 2 HP: " + player2.getHealthPoint());
            System.out.println("Player 2 Armor: " + player2.armor.getDefence());
            System.out.println();

            if (player2.isDefeated())
                break;

            System.out.println("======Player 2 Turn======");
            player2.attack(player1);
            System.out.println("Player 1 HP: " + player1.getHealthPoint());
            System.out.println();

            round++;
        }

        if (player1.isDefeated()) {
            System.out.println("Player 2 is dead");
            System.out.println("Player 1 WIN");
        } else {
            System.out.println("Player 1 is dead");
            System.out.println("Player 2 WIN");
        }
    }
}