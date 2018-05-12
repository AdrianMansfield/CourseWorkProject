package by.scheduler.courseWork.model;

public enum DayOfWeek {
    MONDAY("понедельник"),TUESDAY("вторник"),WEDNESDAY("среда"),THURSDAY("четверг"),FRIDAY("пятница"),SATURDAY("суббота");

    private final String dayName;

    DayOfWeek(String dayName) {
        this.dayName = dayName;
    }

    public static DayOfWeek fromString(String dayName) {
       for (DayOfWeek dayOfWeek : DayOfWeek.values()){
           if (dayOfWeek.dayName.equals(dayName)){
               return dayOfWeek;
           }
       }
        return DayOfWeek.valueOf(dayName);
    }
}
