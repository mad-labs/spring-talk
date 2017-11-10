package it.madlabs.springtalk.model.entities;

public class Greeting {

    public static final String TABLE_NAME = "GREETINGS";

    private String type;
    private String period;
    private String format;

    public Greeting() {
    }

    public Greeting(String type, String dayPart, String format) {
        this.type = type;
        this.period = dayPart;
        this.format = format;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Greeting that = (Greeting) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (period != null ? !period.equals(that.period) : that.period != null) return false;
        return format != null ? format.equals(that.format) : that.format == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (period != null ? period.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "type='" + type + '\'' +
                ", period='" + period + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
