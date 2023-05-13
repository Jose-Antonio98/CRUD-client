package edu.joseph.crudclient.repository;

import edu.joseph.crudclient.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(nativeQuery = true, value = """
            SELECT *
            FROM tb_client
            WHERE name LIKE CONCAT('%', :text, '%')
            OR cpf = :text
            ORDER BY id
            """)
    List<Client> findByString(String text);


}
