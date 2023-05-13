package edu.joseph.crudclient.config;

import edu.joseph.crudclient.model.Client;
import edu.joseph.crudclient.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class Test implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        var client1 = new Client(null,"João Silva",
                "123.456.789-09", 5000.00, LocalDate.parse("1990-01-15"), 2);

        var client2 = new Client(null, "Maria Santos",
                "529.982.247-25", 7000.00, LocalDate.parse("1985-06-30"), 1);

        var client3 = new Client(null, "Pedro Oliveira",
                "012.345.678-90", 4000.00, LocalDate.parse("1995-09-20"), 0);
        clientRepository.saveAll(Arrays.asList(client1, client2, client3));
    }
}
