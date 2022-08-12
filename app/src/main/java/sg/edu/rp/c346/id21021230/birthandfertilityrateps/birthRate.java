package sg.edu.rp.c346.id21021230.birthandfertilityrateps;

public class birthRate {
    private String level_1;
    private double value;
    private int year;

    public birthRate(String level_1, double value, int year) {
        this.level_1 = level_1;
        this.value = value;
        this.year = year;
    }

    public String getLevel_1() {
        return level_1;
    }

    public void setLevel_1(String level_1) {
        this.level_1 = level_1;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "\nlevel_1:" + level_1 +
                "\nvalue: " + value +
                "\nyear: " + year;
    }
}
