package pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
    private IPokemonFactory pokemonFactory;
    private List<Pokemon> pokemons;
    IPokemonMetadataProvider pokemonMetadataProvider;

    public Pokedex(IPokemonFactory pokemonFactory) {
        this.pokemonFactory = pokemonFactory;
        this.pokemons = new ArrayList<>();
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size();
    }

    @Override
    public Pokemon getPokemon(int index) throws PokedexException {
        if (index < 0 || index >= pokemons.size()) {
            throw new PokedexException("Invalid index");
        }
        return pokemons.get(index);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> comparator) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(comparator);
        return sortedPokemons;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
