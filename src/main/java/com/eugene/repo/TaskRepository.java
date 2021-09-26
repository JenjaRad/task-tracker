package com.eugene.repo;

import com.eugene.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUserId(Long Id);

    List<Task> findAllByUserUsername(String username);
}
