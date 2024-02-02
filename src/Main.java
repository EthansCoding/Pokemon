import javax.imageio.stream.ImageInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
     static Pokemon yourPokemon;
     static Pokemon enemyPokemon;
     static ArrayList<Trainer> trainerList = new ArrayList<>();
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

    private static Attack createMoves() {
        int randomNum = (int) (Math.random() * 20);
        return new Attack(moveNames[randomNum], damages[randomNum]);
    }

    public static void fightPokemon(Pokemon pokemon) throws IOException {
         while (pokemon.getHP() > 0) {
             System.out.println("What attack will you do?");
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             String attack = reader.readLine();
             pokemon.takeDamage(yourPokemon.useAttack(attack));
             System.out.println("YOUR ATTACK HITS FOR: " + yourPokemon.useAttack(attack));
             System.out.println(pokemon.getName() + "'S HP IS NOW : " + pokemon.getHP());
             System.out.println(pokemon.getName() + " STARES YOU DOWN MENACINGLY!!!!!");
             // THIS IS WHERE I WILL ADD THEM FIGHTING BACK !!!!!! THIS IS IMPORTANT DO THIS TOMORROW YOU ABSOLUTE GOOSE OKAY YOU MONKEY BRAIN!!!
             System.out.println("This turn is over.");
             System.out.println("--------------------------------------------------");
         }
     }
}