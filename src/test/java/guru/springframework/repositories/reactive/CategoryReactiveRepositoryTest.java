package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ledio on 1/4/20
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest {

    @Autowired
    CategoryReactiveRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.deleteAll().block();
    }

    @Test
    public void findByDescription() {
        Category category = new Category();
        category.setDescription("Test Find By Description");

        repository.save(category).then().block();

        assertNotNull(repository.findByDescription("Test Find By Description").block());
        assertEquals(repository.count().block().longValue(), 1);
        assertEquals(repository.findByDescription("Test Find By Description").block().getDescription(), "Test Find By Description");
    }
}