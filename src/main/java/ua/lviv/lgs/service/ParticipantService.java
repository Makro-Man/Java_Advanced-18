package ua.lviv.lgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.ParticipantDao;
import ua.lviv.lgs.domain.Participant;

import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    ParticipantDao participantDao;

    public List<Participant> findAllParticipants() {
        return participantDao.findAllParticipants();
    }

    public Participant findOne(Integer id) {
        return participantDao.findOne(id);
    }

    public void save(Participant participant) {
        participantDao.save(participant);
    }

    public void delete(Integer id) {
        participantDao.delete(id);
    }
}
