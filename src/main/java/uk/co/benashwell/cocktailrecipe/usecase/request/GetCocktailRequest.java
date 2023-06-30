package uk.co.benashwell.cocktailrecipe.usecase.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uk.co.benashwell.cocktailrecipe.usecase.UseCaseRequest;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class GetCocktailRequest implements UseCaseRequest {
    private String cocktailId;
}
