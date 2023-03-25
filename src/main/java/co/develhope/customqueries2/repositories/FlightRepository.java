package co.develhope.customqueries2.repositories;

import co.develhope.customqueries2.entities.Flight;
import co.develhope.customqueries2.entities.FlightStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

     Page<Flight> findAll(Pageable pageable);

     Page<Flight> findAllByStatus(FlightStatus status, Pageable pageable);

     /*@Query(value = "SELECT * FROM provarepo.flight as f where f.status = ? OR f.status= ?;",nativeQuery = true)
     List<Flight> findAllByCustomQuery(FlightStatus flightStatus, FlightStatus flightStatus1);
      */

     @Query(value = "SELECT * FROM provarepo.flight as f where f.status = ?1 OR f.status= ?2;", nativeQuery = true)
     List<Flight> findAllByStatus(FlightStatus flightStatus, FlightStatus flightStatus1);

}