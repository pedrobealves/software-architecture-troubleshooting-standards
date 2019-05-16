package br.edu.utfpr.troubleshootingstandards.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentPresence implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Student student;

    private boolean presence;

}