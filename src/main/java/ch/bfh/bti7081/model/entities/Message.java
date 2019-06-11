package ch.bfh.bti7081.model.entities;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Objects;

/**
 * @author gian.demarmels@students.bf.ch
 * @author yannis.schmutz@students.bf.ch
 */
public class Message implements IEntity {

    private ObjectId id;
    private String content;
    private ObjectId fromDoctorId;
    private ObjectId reportId;
    private Date sentDate;

    public Message(String content, ObjectId fromDoctorId, ObjectId reportId, Date sentDate) {
        this.content = content;
        this.fromDoctorId = fromDoctorId;
        this.reportId = reportId;
        this.sentDate = new Date(sentDate.getTime());
    }

    public Message(){

    }

    public ObjectId getReportId() {
        return reportId;
    }

    public void setReportId(ObjectId reportId) {
        this.reportId = reportId;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ObjectId getFromDoctorId() {
        return fromDoctorId;
    }

    public void setFromDoctorId(ObjectId fromDoctorId) {
        this.fromDoctorId = fromDoctorId;
    }

    public Date getSentDate(){
        return new Date(sentDate.getTime());
    }

    public void setSentDate(Date sentDate){
        this.sentDate = new Date(sentDate.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(content, message.content) &&
                Objects.equals(fromDoctorId, message.fromDoctorId) &&
                Objects.equals(reportId, message.reportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, fromDoctorId, reportId);
    }

    @Override
    public String toString(){
        return String.format("Message('%s', doc=%s, report=%s", content, fromDoctorId, reportId);
    }
}
