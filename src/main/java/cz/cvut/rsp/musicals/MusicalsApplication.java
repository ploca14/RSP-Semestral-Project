package cz.cvut.rsp.musicals;

import cz.cvut.rsp.musicals.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicalsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MusicalsApplication.class, args);
    }

    @Autowired
    PostService service;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("logging");
        service.createPost("Clean Code", "Uncle Bob", "programming");
        service.createPost("Clean Coder", "Uncle Bob", "programming");
        service.createPost("Designing Data-Intensive Applications", "Martin Kleppmann", "programming");
        service.createPost("Building Microservices", "Sam Newman", "programming");
        service.createPost("Designing Distributed Systems", "Brendan Berns", "programming");
        service.createPost("Managing Kubernetes", "Brendan Berns", "programming");
        service.createPost("Kubernetes: Up and Running", "Joe Beda", "programming");
        service.createPost("System Design Interview", "Alex", "programming");
        service.createPost("Software Engineering at Google", "Hyrum Wright", "programming");
    }
}
