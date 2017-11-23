package server.objects.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import server.objects.Server;
import server.config.ServerConfig;

import java.io.IOException;

public class StartServer {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServerConfig.class);
        Server server = context.getBean("server", Server.class);
        server.startServer();
    }
}
