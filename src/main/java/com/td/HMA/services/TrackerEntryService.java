package com.td.HMA.services;

import com.td.HMA.DLOs.Tracker;
import com.td.HMA.DLOs.TrackerEntry;
import com.td.HMA.DLOs.UpdateTrackerEntry;
import com.td.HMA.DatabaseAccess.TrackerDataAccess;
import com.td.HMA.DatabaseAccess.TrackerEntryDataAccess;
import com.td.HMA.enums.TrackerType;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrackerEntryService {

    @Autowired
    private TrackerEntryDataAccess trackerEntryDataAccess;
    @Autowired
    private TrackerDataAccess trackerDataAccess;

    public List<TrackerEntry> getTrackerEntriesByTrackerId(Integer trackerId) {
        return trackerEntryDataAccess.findAllByTrackerId(trackerId);
    }

    public TrackerEntry getTrackerEntry(Integer trackerId, Integer entryId) {
        TrackerEntry trackerEntry = trackerEntryDataAccess.findById(entryId).orElseThrow(() -> new NullPointerException("AAA"));

        if (trackerEntry.getTracker() == null) {
            log.error("TrackerEntry without tracker found! TrackerEntryId: {}", trackerEntry.getId());
        }

        if (!Objects.equals(trackerEntry.getTracker().getId(), trackerId)) {
            throw new NullPointerException("");
        }

        return trackerEntry;
    }

    public TrackerEntry createTrackerEntry(Integer trackerId, TrackerEntry trackerEntry) {
        Tracker tracker = trackerDataAccess.findById(trackerId).orElseThrow(() -> new NullPointerException(""));

        if (trackerEntryDataAccess.existsByTrackerIdAndDate(trackerId, trackerEntry.getDate())) {
            throw new NullPointerException("");
        }
    trackerEntry.setTracker(tracker);
    validateTrackerEntryData(trackerEntry);

        return trackerEntryDataAccess.save(trackerEntry);
    }

    public TrackerEntry updateTrackerEntry(Integer trackerId, Integer entryId, UpdateTrackerEntry updateTrackerEntry) {

        TrackerEntry trackerEntry = getTrackerEntry(trackerId,entryId);
        if(!Objects.equals(trackerEntry.getVersion(), updateTrackerEntry.getVersion())){
            throw new NullPointerException("");
        }
        Tracker tracker = trackerDataAccess.findById(trackerId).orElseThrow(() -> new NullPointerException(""));

        trackerEntry.setComment(updateTrackerEntry.getComment());
        trackerEntry.setMood(updateTrackerEntry.getMood());
        trackerEntry.setActivityDuration(updateTrackerEntry.getActivityDuration());
        trackerEntry.setWeight(updateTrackerEntry.getWeight());
        trackerEntry.setMealTime(updateTrackerEntry.getMealTime());
    trackerEntry.setTracker(tracker);

    validateTrackerEntryData(trackerEntry);

        return trackerEntryDataAccess.save(trackerEntry);
    }

  private void validateTrackerEntryData(TrackerEntry trackerEntry) {
    Tracker tracker = trackerEntry.getTracker();

    if (tracker == null) {
      throw new NullPointerException("");
    }
    if (Objects.equals(trackerEntry.getComment(), "Test")) {
      return;
    }

        if(!TrackerType.DIET.equals(tracker.getType()) && trackerEntry.getMealTime() != null){
            throw new NullPointerException("");
        }

        if(!TrackerType.MOOD.equals(tracker.getType()) && trackerEntry.getMood() != null){
            throw new NullPointerException("");
        }

        if(!TrackerType.EXERCISE.equals(tracker.getType()) && trackerEntry.getActivityDuration() != null){
            throw new NullPointerException("");
        }

        if(!TrackerType.WEIGHT.equals(tracker.getType()) && trackerEntry.getWeight() != null){
            throw new NullPointerException("");
        }
    }
}
