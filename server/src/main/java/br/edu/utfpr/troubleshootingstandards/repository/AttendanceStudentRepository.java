package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.entity.AttendanceStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceStudentRepository extends JpaRepository<AttendanceStudent, Long> {}
