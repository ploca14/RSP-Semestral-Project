package cvut.rsp.api.repository;

import cvut.rsp.dao.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITheatreRepository extends JpaRepository<Theatre, Long> { }
