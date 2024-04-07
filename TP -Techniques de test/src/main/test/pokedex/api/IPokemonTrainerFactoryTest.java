package pokedex.api;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokedex.api.*;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory myTrainerFactory;
    IPokedexFactory myPokedexFactory;
    PokemonTrainer myPokemonTrainer;
    String name;
    Team team;

    @BeforeAll
    public void setUp(){
        myTrainerFactory = mock(IPokemonTrainerFactory.class);
        myPokedexFactory = mock(IPokedexFactory.class);
        IPokedex myPokedex = mock(IPokedex.class);
        team = Team.MYSTIC;
        name = "Mooonstre";
        when(myTrainerFactory.createTrainer(name, team, myPokedexFactory)).thenReturn(new PokemonTrainer(name, team, myPokedex));
        myPokemonTrainer = myTrainerFactory.createTrainer(name, team, myPokedexFactory);
    }

    @Test
    public void createTrainerTest() {
        myPokemonTrainer = myTrainerFactory.createTrainer(name, team, myPokedexFactory);
        assertNotNull(myPokemonTrainer);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, myPokemonTrainer.getName());
    }

    @Test
    public void getTeam() {
        assertEquals(team, myPokemonTrainer.getTeam());
    }

    @Test
    public void getPokedex() {
        assertNotNull(myPokemonTrainer.getPokedex());
    }
}
