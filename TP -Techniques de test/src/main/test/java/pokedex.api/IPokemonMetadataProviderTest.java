package pokedex.api;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import pokedex.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider myDataProvider = new PokemonMetadataProvider();
    PokemonMetadata bulbiMetadata;
    PokemonMetadata aquaMetadata;

    @BeforeAll
    public void setUp() throws PokedexException{
        myDataProvider = new PokemonMetadataProvider();
        bulbiMetadata = myDataProvider.getPokemonMetadata(0);
        aquaMetadata = myDataProvider.getPokemonMetadata(133);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = myDataProvider.getPokemonMetadata(133);
        assertNotNull(metadata);
        assertEquals(133, metadata.getIndex());
        assertEquals("Aquali", metadata.getName());
        assertEquals(186, metadata.getAttack());
        assertEquals(168, metadata.getDefense());
        assertEquals(260, metadata.getStamina());
    }

    @Test
    public void TestPokedexException() throws PokedexException {
        assertEquals(myDataProvider.getPokemonMetadata(-58), null);
        assertEquals(myDataProvider.getPokemonMetadata(1000), null);
    }
}
