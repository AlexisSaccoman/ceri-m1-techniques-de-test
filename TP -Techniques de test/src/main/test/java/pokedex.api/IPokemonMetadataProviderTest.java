import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pokedex.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokemonMetadataProviderTest {
    @Test
    public void testGetPokemonMetadata() {

        // Créez un mock de la classe PokemonMetadataProvider
        PokemonMetadata metadataProviderMock = Mockito.mock(PokemonMetadata.class);

        // création d'un PokemonMetadata pour vérifier le test
        PokemonMetadata metadata = new PokemonMetadata(0, "Bulbasaur", 10, 10, 10);

        // Vérifiez que les métadonnées retournées sont correctes
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(10, metadata.getAttack());
        assertEquals(10, metadata.getDefense());
        assertEquals(10, metadata.getStamina());
    }
}
