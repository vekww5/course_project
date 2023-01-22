package rsatu.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @SequenceGenerator(name = "scheduleSeq", sequenceName = "schedule_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "scheduleSeq")
    private Long id_schedule;
    private Long id_place;
    private Long id_section;
    private Long id_header_schedule;
    private Date date;
    private Time time_start;
    private Time time_end;
    private Boolean cancell;
    private String note;

    //

    public Long getId_schedule() {
        return id_schedule;
    }

    public Long getId_place() {
        return id_place;
    }

    public void setId_place(Long id_place) {
        this.id_place = id_place;
    }

    public Long getId_section() {
        return id_section;
    }

    public void setId_section(Long id_section) {
        this.id_section = id_section;
    }

    public Long getId_header_schedule() {
        return id_header_schedule;
    }

    public void setId_header_schedule(Long id_header_schedule) {
        this.id_header_schedule = id_header_schedule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime_start() {
        return time_start;
    }

    public void setTime_start(Time time_start) {
        this.time_start = time_start;
    }

    public Time getTime_end() {
        return time_end;
    }

    public void setTime_end(Time time_end) {
        this.time_end = time_end;
    }

    public Boolean getCancell() {
        return cancell;
    }

    public void setCancell(Boolean cancell) {
        this.cancell = cancell;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Schedule() {
    }

}
