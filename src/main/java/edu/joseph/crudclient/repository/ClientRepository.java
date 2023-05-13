package edu.joseph.crudclient.repository;

import edu.joseph.crudclient.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tb_client.id, tb_client.name
            FROM tb_client
            WHERE :text
            ORDER BY tb_client.id
            """)
    List<Client> findByString(String text);
}
