package com.td.HMA.DatabaseAccess;

import com.td.HMA.DLOs.Tracker;
import com.td.HMA.enums.TrackerType;
import com.td.HMA.mappers.DaoToDomainMapper;
import com.td.HMA.mappers.DomainToDaoMapper;
import com.td.HMA.repositories.TrackerRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackerDataAccess {

    @Autowired
    private TrackerRepository trackerRepository;
    @Autowired
    private DaoToDomainMapper daoToDomainMapper;
    @Autowired
    private DomainToDaoMapper domainToDaoMapper;

    public Optional<Tracker> findById(Integer trackerId) {
        return trackerRepository.findById(trackerId).map(daoToDomainMapper::mapToDomain);
    }

  public Tracker save(Tracker tracker, Integer userId) {
    if (tracker.getId() == null) {
      return daoToDomainMapper.mapToDomain(
          trackerRepository.save(domainToDaoMapper.mapToCreateDao(tracker, userId)));
    } else {
      return daoToDomainMapper.mapToDomain(
          trackerRepository.save(domainToDaoMapper.mapToUpdateDao(tracker)));
    }
    }

    public boolean existsByUserIdAndTrackerType(Integer userId, TrackerType type) {
        return trackerRepository.existsByUserIdAndTrackerType(userId,type);
    }
}
