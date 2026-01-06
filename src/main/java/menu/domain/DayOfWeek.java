package menu.domain;

public enum DayOfWeek {
    MON("월", 1), TUE("화", 2), WED("수", 3), THU("목", 4), FRI("금", 5);

    private final String korName;
    private final int number;

    DayOfWeek(String korName, int number) {
        this.korName = korName;
        this.number = number;
    }

    public static DayOfWeek getStartOfWeek(){
        return MON;
    }

    public String getKorName() {
        return korName;
    }


    public DayOfWeek getNext() {
        return DayOfWeek.values()[this.number % 5];
    }

}
