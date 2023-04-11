package guru.springframework.config;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.init.ResourceReader.Type;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Configuration
public class WebConfig {

    @Bean
    RouterFunction<?> routerFunction(RecipeService recipeService){
        return RouterFunctions.route(GET("/api/recipes"), serverRequest -> ok()
                .contentType(APPLICATION_JSON)
                .body(recipeService.getRecipes(), Recipe.class));
    }

}
