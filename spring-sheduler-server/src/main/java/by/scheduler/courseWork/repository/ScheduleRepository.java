package by.scheduler.courseWork.repository;

import by.scheduler.courseWork.model.Schedule;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ScheduleRepository {
    List<Schedule> findByGroup(String groupName);

    Map<String, Map<String, Map<String, List<Schedule>>>> showAll();


}
