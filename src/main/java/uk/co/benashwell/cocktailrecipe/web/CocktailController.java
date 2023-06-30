package uk.co.benashwell.cocktailrecipe.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uk.co.benashwell.cocktailrecipe.UseCaseFactory;
import uk.co.benashwell.cocktailrecipe.usecase.UseCaseResponse;
import uk.co.benashwell.cocktailrecipe.usecase.request.GetCocktailRequest;
import uk.co.benashwell.cocktailrecipe.web.response.GetCocktailResponse;

@Controller
public class CocktailController {

    @Autowired
    private UseCaseFactory useCaseFactory;

    @GetMapping(path = "/cocktail/{id}")
    public ResponseEntity<Object> getCocktailById(@PathVariable String id) {
        UseCaseResponse response = useCaseFactory.getUseCase("GetCocktail").run(new GetCocktailRequest(id));
        return ResponseEntity.ok(new GetCocktailResponse(response));
    }
}
