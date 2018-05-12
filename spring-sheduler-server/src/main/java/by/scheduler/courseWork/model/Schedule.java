package by.scheduler.courseWork.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "view")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "start_time")
    @NotEmpty
    private String startTime;

    @Column(name = "end_time")
    @NotEmpty
    private String endTime;

    @Column(name = "subject_name")
    @NotEmpty
    private String subjectName;

    @Column(name = "number")
    @NotEmpty
    private String number;

    @Column(name = "group_name")
    @NotEmpty
    private String groupName;

    public Schedule() {
    }

    public String getName(){
        return name;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime(){
        return endTime;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
