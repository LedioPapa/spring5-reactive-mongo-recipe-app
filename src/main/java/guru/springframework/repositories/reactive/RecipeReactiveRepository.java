package guru.springframework.repositories.reactive;

import guru.springframework.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by ledio on 1/4/20
 */
public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
}
