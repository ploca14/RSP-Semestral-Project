package cz.cvut.rsp.musicals.repository;

import cz.cvut.rsp.musicals.dao.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}