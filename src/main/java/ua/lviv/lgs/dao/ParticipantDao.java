package ua.lviv.lgs.dao;

import org.springframework.stereotype.Repository;
import ua.lviv.lgs.domain.Participant;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ParticipantDao {
    private List<Participant> participantList = new ArrayList<>();

    @PostConstruct
    public void init() {
        Participant participant = new Participant();
        participant.setId(1);
        participant.setName("Marian");
        participant.setEmail("kuziv@gmail.com");
        participant.setLevel(1);
        participant.setPrimarySkill("Luck");
        Participant participant1 = new Participant();
        participant1.setId(2);
        participant1.setName("Max");
        participant1.setEmail("max@gmail.com");
        participant1.setLevel(2);
        participant1.setPrimarySkill("Luck");
        Participant participant2 = new Participant();
        participant2.setId(3);
        participant2.setName("Svitlana");
        participant2.setEmail("svitlana@gmail.com");
        participant2.setLevel(5);
        participant2.setPrimarySkill("Luck");
        participantList.add(participant);
        participantList.add(participant1);
        participantList.add(participant2);
    }

    public List<Participant> findAllParticipants() {
        return participantList;
    }

    public Participant findOne(int id) {
        return participantList.stream().filter(participant -> participant.getId() == id).reduce((a, b) -> {
            throw new IllegalStateException("Multiple elements:" + a + ", " + b);
        }).get();
    }

    public void save(Participant participant) {
        Participant participantToUpdate = null;
        if (participant.getId() != null) {
            participantToUpdate = findOne(participant.getId());
            int participantIndex = participantList.indexOf(participantToUpdate);
            participantToUpdate.setEmail(participant.getEmail());
            participantToUpdate.setName(participant.getName());
            participantToUpdate.setLevel(participant.getLevel());
            participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
            participantList.set(participantIndex, participantToUpdate);
        } else {
            participant.setId(participantList.size()+1);
            participantList.add(participant);
        }
    }

    public void delete(int id) {
        Iterator<Participant> iter = participantList.iterator();
        while (iter.hasNext()) {
            if (iter.next().getId() == id) {
                iter.remove();
            }
        }
    }
}
