package cvut.rsp.api.repository;

import cvut.rsp.dao.entity.people.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorRepository extends JpaRepository<Actor, Long> { }
