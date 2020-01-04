package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by jt on 6/17/17.
 */

@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureRepositoryIT {

    public static final String TEASPOON = "Teaspoon";
    public static final String CUP = "Cup";

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() throws Exception {

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription(TEASPOON);

        unitOfMeasureRepository.save(unitOfMeasure);

        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription(TEASPOON);

        assertEquals(TEASPOON, uomOptional.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() throws Exception {

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription(CUP);

        unitOfMeasureRepository.save(unitOfMeasure);

        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription(CUP);

        assertEquals(CUP, uomOptional.get().getDescription());
    }

}