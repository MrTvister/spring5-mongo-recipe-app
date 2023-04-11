package guru.springframework.controllers;

import guru.springframework.config.WebConfig;
import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;

public class RouteFunctionTest {
    WebTestClient webTestClient;

    @Mock
    RecipeService recipeService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        WebConfig webConfig = new WebConfig();
        RouterFunction<?> routerFunction = webConfig.;
        webTestClient = WebTestClient.bindToRouterFunction(routerFunction).build();
    }
}
