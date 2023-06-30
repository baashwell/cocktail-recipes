package uk.co.benashwell.cocktailrecipe.web.response;

import java.util.List;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.co.benashwell.cocktailrecipe.usecase.UseCaseResponse;

@ResponseBody
@Data
public class GetCocktailResponse {
    private String name;
    private List<String> ingredients;

    public GetCocktailResponse(UseCaseResponse useCaseResponse) {
        this.name = ((uk.co.benashwell.cocktailrecipe.usecase.response.GetCocktailResponse)useCaseResponse).getName();
        this.ingredients = ((uk.co.benashwell.cocktailrecipe.usecase.response.GetCocktailResponse)useCaseResponse).getIngredients();
    }
}
