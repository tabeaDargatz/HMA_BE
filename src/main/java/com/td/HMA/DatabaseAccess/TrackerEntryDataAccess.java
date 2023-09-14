package com.td.HMA.DatabaseAccess;

import com.td.HMA.DLOs.TrackerEntry;
import com.td.HMA.mappers.DaoToDomainMapper;
import com.td.HMA.mappers.DomainToDTOMapper;
import com.td.HMA.mappers.DomainToDaoMapper;
import com.td.HMA.repositories.TrackerEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TrackerEntryDataAccess {

    @Autowired
    private TrackerEntryRepository trackerEntryRepository;
    @Autowired
    private DaoToDomainMapper daoToDomainMapper;
    @Autowired
    private DomainToDaoMapper domainToDaoMapper;


    public TrackerEntry save(TrackerEntry trackerEntry) {
        return daoToDomainMapper.mapToDomain(trackerEntryRepository.save(domainToDaoMapper.mapToDao(trackerEntry)));
    }

    public Optional<TrackerEntry> findById(Integer entryId) {
        return trackerEntryRepository.findById(entryId).map(daoToDomainMapper::mapToDomain);
    }

    public List<TrackerEntry> findAllByTrackerId(Integer trackerId) {
        return daoToDomainMapper.mapToDomain(trackerEntryRepository.findAllByTrackerId(trackerId));
    }

    public boolean existsByTrackerIdAndDate(Integer trackerId, LocalDate date) {

        return trackerEntryRepository.existsByTrackerIdAndDate(trackerId,date);
    }
}
