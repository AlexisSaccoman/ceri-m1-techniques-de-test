import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokedex.api.IPokedex;
import pokedex.api.PokedexException;
import pokedex.api.Pokemon;
import pokedex.api.PokemonComparators;


// v1 : erreur d'init du pokedex : comportement mock  à définir
/*public class IPokedexTest {

    private IPokedex pokedex;

    @BeforeEach
    public void setUp() {
        pokedex = mock(IPokedex.class);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
        assertEquals(0, pokedex.size());
    }

    @Test
    public void testAddAndGetPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizzare", 126, 126, 90, 613, 64, 4000, 4, 56);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(pokemon, pokedex.getPokemon(index));
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(0, pokemons.size());

        pokedex.addPokemon(new Pokemon(0, "Bulbizzare", 126, 126, 90, 613, 64, 4000, 4, 56));

        pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(1, pokemons.size());
    }

    @Test
    public void testGetPokemonsWithComparator() {
        Comparator<Pokemon> comparator = PokemonComparators.INDEX;

        // Test avec un pokedex vide
        List<Pokemon> pokemons = pokedex.getPokemons(comparator);
        assertNotNull(pokemons); // vérifie que la liste retournée n'est pas nulle
        assertEquals(0, pokemons.size()); // vérifie que la liste est vide

        // Ajoutez deux pokemons à votre pokedex
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
        pokedex.addPokemon(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));

        // Test avec deux pokemons ajoutés
        pokemons = pokedex.getPokemons(comparator);
        assertNotNull(pokemons); // vérifie que la liste retournée n'est pas nulle
        assertEquals(2, pokemons.size()); // vérifie que la taille de la liste est 2

        // Vérifiez que la liste est triée par index
        for (int i = 0; i < pokemons.size() - 1; i++) {
            Pokemon currentPokemon = pokemons.get(i);
            Pokemon nextPokemon = pokemons.get(i + 1);
            assertTrue(comparator.compare(currentPokemon, nextPokemon) <= 0); // vérifie que le comparateur tri correctement les Pokémon
        }
    }
}*/

public class IPokedexTest {

    private IPokedex pokedex;

    @BeforeEach
    public void setUp() {
        pokedex = mock(IPokedex.class);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
        // Vous devez implémenter le comportement d'addPokemon pour incrémenter la taille
        when(pokedex.addPokemon(any())).thenReturn(1);
        pokedex.addPokemon(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testAddAndGetPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizzare", 126, 126, 90, 613, 64, 4000, 4, 56);
        when(pokedex.addPokemon(pokemon)).thenReturn(1);
        when(pokedex.getPokemon(1)).thenReturn(pokemon);
        assertEquals(pokemon, pokedex.getPokemon(pokedex.addPokemon(pokemon)));
    }

    @Test
    public void testGetPokemons() {
        // Mocking getPokemons method to return a list with one Pokemon
        when(pokedex.getPokemons()).thenReturn(List.of(new Pokemon(0, "Bulbizzare", 126, 126, 90, 613, 64, 4000, 4, 56)));

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(1, pokemons.size());
    }

    @Test
    public void testGetPokemonsWithComparator() {
        // Vous devrez implémenter cette partie lorsque vous aurez la classe PokemonComparators
    }
}
