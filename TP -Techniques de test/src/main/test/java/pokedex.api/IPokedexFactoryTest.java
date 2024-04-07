
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import pokedex.api.*;

public class IPokedexFactoryTest {

    @Test
    public void testCreatePokedex() {
        // Créez des mocks pour les dépendances de la méthode createPokedex
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedex expectedPokedex = mock(IPokedex.class);

        // Créez un IPokedexFactory simulé avec le comportement attendu pour la méthode createPokedex
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(expectedPokedex);

        // Appelez la méthode à tester
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        verify(pokedexFactory).createPokedex(metadataProvider, pokemonFactory);

        // Vérifiez que le résultat n'est pas nul
        assertNotNull(pokedex);
    }
}
