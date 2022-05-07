package cvut.rsp.api.repository;

import cvut.rsp.dao.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long>
{

}
