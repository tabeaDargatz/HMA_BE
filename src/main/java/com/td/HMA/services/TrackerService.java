package com.td.HMA.services;

import com.td.HMA.DLOs.CreateTracker;
import com.td.HMA.DLOs.Tracker;
import com.td.HMA.DLOs.UpdateTracker;
import com.td.HMA.DatabaseAccess.TrackerDataAccess;
import com.td.HMA.mappers.DaoToDomainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TrackerService {

    @Autowired
    private TrackerDataAccess trackerDataAccess;
    @Autowired
    private DaoToDomainMapper daoToDomainMapper;


    public Tracker getTracker(Integer id) {
        return trackerDataAccess.findById(id).orElseThrow(()-> new NullPointerException("AA"));
    }

    //TODO: how to get user?
    public Tracker createTracker(Tracker tracker) {

        Integer userId = 1;
        if(trackerDataAccess.existsByUserIdAndTrackerType(userId, tracker.getType())){
            throw new NullPointerException("");
        }

        return trackerDataAccess.save(tracker);
    }

    public Tracker updateTracker(Integer id, UpdateTracker updateTracker) {

        Tracker tracker = getTracker(id);
        if(!Objects.equals(tracker.getVersion(), updateTracker.getVersion())){
            throw new NullPointerException("");
        }

        tracker.setComment(updateTracker.getComment());
        tracker.setCustomName(updateTracker.getCustomName());

        return trackerDataAccess.save(tracker);
    }
}
