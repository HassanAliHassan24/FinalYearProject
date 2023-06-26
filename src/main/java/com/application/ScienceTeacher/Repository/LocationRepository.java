package com.application.ScienceTeacher.Repository;

import com.application.ScienceTeacher.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
