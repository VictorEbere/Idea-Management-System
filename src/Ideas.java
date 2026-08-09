import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.Date;

public class Ideas {
    private LocalDateTime date;
    private String title;
    private String priorityLevel;
    private String description;

    public Ideas(LocalDateTime date, String title, String priorityLevel, String description) {
        this.date = date;
        this.title = title;
        this.priorityLevel = priorityLevel;
        this.description = description;
    }

    public String getDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'Time:' hh:mm:ss");

        return date.format(formatter);
    }

    public void setDate(LocalDateTime date) { this.date = date; }

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
