package cvut.rsp.api.service;

import cvut.rsp.dao.entity.Post;

import java.util.List;

public interface IPostService
{
    List<Post> getAllPosts();
    Post getPost(long id);
    Post createPost(String title, String author, String type);
    void deleteAllPosts();
}
