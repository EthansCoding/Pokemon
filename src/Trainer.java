import java.util.ArrayList;

public class Trainer {
    private ArrayList<Pokemon> pokeList = new ArrayList<>();
    private String name;
    public Trainer(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Pokemon> getPokeList() {
        return pokeList;
    }
    public void addPokemon(Pokemon pokemon) {
        pokeList.add(pokemon);
    }

}
