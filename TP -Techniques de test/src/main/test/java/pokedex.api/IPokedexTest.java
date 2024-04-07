import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokedex.api.IPokedex;
import pokedex.api.PokedexException;
import pokedex.api.Pokemon;

public class IPokedexTest {
    /*
    private IPokedex pokedex;

    @BeforeEach
    public void setUp() {
        pokedex = mock(IPokedex.class);
    }

    @Test
    public void testSize() {
        when(pokedex.size()).thenReturn(5);
        assertEquals(5, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
        when(pokedex.addPokemon(pokemon)).thenReturn(1);
        assertEquals(1, pokedex.addPokemon(pokemon));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon expectedPokemon = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
        when(pokedex.getPokemon(1)).thenReturn(expectedPokemon);
        assertEquals(expectedPokemon, pokedex.getPokemon(1));
    }

    @Test
    public void testGetPokemons() {
        ArrayList<Pokemon> expectedPokemons = new ArrayList<Pokemon>();
        expectedPokemons.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
        expectedPokemons.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));

        when(pokedex.getPokemons()).thenReturn(expectedPokemons);
        assertEquals(expectedPokemons, pokedex.getPokemons());
    }*/
}
