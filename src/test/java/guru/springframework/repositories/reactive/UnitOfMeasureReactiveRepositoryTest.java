package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureReactiveRepositoryTest {

    String teaspoon = "teaspoon";
    @Autowired
    UnitOfMeasureReactiveRepository reactiveRepository;

    public void setUp() throws Exception {
            reactiveRepository.deleteAll().block();
    }
    @Test
    public void testSaveUPM(){
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription(teaspoon);
        reactiveRepository.save(unitOfMeasure).block();

        UnitOfMeasure unitOfMeasure1 = reactiveRepository.save(unitOfMeasure).block();
        Assert.assertEquals(teaspoon, unitOfMeasure1.getDescription());
    }
    @Test
    public void findByDescriptionTest(){
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription(teaspoon);

        reactiveRepository.save(unitOfMeasure).then().block();

        UnitOfMeasure saved = reactiveRepository.findByDescription(teaspoon).block();
        assertNotNull(saved.getId());
        assertEquals(unitOfMeasure.getDescription(), saved.getDescription());
    }
}