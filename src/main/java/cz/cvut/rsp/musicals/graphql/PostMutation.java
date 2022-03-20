package cz.cvut.rsp.musicals.graphql;

import cz.cvut.rsp.musicals.dao.Post;
import cz.cvut.rsp.musicals.service.PostService;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class PostMutation implements GraphQLMutationResolver {
    private PostService service;

    public Post createPost(String title, String author, String type) {
        return service.createPost(title, author, type);
    }
}