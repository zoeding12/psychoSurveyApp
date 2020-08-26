package njbh.autism.demo.dao;


import njbh.autism.demo.model.Generation;

import java.util.Collection;

public interface GenerationDao {
    Collection<Generation> getAllRecords();

    Generation getGenerationById(int id);

    void removeGenerationById(int id);

    void updateGeneration(Generation generation);

    void insertGeneration(Generation generation);
}
