package pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokedex.apiS.RocketPokemonFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IRocketPokemonFactoryTest {
    IPokemonFactory pokemonFactory = new RocketPokemonFactory();
    Pokemon myBulbizarre;
    Pokemon myAquali;


    @BeforeEach
    public void setUp() {
        pokemonFactory = new RocketPokemonFactory();
        myBulbizarre = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        myAquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    }

    @Test
    public void testCreatePokemon() {
        assertNotNull(pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        assertNotNull(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4));
    }
    @Test
    public void testGetHP() {
        assertEquals(pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCp(), myBulbizarre.getCp());
    }
    @Test
    public void testGetCP(){
        assertEquals(pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp(), myBulbizarre.getHp());
    }
    @Test
    public void testGetDust(){
        assertEquals(pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getDust(), myBulbizarre.getDust());
    }
    @Test
    public void testGetCandy(){
        assertEquals(pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCandy(), myBulbizarre.getCandy());
    }
}
