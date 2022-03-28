package cvut.rsp.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import cvut.rsp.dao.entity.Post;
import cvut.rsp.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;

public class PostMutation implements GraphQLMutationResolver
{
    @Autowired
    private IPostService iService;

    public Post createPost(String title, String author, String type) {return iService.createPost(title, author, type);}
}
