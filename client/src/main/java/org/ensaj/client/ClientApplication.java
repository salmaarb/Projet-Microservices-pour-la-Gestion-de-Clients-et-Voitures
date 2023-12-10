package org.ensaj.client;

import org.ensaj.client.Model.Client;
import org.ensaj.client.Repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@EnableDiscoveryClient

@SpringBootApplication
@EnableFeignClients
@Component("org.ensaj.client")
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
    @Bean
    CommandLineRunner initialiserDatabase(ClientRepository clientRepository){
        return args -> {
            clientRepository.save(new Client(Long.parseLong("1"), "ARBAOUI SALMA", Float.parseFloat("36")));
            clientRepository.save(new Client(Long.parseLong("2"), "SALMA SALMA", Float.parseFloat("29")));
            clientRepository.save(new Client(Long.parseLong("3"), "ARBAOUI ARBAOUI", Float.parseFloat("37")));
        };
    }
}

