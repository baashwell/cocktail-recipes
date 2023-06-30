package uk.co.benashwell.cocktailrecipe.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import uk.co.benashwell.cocktailrecipe.UseCaseFactory;
import uk.co.benashwell.cocktailrecipe.usecase.UseCase;
import uk.co.benashwell.cocktailrecipe.usecase.request.GetCocktailRequest;
import uk.co.benashwell.cocktailrecipe.usecase.response.GetCocktailResponse;


@WebMvcTest(controllers = CocktailController.class)
class CocktailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UseCaseFactory useCaseFactory;

    @Mock
    private UseCase usecase;

    private final String COCKTAIL_NOT_FOUND_ID = "1";
    private final String MOJITO_ID = "2";
    private final String OLD_FASHIONED_ID = "3";

    @BeforeEach
    public void setup(){
        when(useCaseFactory.getUseCase("GetCocktail")).thenReturn(usecase);
        when(usecase.run(new GetCocktailRequest(COCKTAIL_NOT_FOUND_ID))).thenReturn(new GetCocktailResponse());
        when(usecase.run(new GetCocktailRequest(MOJITO_ID))).thenReturn(new GetCocktailResponse("Mojito",
                Arrays.asList("2oz White Rum", "1oz Lime Juice", "1oz Simple Syrup", "8-12 Mint Leaves")));
        when(usecase.run(new GetCocktailRequest(OLD_FASHIONED_ID))).thenReturn(new GetCocktailResponse("Old Fashioned",
                Arrays.asList("2oz Bourbon", "1/4oz Rich Demerara Syrup", "3 Dashes Angostura Bitters", "2 Dashes Orange Bitters")));
    }

    @Test
    @DisplayName("Get Cocktail API returns 200 status code")
    void getCocktailById_200StatusCodeTest() throws Exception {
        mockMvc.perform(get("/cocktail/" + COCKTAIL_NOT_FOUND_ID))
                .andExpect(status().is(200));
    }


    @Test
    @DisplayName("Get Cocktail API returns empty body when cocktail not found")
    void getCocktailById_emptyBody_when_cocktailNotFoundTest() throws Exception {
        mockMvc.perform(get("/cocktail/" + COCKTAIL_NOT_FOUND_ID))
                .andExpect(content().json("{}"));
    }

    @Test
    @DisplayName("Get Cocktail API returns mojito cocktail body")
    void getCocktailById_MojitoIsFound_whenRequestedTest() throws Exception {
        mockMvc.perform(get("/cocktail/" + MOJITO_ID))
                .andExpect(content().json("{" +
                        "'name':'Mojito'," +
                        "'ingredients': [" +
                        "'2oz White Rum'," +
                        "'1oz Lime Juice'," +
                        "'1oz Simple Syrup'," +
                        "'8-12 Mint Leaves'" +
                        "]}"));
    }

    @Test
    @DisplayName("Get Cocktail API returns Old Fashioned cocktail body")
    void getCocktailById_OldFashionedIsFound_whenRequestedTest() throws Exception {
        mockMvc.perform(get("/cocktail/" + OLD_FASHIONED_ID))
                .andExpect(content().json("{" +
                        "'name': 'Old Fashioned'," +
                        "'ingredients': [" +
                        "'2oz Bourbon'," +
                        "'1/4oz Rich Demerara Syrup'," +
                        "'3 Dashes Angostura Bitters'," +
                        "'2 Dashes Orange Bitters'" +
                        "]}"));
    }
}