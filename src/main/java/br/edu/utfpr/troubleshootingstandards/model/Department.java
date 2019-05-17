package br.edu.utfpr.troubleshootingstandards.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
