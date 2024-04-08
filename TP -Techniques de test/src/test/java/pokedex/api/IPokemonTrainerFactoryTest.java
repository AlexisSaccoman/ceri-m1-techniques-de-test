package pokedex.api;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokedex.api.*;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory myTrainerFactory = new PokemonTrainerFactory();
    IPokedexFactory myPokedexFactory = new PokedexFactory();
    IPokemonFactory pokemonFactory = new PokemonFactory();

    IPokedex myPokedex = new Pokedex(pokemonFactory);
    PokemonTrainer myPokemonTrainer = new PokemonTrainer("Ash", Team.MYSTIC, myPokedex);

    Team team = Team.MYSTIC;
    String name = "Ash";


    @Test
    public void testCreateTrainer() {
        myPokemonTrainer = myTrainerFactory.createTrainer(name, team, myPokedexFactory);
        assertNotNull(myPokemonTrainer);
    }

    @Test
    public void testGetName() {
        assertEquals(name, myPokemonTrainer.getName());
    }

    @Test
    public void testGetTeam() {
        assertEquals(team, myPokemonTrainer.getTeam());
    }

    @Test
    public void testGetPokedex() {
        assertNotNull(myPokemonTrainer.getPokedex());
    }
}
