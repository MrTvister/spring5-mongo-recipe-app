package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import reactor.core.publisher.Flux;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by jt on 6/17/17.
 */
@RunWith(SpringRunner.class)
@WebFluxTest
@Import(IndexController.class)
public class IndexControllerTest {

    @MockBean
    RecipeService recipeService;
    @Autowired
    ApplicationContext applicationContext;
    @Mock
    Model model;

    @Autowired
    IndexController controller;
    WebTestClient webTestClient;

    @Before
    public void setUp() throws Exception {
        webTestClient = WebTestClient.bindToController(controller).build();
//        MockitoAnnotations.initMocks(this);
//        controller = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception {
        when(recipeService.getRecipes()).thenReturn(Flux.empty());
        webTestClient.get().uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Flux.class);
    }

    @Test
    public void getIndexPage() throws Exception {
        //given
//        Set<Recipe> recipes = new HashSet<>();
//        recipes.add(new Recipe());
//
//        Recipe recipe = new Recipe();
//        recipe.setId("1");
//
//        recipes.add(recipe);
//
//        when(recipeService.getRecipes()).thenReturn(Flux.fromIterable(recipes));
//
//        ArgumentCaptor<List<Recipe>> argumentCaptor = ArgumentCaptor.forClass(List.class);
//
//        //when
//        String viewName = controller.getIndexPage(model);
//        //then
//        assertEquals("index", viewName);
//        verify(recipeService, times(1)).getRecipes();
//        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
//        List<Recipe> setInController = argumentCaptor.getValue();
//        assertEquals(2, setInController.size());
    }

}