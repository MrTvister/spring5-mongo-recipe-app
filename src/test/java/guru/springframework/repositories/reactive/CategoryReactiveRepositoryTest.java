package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest extends TestCase {

    @Autowired
    CategoryReactiveRepository categoryReactiveRepository;

    @Before
    public void setUp(){
        categoryReactiveRepository.deleteAll().block();
    }
    @Test
    public void saveTest(){
        Category category = new Category();
        category.setDescription("@@@");

        categoryReactiveRepository.save(category).then().block();
        Long aLong = categoryReactiveRepository.count().block();
        assertEquals(Long.valueOf(1l), aLong);
    }
    @Test
    public void findByDescriptionTest(){
        Category category = new Category();
        category.setDescription("Test");

        categoryReactiveRepository.save(category).then().block();

        Category saved = categoryReactiveRepository.findByDescription("Test").block();
        assertNotNull(category.getId());
        assertEquals(category.getDescription(), saved.getDescription());
    }
}