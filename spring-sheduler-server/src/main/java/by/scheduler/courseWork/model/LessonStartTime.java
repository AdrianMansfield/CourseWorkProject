package by.scheduler.courseWork.model;

public enum LessonStartTime {
    FIRST("8:20"), SECOND("10:10"), THIRD("12:05"), FOURTH("14:10");

    private final String startTime;

    LessonStartTime(String startTime) {
        this.startTime = startTime;
    }

    public static LessonStartTime fromString(String startTime) {
        for (LessonStartTime lessonStartTime : LessonStartTime.values()){
            if (lessonStartTime.startTime.equals(startTime)){
                return lessonStartTime;
            }
        }
        return LessonStartTime.valueOf(startTime);
    }
}
