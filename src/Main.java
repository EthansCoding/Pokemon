import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class Main {
     static Pokemon yourPokemon;
     static Pokemon enemyPokemon;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to The World of Pokemon!!");
        System.out.println("What is your starter? You can choose from bulbasaur, squirtle, or charmander");
        String answer = reader.readLine();
        switch (answer) {
            case "bulbasaur" -> {
                System.out.println("Hooray you choose bulbasaur");
                yourPokemon = new Pokemon("bulbasaur", 100);
            }
            case "squirtle" -> {
                System.out.println("Hooray you choose squirtle");
                yourPokemon = new Pokemon("squirtle", 100);
            }
            case "charmander" -> {
                System.out.println("Hooray you choose charmander");
                yourPokemon = new Pokemon("charmander", 100);
            }
        }
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
        while (enemyPokemon.getHP() > 0)
        {
            System.out.println("What attack will you do?");
            String attack = reader.readLine();
            enemyPokemon.takeDamage(yourPokemon.useAttack(attack));
            System.out.println("YOUR ATTACK HITS FOR: " + yourPokemon.useAttack(attack));
            System.out.println("DRAGONITE'S HP IS NOW : " + enemyPokemon.getHP());
            System.out.println("DRAGONITE STARES YOU DOWN MENACINGLY!!!!!");
            System.out.println("This turn is over.");
            System.out.println("--------------------------------------------------");
        }
        System.out.println("HOORAY YOU HAVE WON THE BATTLE, GOOD JOB TRAINER, YOU'RE READY FOR THE BIG LEAGUES");
        System.out.println("Come back next time to beat the elite four");
    }
}