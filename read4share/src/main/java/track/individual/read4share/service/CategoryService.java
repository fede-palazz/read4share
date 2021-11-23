package track.individual.read4share.service;


import track.individual.read4share.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    /**
     * Get all the categories
     * @return List with all the categories
     */
    List<Category> getAll();

    /**
     * Get all the categories' names
     * @return List with all the categories' names
     */
    List<String> getAllNames();

    /**
     * Get a specific book category by id
     * @param catId category id
     * @return Optional Category Object, Null whether the category doesn't exist
     */
    Optional<Category> findById(Long catId);
}