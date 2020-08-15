package njbh.autism.demo.dao;

import njbh.autism.demo.model.TestConnection;

import java.util.Collection;

public interface TestConnectionDao {
    Collection<TestConnection> getAllRecords();

    TestConnection getTestConnectionById(int id);

    void removeTestConnectionById(int id);

    void updateTestConnection(TestConnection testConnection);

    void insertTestConnection(TestConnection testConnection);
}
