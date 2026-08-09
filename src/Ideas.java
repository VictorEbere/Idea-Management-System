import java.time.LocalDate;
//import java.util.Date;

public class Ideas {
    private LocalDate date;
    private String title;
    private String priorityLevel;
    private String description;

    public Ideas(LocalDate date, String title, String priorityLevel, String description) {
        this.date = date;
        this.title = title;
        this.priorityLevel = priorityLevel;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) { this.date = date; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriorityLevel() { return priorityLevel; }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description; }

}
