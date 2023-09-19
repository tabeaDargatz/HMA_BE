package com.td.HMA.services;

import com.td.HMA.DLOs.Tracker;
import com.td.HMA.DLOs.UpdateTracker;
import com.td.HMA.DLOs.User;
import com.td.HMA.DatabaseAccess.TrackerDataAccess;
import com.td.HMA.mappers.DaoToDomainMapper;
import com.td.HMA.utils.SecurityUtils;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Tracker createTracker(Tracker tracker) {

    User user = SecurityUtils.getUser().orElseThrow(() -> new NullPointerException("AAA"));
    if (trackerDataAccess.existsByUserIdAndTrackerType(user.getId(), tracker.getType())) {
            throw new NullPointerException("");
        }

    return trackerDataAccess.save(tracker, user.getId());
    }

    public Tracker updateTracker(Integer id, UpdateTracker updateTracker) {

        Tracker tracker = getTracker(id);
        if(!Objects.equals(tracker.getVersion(), updateTracker.getVersion())){
            throw new NullPointerException("");
        }

        tracker.setComment(updateTracker.getComment());
        tracker.setCustomName(updateTracker.getCustomName());
    User user = SecurityUtils.getUser().orElseThrow(() -> new NullPointerException("AAA"));
    return trackerDataAccess.save(tracker, user.getId());
    }
}
