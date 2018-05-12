package by.scheduler.courseWork.repository;

import by.scheduler.courseWork.model.DayOfWeek;
import by.scheduler.courseWork.model.Schedule;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;


@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Schedule> findByGroup(String groupName) {
        Query query = this.em.createQuery("SELECT schedule FROM Schedule schedule WHERE schedule.groupName = :groupName");
        query.setParameter("groupName", groupName);
        return query.getResultList();
    }

    private List<Schedule> getDataFromDB() {
        Query query = this.em.createQuery("SELECT schedule FROM Schedule schedule");
        return query.getResultList();
    }
    @Override
    public Map<String, Map<String, List<Schedule>>> showAll() {
        List<Schedule> list = getDataFromDB();
        Map<String, Map<String, List<Schedule>>> map = new TreeMap<>(getComparing());
        for (Schedule schedule : list) {
            map
                    .computeIfAbsent(schedule.getName(), nameOfDay -> new TreeMap<>())
                    .computeIfAbsent(schedule.getGroupName(), groups -> new ArrayList<>())
                    .add(schedule);
        }
        return map;
    }

    private Comparator<String> getComparing() {
        return Comparator.comparing(DayOfWeek::fromString);
    }
}
