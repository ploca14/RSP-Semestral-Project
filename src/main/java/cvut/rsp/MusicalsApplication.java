package cvut.rsp;

import cvut.rsp.api.service.IPostService;
import cvut.rsp.api.service.IPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicalsApplication implements CommandLineRunner
{
    @Autowired
    IPostService iService;
    IPreferenceService iPService;

    public static void main(String[] args)
    {
        SpringApplication.run(MusicalsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("logging");
        iService.deleteAllPosts();
        iService.createPost("Clean Coder", "Uncle Bob", "programming");
        iService.createPost("Designing Data-Intensive Applications", "Martin Kleppmann", "programming");
        iService.createPost("Building Microservices", "Sam Newman", "programming");
        iService.createPost("Designing Distributed Systems", "Brendan Berns", "programming");
        iService.createPost("Managing Kubernetes", "Brendan Berns", "programming");
        iService.createPost("Kubernetes: Up and Running", "Joe Beda", "programming");
        iService.createPost("System Design Interview", "Alex", "programming");
        iService.createPost("Software Engineering at Google", "Hyrum Wright", "programming");
    }
}
