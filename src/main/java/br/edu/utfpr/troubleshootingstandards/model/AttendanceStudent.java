package br.edu.utfpr.troubleshootingstandards.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import java.io.Serializable;

import lombok.AllArgsConstructor; // acho que simplesmente escrever lombok.* seria bom pra reduzir linha de código com importação
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceStudent implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy="attendanceStudent", orphanRemoval = true)
    private Set<Attendance> attendance;

    private String note;

    @CreatedDate
    private Date createdAt;

}
