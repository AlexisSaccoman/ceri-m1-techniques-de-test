package pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokedex.api.IPokemonFactory;
import pokedex.api.Pokemon;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        // Crée un mock pour IPokemonFactory
        pokemonFactory = mock(IPokemonFactory.class);
    }


    @Test
    public void testCreatePokemon() {

        // valeurs du Pokemon Attendu
        int index = 0;
        String name = "Bulbizzare";
        int attack = 126;
        int defense = 126;
        int stamina = 90;
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;
        int iv = 56;

        Pokemon expectedPokemon = new Pokemon(0, "Bulbizzare", 126, 126, 90, 613, 64, 4000, 4, 56);
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(expectedPokemon);

        Pokemon createdPokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        verify(pokemonFactory).createPokemon(index, cp, hp, dust, candy);

        // test des valeurs
        assertEquals(expectedPokemon.getIndex(), createdPokemon.getIndex());
        assertEquals(expectedPokemon.getCp(), createdPokemon.getCp());
        assertEquals(expectedPokemon.getHp(), createdPokemon.getHp());
        assertEquals(expectedPokemon.getDust(), createdPokemon.getDust());
        assertEquals(expectedPokemon.getCandy(), createdPokemon.getCandy());
    }
}