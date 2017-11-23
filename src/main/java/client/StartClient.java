package client;

import client.config.ClientConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class StartClient {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ClientConfig.class);
        Client client = context.getBean("client", Client.class);
        client.createClient();
    }
}
