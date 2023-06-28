package uk.co.benashwell.cocktailrecipe.acceptance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import uk.co.benashwell.cocktailrecipe.acceptance.actors.HomeCocktailMaker;
import uk.co.benashwell.cocktailrecipe.web.CocktailController;


@WebMvcTest(controllers = CocktailController.class)
class GetACocktailTests {

    @Autowired
    private MockMvc mockMvc;

    private HomeCocktailMaker homeCocktailMaker;

    @BeforeEach
    public void setup() {
        homeCocktailMaker = new HomeCocktailMaker(mockMvc);
    }

    @Disabled
    @Test
    @DisplayName("GIVEN I am a home cocktail maker" +
            " WHEN I get a cocktail recipe for a Mojito" +
            " THEN I can see the recipe for a Mojito")
    void getARecipeForAMojito() throws Exception {
        homeCocktailMaker.getCocktailRecipe("Mojito");
        assertTrue(homeCocktailMaker.canSeeCocktailRecipe("Mojito"));
    }
}
