package br.edu.utfpr.troubleshootingstandards.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// acho que simplesmente escrever persistence.* seria bom pra reduzir linha de código com importação
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CoordinatorCourse implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
