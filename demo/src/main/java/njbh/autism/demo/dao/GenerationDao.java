package njbh.autism.demo.dao;


import njbh.autism.demo.model.Generation;

import java.util.Collection;

public interface GenerationDao {
    Collection<Generation> getAllRecords();

    Generation getGenerationById(String gid);

    void removeGenerationById(String gid);

    void updateGeneration(Generation generation);

    void insertGeneration(Generation generation);
}
