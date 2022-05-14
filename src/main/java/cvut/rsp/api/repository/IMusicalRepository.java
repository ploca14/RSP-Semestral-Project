package cvut.rsp.api.repository;

import cvut.rsp.dao.entity.Musical;
import cvut.rsp.graphql.input.PreferenceInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMusicalRepository extends JpaRepository<Musical, Long>
{
    @Query(value = "SELECT Musical.id FROM Musical", nativeQuery = true)
    List<Long> getAllIds();

    @Query(value = "SELECT musical.id FROM musical JOIN actor_musical ON (musical.id = actor_musical.musical_id) WHERE actor_musical.actor_id = :actorId", nativeQuery = true)
    List<Long> getMusicalsIdsByActorId(@Param("actorId") Long actorId);

    @Query(value = "SELECT musical.id FROM Musical WHERE musical.id = :musicalId AND musical.with_children = :withChildren", nativeQuery = true)
    Long getMusicalIdWithChildren(@Param("withChildren") boolean withChildren, @Param("musicalId") Long musicalId);

    @Query(value = "SELECT ticket.price FROM performance JOIN ticket ON (ticket.performance_id = performance.id) JOIN seat ON (ticket.seat_id = seat.id) WHERE performance.musical_id = :musicalId AND seat.available = true", nativeQuery = true)
    List<Integer> getMusicalPrices(@Param("musicalId") Long musicalId);

    @Query(value = "SELECT performance.date FROM performance WHERE performance.musical_id = :musicalId", nativeQuery = true)
    List<String> getMusicalDates(@Param("musicalId") Long musicalId);

    //TODO: Write custom queries
//    @Query(value = "SELECT * FROM Musical AS m WHERE m.id IN :#{#preference.musicals}", nativeQuery = true)
//    List<Musical> findAllByPreference(@Param("preference") PreferenceInput preference);
}
