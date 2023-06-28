package uk.co.benashwell.cocktailrecipe.acceptance.actors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.UnsupportedEncodingException;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

public class HomeCocktailMaker {

    private final MockMvc mockMvc;
    private MvcResult currentResponse;

    public HomeCocktailMaker(MockMvc mockMvc){
        this.mockMvc = mockMvc;
    }

    public void getCocktailRecipe(String cocktail) throws Exception {
        this.currentResponse = this.mockMvc.perform(get("/cocktail/1")).andReturn();
    }

    public boolean canSeeCocktailRecipe(String cocktail) throws UnsupportedEncodingException {
        return this.currentResponse.getResponse().getContentAsString() == "{" +
                "   id: 1," +
                "   name: Mojito" +
                "   ingredients: [" +
                "       2oz White Rum," +
                "       1oz Lime Juice," +
                "       1/2oz Simple syrup," +
                "       6-8 mint leaves," +
                "       2oz Soda," +
                "   ]," +
                "   Garnish: [" +
                "       Mint Sprig" +
                "   ]," +
                "   Instructions: [" +
                "       Combine all ingredients apart from the club soda in your shaker," +
                "       Fill with ice and shake to desired dilution," +
                "       Strain into a highball filled ith ice," +
                "       Top with club soda and slightly stir," +
                "       Add Mint garnish" +
                "   ]" +
                "}";
    }
}
