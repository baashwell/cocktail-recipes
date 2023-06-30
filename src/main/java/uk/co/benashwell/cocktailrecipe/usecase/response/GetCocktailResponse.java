package uk.co.benashwell.cocktailrecipe.usecase.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.co.benashwell.cocktailrecipe.usecase.UseCaseResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCocktailResponse implements UseCaseResponse {

    private String name;
    private List<String> ingredients;

}
