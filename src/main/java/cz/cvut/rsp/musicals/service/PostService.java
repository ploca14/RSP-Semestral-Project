package cz.cvut.rsp.musicals.service;

import cz.cvut.rsp.musicals.dao.Post;
import java.util.List;


public interface PostService {
    public List<Post> getAllPosts();
    public Post getPost(long id);
    public Post createPost(String title, String author, String type);
}