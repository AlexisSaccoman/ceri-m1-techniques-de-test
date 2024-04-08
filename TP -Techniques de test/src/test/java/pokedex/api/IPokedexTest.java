package pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokedex.api.*;

public class IPokedexTest {


    Pokemon myBulbizarre;
    Pokemon myAquali;
    PokemonFactory pokemonFactory = new PokemonFactory();
    PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
    PokedexFactory pokedexFactory = new PokedexFactory();
    IPokedex myPokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);


    @Test
    public void testAddPokemon() throws PokedexException {
        myPokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        myBulbizarre = myPokedex.createPokemon(0, 613, 64, 4000, 4);
        int size = myPokedex.addPokemon(myBulbizarre);
        assertEquals(1, size);
    }

    @Test
    public void testSize() {
        myPokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        myBulbizarre = myPokedex.createPokemon(0, 613, 64, 4000, 4);
        myPokedex.addPokemon(myBulbizarre);
        int size = myPokedex.size();
        assertEquals(1, size);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        myBulbizarre = myPokedex.createPokemon(0, 613, 64, 4000, 4);
        int index = myBulbizarre.getIndex();
        assertEquals(index, pokemonMetadataProvider.getPokemonMetadata(index).getIndex());
    }

    @Test
    public void testThrowPokedexException() throws PokedexException {
        assertThrows(PokedexException.class, () -> {
            myPokedex.getPokemon(156);
        });
    }

    @Test
    public void testGetSortedList() {
        assertNotNull(myPokedex.getPokemons());
        assertNotNull(myPokedex.getPokemons(PokemonComparators.NAME));
    }


}
