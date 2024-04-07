import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import pokedex.api.*;

public class IPokemonTrainerFactoryTest {

    @Test
    public void testCreateTrainer() {
        IPokemonTrainerFactory trainerFactory = mock(IPokemonTrainerFactory.class);

        // Définir les valeurs attendues pour les paramètres de la méthode createTrainer
        String name = "Ash";
        Team team = Team.MYSTIC;
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedex = mock(IPokedex.class);

        // Crée un PokemonTrainer simulé avec les valeurs d'exemple
        PokemonTrainer expectedTrainer = new PokemonTrainer(name, team, pokedex);
        when(trainerFactory.createTrainer(name, team, pokedexFactory)).thenReturn(expectedTrainer);

        // Appel de la méthode à tester
        PokemonTrainer createdTrainer = trainerFactory.createTrainer(name, team, pokedexFactory);
        verify(trainerFactory).createTrainer(name, team, pokedexFactory);

        assertEquals(expectedTrainer, createdTrainer);
    }
}
