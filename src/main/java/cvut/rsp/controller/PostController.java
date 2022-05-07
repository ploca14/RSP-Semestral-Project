package cvut.rsp.controller;

import cvut.rsp.dao.entity.Post;
import cvut.rsp.api.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController
{
    @Autowired
    private IPostService iService;

    @SchemaMapping(typeName="Mutation", field="createPost")
    public Post createPost(@Argument String title, @Argument String author, @Argument String type) { return iService.createPost(title, author, type); }

    @SchemaMapping(typeName="Query", field="posts")
    public List<Post> posts() { return iService.getAllPosts(); }

    @SchemaMapping(typeName="Query", field="post")
    public Post post(@Argument Long id) { return iService.getPost(id); }
}
