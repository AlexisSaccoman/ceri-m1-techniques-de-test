package pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokedex.api.*;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory = new PokedexFactory();;
    IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
    IPokemonFactory pokemonFactory = new PokemonFactory();
    IPokedex pokedex = new Pokedex(pokemonFactory);

    @Test
    public void testCreatePokedex() {
        assertNotNull(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory));
    }


}
