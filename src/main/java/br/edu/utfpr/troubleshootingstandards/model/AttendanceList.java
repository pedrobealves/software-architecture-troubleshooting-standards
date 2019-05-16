package br.edu.utfpr.troubleshootingstandards.model;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.edu.utfpr.troubleshootingstandards.dto.StudentPresenceDTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceList implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    private Set<StudentPresenceDTO> studentsList;

}