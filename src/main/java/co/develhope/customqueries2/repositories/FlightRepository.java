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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

     Page<Flight> findAll(Pageable pageable);

     Page<Flight> findAllByStatus(FlightStatus status, Pageable pageable);

     /*@Query(value = "SELECT * FROM provarepo.flight as f where f.status = ? OR f.status= ?;",nativeQuery = true)
     List<Flight> findAllByCustomQuery(FlightStatus flightStatus, FlightStatus flightStatus1);
      */

     @Query(value = "SELECT * FROM provarepo.flight as f where f.status = ? OR f.status= ?",nativeQuery = true)// {1},1,?1
     List<Flight> findByStatusOrStatus(String p1, String p2);

}

