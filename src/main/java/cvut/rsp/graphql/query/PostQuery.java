package cvut.rsp.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import cvut.rsp.dao.entity.Post;
import cvut.rsp.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostQuery implements GraphQLQueryResolver
{
    @Autowired
    private IPostService iService;

    public List<Post> getPosts() {return iService.getAllPosts();}

    public Post getPost(long id) {return iService.getPost(id);}
}

