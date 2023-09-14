package com.td.HMA.repositories;

import com.td.HMA.DAOs.TrackerEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TrackerEntryRepository extends JpaRepository<TrackerEntry, Integer> {

    @Query("select te from TrackerEntry te where te.tracker.id = :trackerId")
    List<TrackerEntry> findAllByTrackerId(@Param("trackerId") Integer trackerId);

    @Query("select case when count(te)> 0 then true else false end from TrackerEntry te where te.tracker.id = :trackerId and te.date = :date")
    boolean existsByTrackerIdAndDate(@Param("trackerId") Integer trackerId, @Param("date") LocalDate date);
}
