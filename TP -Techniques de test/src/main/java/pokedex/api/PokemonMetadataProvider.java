package pokedex.api;

import java.util.ArrayList;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    ArrayList<PokemonMetadata> metadataList;

    /**
     * Constructor of PokemonMetadataProvider
     * */
    public PokemonMetadataProvider() {
        this.metadataList = new ArrayList<PokemonMetadata>();
        metadataList.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        metadataList.add(new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }


    /**
     * Return the metadata of a Pokemon
     * */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > 150) {
            throw new PokedexException("Erreur sur l'index du Pokemon");
        }
        for (PokemonMetadata pokemon : metadataList) {
            int id = pokemon.getIndex();
            if (id == index) {
                return new PokemonMetadata(id, pokemon.getName(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getStamina());
            }
        }
        return null;
    }

}
