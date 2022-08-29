package kg.megacom.students1.models.enums;

public enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public int getDayValue(){
        return ordinal()+1;
    }
}

