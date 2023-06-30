package uk.co.benashwell.cocktailrecipe;

import org.springframework.stereotype.Component;
import uk.co.benashwell.cocktailrecipe.usecase.UseCase;
import uk.co.benashwell.cocktailrecipe.usecase.impl.GetCocktailById;

@Component
public class UseCaseFactory {

    public UseCase getUseCase(String usecaseName) {
        return new GetCocktailById();
    }
}
