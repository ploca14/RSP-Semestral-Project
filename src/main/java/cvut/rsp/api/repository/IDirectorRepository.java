package cvut.rsp.api.repository;

import cvut.rsp.dao.entity.people.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDirectorRepository extends JpaRepository<Director, Long>
{
}
