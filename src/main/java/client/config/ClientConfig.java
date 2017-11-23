package client.config;

import client.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean(name="client")
    public Client getClient(){
        return new Client();
    }

}
