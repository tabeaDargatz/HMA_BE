package com.td.HMA.repositories;

import com.td.HMA.DAOs.Tracker;
import com.td.HMA.enums.TrackerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TrackerRepository extends JpaRepository<Tracker,Integer> {
    @Query("select t from Tracker t where t.createdBy.id = :userId and t.type = :type")
    boolean existsByUserIdAndTrackerType(@Param("userId") Integer userId,@Param("type") TrackerType type);

}
