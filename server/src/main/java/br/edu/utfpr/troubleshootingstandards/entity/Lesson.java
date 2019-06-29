package br.edu.utfpr.troubleshootingstandards.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Lesson implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ClassCourse classCourse;

    @ElementCollection
    private Set<String> type;

    @OneToOne
    private AttendanceStudent attendanceStudent;

    private String content;

    @Column(name="number_classes")
    private int numberClasses;

    @Temporal(TemporalType.DATE)
    private Date date;

}
