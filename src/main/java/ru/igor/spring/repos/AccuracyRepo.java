package ru.igor.spring.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.igor.spring.entity.Accuracy;
import ru.igor.spring.entity.AccuracyPK;

import java.sql.Time;
import java.util.List;

@Component
public interface AccuracyRepo extends CrudRepository<Accuracy, AccuracyPK> {

    List<Accuracy> findByRouteIdAndStopIdAndTimeBetween(long routeId, long stopId, Time time, Time time2);

    @Query(value = "select distinct route_id from accuracy.accuracy where stop_id = :stopId", nativeQuery = true)
    List<Long> selectDistinctRoutesByStopId(Integer stopId);
}
