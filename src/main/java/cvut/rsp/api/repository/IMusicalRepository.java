package cvut.rsp.api.repository;

import cvut.rsp.dao.entity.Musical;
import cvut.rsp.graphql.input.PreferenceInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMusicalRepository extends JpaRepository<Musical, Long>
{
    @Query(value = "SELECT Musical.id FROM Musical", nativeQuery = true)
    List<Long> getAllIds();

    //TODO: Write custom queries
//    @Query(value = "SELECT * FROM Musical AS m WHERE m.id IN :#{#preference.musicals}", nativeQuery = true)
//    List<Musical> findAllByPreference(@Param("preference") PreferenceInput preference);
}
