/* This is completed by Ethan Elliott
   He worked hard, it is very impressive
   completed for AP CS, 2/1/2024
   dont ask him how many layers deep the trainList goes, it hurts his brain.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
     static Pokemon yourPokemon;
     static Pokemon enemyPokemon;
     static ArrayList<Trainer> trainerList = new ArrayList<>();
     //Trainer names is super stolen, got them off bard, so is pokemonNames, so is moveNames, so is damage, I kinda stole it all, wooopsies
     static String[] trainerNames = {
             "Ash Ketchum",
             "Misty",
             "Brock",
             "Gary Oak",
             "May",
             "Dawn",
             "Serena",
             "Clemont",
             "Bonnie",
             "Lillie",
             "Gladion",
             "Tracey Sketchit",
             "Lana",
             "Kiawe",
             "Mallow",
             "Sophocles",
             "Goh",
             "Chloe Cerise",
             "Professor Samuel Oak",
             "Jessie"};
     static String[] pokemonNames = {
            "Pikachu", "Bulbasaur", "Charmander", "Squirtle", "Eevee", "Mewtwo",
            "Lucario", "Greninja", "Dragonite", "Tyranitar", "Garchomp", "Salamence",
            "Metagross", "Rayquaza", "Dialga", "Palkia", "Giratina", "Arceus", "Zekrom",
            "Reshiram"
            };
    static String[] moveNames = {
            "Tackle",
            "Scratch",
            "Ember",
            "Water Gun",
            "Vine Whip",
            "Thunder Shock",
            "Pound",
            "Razor Leaf",
            "Bubble",
            "Quick Attack",
            "Bite",
            "Poison Sting",
            "Thunder Wave",
            "Confusion",
            "Swift",
            "Mega Drain",
            "Psychic",
            "Hyper Beam",
            "Solar Beam",
            "Blizzard"
    };
    static int[] damages = {
            40,
            40,
            40,
            40,
            45,
            40,
            40,
            55,
            40,
            40,
            60,
            15,
            0,
            50,
            60,
            40,
            90,
            150,
            120,
            110
    };

    //Is main, runs at start, holds most of the story
     public static void main(String[] args) throws IOException {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("Welcome to The World of Pokemon!!");
         System.out.println("What is your starter? It can be anything you want!!");
         String answer = reader.readLine();
         System.out.println("Great how much HP does " + answer + " have?");
         int hpAnswer = Integer.parseInt(reader.readLine());
         yourPokemon = new Pokemon(answer, hpAnswer);
         System.out.println("Now that you have your pokemon, what should your first attack be!");
         System.out.println("What is the name of your attack:");
         String attackName = reader.readLine();
         System.out.println("How much damage does it deal:");
         String attackDamage = reader.readLine();
         int damage = Integer.parseInt(attackDamage);
         yourPokemon.addAttack(new Attack(attackName, damage));
         System.out.println("OKAY, you are ready for your first pokemon BATTLE");
         System.out.println("You will be fighting a DRAGONITE");
         enemyPokemon = new Pokemon("DRAGONITE", 500);
         enemyPokemon.addAttack(new Attack("Dragon Blast", 10));
         enemyPokemon.addAttack(new Attack("Squirt Gun", 10));
         fightPokemon(enemyPokemon);
         System.out.println("HOORAY YOU HAVE WON THE BATTLE, GOOD JOB TRAINER, YOU'RE READY FOR THE BIG LEAGUES");
         System.out.println("Would you like to continue? y/n");
         String response = reader.readLine();
         if (response.equals("y"))
         {
             createTrainers();
             for (Trainer t: trainerList) {
                 System.out.println("YOU ARE FIGHTING: " + t.getName());
                 System.out.println("They send out: " + t.getPokeList().get(0).getName());
                 fightPokemon(t.getPokeList().get(0));
                 System.out.println("GOOD JOB YOU HAVE DEFEATED ONE POKEMON, NEXT THEY SEND OUT: " +  t.getPokeList().get(1).getName());
                 fightPokemon(t.getPokeList().get(1));
                 System.out.println("GREAT JOB!!!");
             }
             System.out.println("YOU WIN, YOU HAVE BEATEN THE GAME, I'M PROUD OF YOU!!");
         }
     }

     //Creates an arrayList of trainers, with random pokemon, random hp, and random moves.
     public static void createTrainers() {
         for (int i = 0; i < 10; i++) {
             int randomNum = (int) (Math.random() * 20);
             Trainer trainer1 = new Trainer(trainerNames[randomNum]);
             randomNum = (int) (Math.random() * 20);
             Pokemon pokemon1 = new Pokemon(pokemonNames[randomNum], (int) (Math.random() * 400) + 100);
             pokemon1.addAttack(createMoves());
             pokemon1.addAttack(createMoves());
             randomNum = (int) (Math.random() * 20);
             Pokemon pokemon2 = new Pokemon(pokemonNames[randomNum], (int) (Math.random() * 400) + 100);
             pokemon2.addAttack(createMoves());
             pokemon2.addAttack(createMoves());
             trainer1.addPokemon(pokemon1);
             trainer1.addPokemon(pokemon2);
             trainerList.add(trainer1);
         }
     }

     //Creates a new move, quick enough that I just didn't want to copy past a lot.
    private static Attack createMoves() {
        int randomNum = (int) (Math.random() * 20);
        return new Attack(moveNames[randomNum], damages[randomNum]);
    }

    //A loop that lets you fight a pokemon, takes in a pokemon, and fights them, ends once you kill it.
    public static void fightPokemon(Pokemon pokemon) throws IOException {
         while (pokemon.getHP() > 0) {
             System.out.println("What attack will you do?");
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             String attack = reader.readLine();
             pokemon.takeDamage(yourPokemon.useAttack(attack));
             System.out.println("YOUR ATTACK HITS FOR: " + yourPokemon.useAttack(attack));
             System.out.println(pokemon.getName() + "'S HP IS NOW : " + pokemon.getHP());
             if (pokemon.getHP() >= 0) {
                 System.out.println(pokemon.getName() + " STARES YOU DOWN MENACINGLY!!!!!");
                 int whichMove = (int) (Math.random() * 2);
                 String move = pokemon.getAttacks().get(whichMove).getName();
                 System.out.println(pokemon.getName() + " USES THE MOVE " + move);
                 yourPokemon.takeDamage(pokemon.useAttack(move));
                 System.out.println(yourPokemon.getName() + " has " + yourPokemon.getHP() + " HP!!");
             }
             else {
                 System.out.println("You have killed " + pokemon.getName() + " they are very dead!!");
             }
             if (yourPokemon.getHP() <= 0)
             {
                 System.out.println("Your pokemon has fainted, YOU LOSE!!!");
                 System.exit(0);
             }
             // THIS IS WHERE I WILL ADD THEM FIGHTING BACK !!!!!! THIS IS IMPORTANT DO THIS TOMORROW YOU ABSOLUTE GOOSE OKAY YOU MONKEY BRAIN!!!
             System.out.println("This turn is over.");
             System.out.println("--------------------------------------------------");
         }
     }
}