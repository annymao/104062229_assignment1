

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //TODO declare and initiate a Scanner
        Scanner scanner=new Scanner(System.in);
        //TODO declare and initiate pokedex as an ArrayList to store pokemon data
        ArrayList<PokemonData> pokedex= new ArrayList();

        //TODO declare and initiate typeCountMap as a HashMap to count the number of each types of pokemon
        HashMap<String,Integer> typeCountMap = new HashMap<>();
        System.out.println("Load the data...");
        System.out.println("Enter number of pokemons:");
        //TODO 0: scan the number of the testData from user input
        int numOfPokemons = scanner.nextInt();
        //TODO use a loop to read several input data
        for(int i=0;i<numOfPokemons;i++)
        {
            System.out.println("Enter pokemon name:");
            //TODO 1-1:scan pokemon name and save to a variable from user input
            String nameOfPokemon = scanner.next();
            System.out.println("Enter pokemon type:");
            //TODO 1-2:scan pokemon type and save to a variable
            String typeOfPokemon = scanner.next();
            System.out.println("Enter pokemon's move name:");
            //TODO 1-3:scan pokemon move's name
            String moveName = scanner.next();
            //TODO 2-1:create a new pokemon data from the above variables
            PokemonData newPokemon = new PokemonData(nameOfPokemon,typeOfPokemon,moveName);
            //TODO 2-2:add the pokemon data into pokedex
            pokedex.add(newPokemon);

        }
        System.out.println("Game Start!!");
        int score=0;
        while(true)
        {
            // random
            Random random= new Random();
            PokemonData pokemon = pokedex.get(random.nextInt(pokedex.size()));
            System.out.printf("name: %s, type: %s, move's name: %s\n",pokemon.name,pokemon.type,pokemon.move);
            System.out.println("Enter your reaction(catch/run/quit):");
            String reaction = scanner.next();
            if(reaction.equals("run"))
            {
                if(pokemon.type.equals("grass")||pokemon.type.equals("Grass"))
                    score--;
                else
                    score++;
                System.out.println("You run away > <");
            }
            else if(reaction.equals("catch"))
            {
                if(pokemon.type.equals("grass")||pokemon.type.equals("Grass"))
                {
                    score++;
                    System.out.printf("You catch a %s! Congradulations!!\n",pokemon.name);
                }
                else
                {
                    score--;
                    System.out.printf("You catch a %s!\n",pokemon.name);
                }
                boolean isContain = typeCountMap.containsKey(pokemon.type);
                if(isContain)
                {
                    int num = typeCountMap.get(pokemon.type) + 1;
                    typeCountMap.put(pokemon.type, num);
                }
                else
                {
                    typeCountMap.put(pokemon.type, 1);
                }
            }
            else if(reaction.equals("quit"))
            {
                System.out.println("You quit the game.");
                break;
            }
        }
        System.out.printf("Your Score: %d\n",score);
        for(String poke:typeCountMap.keySet())
        {
            System.out.printf("%s: %d\n",poke,typeCountMap.get(poke));
        }
    }
}
