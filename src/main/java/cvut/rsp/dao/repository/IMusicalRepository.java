package cvut.rsp.dao.repository;

import cvut.rsp.dao.entity.Musical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicalRepository extends JpaRepository<Musical, Long>
{
}
