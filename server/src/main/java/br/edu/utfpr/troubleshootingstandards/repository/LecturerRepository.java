package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {}
