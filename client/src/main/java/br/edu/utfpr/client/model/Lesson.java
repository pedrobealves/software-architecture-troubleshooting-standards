package br.edu.utfpr.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lesson implements Serializable {

    private Long id;
    private ClassCourse classCourse;
    private Set<String> type;
    private AttendanceStudent attendanceStudent;
    private String content;
    private int numberClasses;
    private String date;
}