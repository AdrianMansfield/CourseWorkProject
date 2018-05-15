package by.scheduler.courseWork.controllers;


import by.scheduler.courseWork.model.Schedule;
import by.scheduler.courseWork.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "demo", produces = "application/json;charset=UTF-8")
public class MainController {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public MainController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public  Map<String, Map<String, Map<String, List<Schedule>>>> getAllUsers() {
        return scheduleRepository.showAll();
    }


}
