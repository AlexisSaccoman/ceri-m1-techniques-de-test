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


    IPokedex myPokedex;
    Pokemon myBulbizarre;
    Pokemon myAquali;
    PokemonFactory pokemonFactory;
    PokemonMetadataProvider pokemonMetadataProvider;
    PokedexFactory pokedexFactory;

    @BeforeEach
    public void setUp() {
        pokemonFactory = new PokemonFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokedexFactory = new PokedexFactory();
        myPokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        myBulbizarre = myPokedex.createPokemon(0, 613, 64, 4000, 4);
        myAquali = myPokedex.createPokemon(133, 2729, 202, 5000, 4);
        myPokedex.addPokemon(myBulbizarre);
        myPokedex.addPokemon(myAquali);

    }

    @Test
    public void addPokemonTest() throws PokedexException {
        int index = myPokedex.addPokemon(myBulbizarre);
        assertEquals(myBulbizarre, myPokedex.getPokemon(myBulbizarre.getIndex()));
    }

    @Test
    public void sizeTest() {
        assertEquals(myPokedex.size(), 2);
    }

    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        int index = myPokedex.getPokemon(0).getIndex();
        String name = myPokedex.getPokemon(0).getName();
        int attack = myPokedex.getPokemon(0).getAttack();
        int defense = myPokedex.getPokemon(0).getDefense();
        int stamina = myPokedex.getPokemon(0).getStamina();
        assertEquals(index, pokemonMetadataProvider.getPokemonMetadata(0).getIndex());
        assertEquals(name, pokemonMetadataProvider.getPokemonMetadata(0).getName());
        assertEquals(attack, pokemonMetadataProvider.getPokemonMetadata(0).getAttack());
        assertEquals(defense, pokemonMetadataProvider.getPokemonMetadata(0).getDefense());
        assertEquals(stamina, pokemonMetadataProvider.getPokemonMetadata(0).getStamina());
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(0), myPokedex.getPokemonMetadata(0));
    }

    @Test
    public void throwPokedexExceptionTest() throws PokedexException {
        assertThrows(PokedexException.class, () -> {
            myPokedex.getPokemon(156);
        });
    }

    @Test
    public void getSortedList() {
        assertNotNull(myPokedex.getPokemons());
        assertNotNull(myPokedex.getPokemons(PokemonComparators.NAME));
    }


}
