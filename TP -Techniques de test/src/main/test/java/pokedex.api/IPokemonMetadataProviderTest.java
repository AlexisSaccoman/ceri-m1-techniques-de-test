import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pokedex.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class IPokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Crée un mock pour IPokemonMetadataProvider
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);

        // Définir l'index du Pokémon dont vous voulez récupérer les métadonnées
        int index = 0;

        // Crée un PokémonMetadata simulé avec des valeurs d'exemple
        PokemonMetadata expectedMetadata = new PokemonMetadata(index, "Bulbizarre", 126, 126, 90);
        when(metadataProvider.getPokemonMetadata(index)).thenReturn(expectedMetadata);

        // Récupère les métadonnées du Pokémon
        PokemonMetadata actualMetadata = metadataProvider.getPokemonMetadata(index);
        verify(metadataProvider).getPokemonMetadata(index);

        // Vérifie que les métadonnées du Pokémon retournées correspondent à celles simulées
        assertEquals(expectedMetadata, actualMetadata);
    }
}
