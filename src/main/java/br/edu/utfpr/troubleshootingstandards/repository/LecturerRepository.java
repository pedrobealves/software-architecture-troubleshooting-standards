package br.edu.utfpr.repository;

import br.edu.utfpr.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    Lecturer findLecturerBy(String code);
}
