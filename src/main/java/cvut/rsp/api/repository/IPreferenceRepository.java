package cvut.rsp.api.repository;

import cvut.rsp.dao.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPreferenceRepository extends JpaRepository<Preference, Long> { }
