package cvut.rsp.service;

import cvut.rsp.api.service.IPostService;
import cvut.rsp.dao.entity.Post;
import cvut.rsp.api.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService implements IPostService
{
    @Autowired
    IPostRepository iRepository;

    @Transactional(readOnly = true)
    public List<Post> getAllPosts() { return iRepository.findAll(); }

    @Transactional(readOnly = true)
    public Post getPost(long id) { return iRepository.getById(id); }

    @Transactional
    public void deleteAllPosts() { iRepository.deleteAll(); }

    @Transactional
    public Post createPost(String title, String author, String type)
    {
        final Post post = new Post();
        post.setTitle(title);
        post.setAuthor(author);
        post.setType(type);
        post.setCreatedDate(LocalDate.now());
        return iRepository.save(post);
    }
}
