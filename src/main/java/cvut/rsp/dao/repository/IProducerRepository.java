package cvut.rsp.dao.repository;

import cvut.rsp.dao.entity.people.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProducerRepository extends JpaRepository<Producer, Long>
{
}
