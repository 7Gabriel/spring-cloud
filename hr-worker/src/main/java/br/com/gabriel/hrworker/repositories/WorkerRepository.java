package br.com.gabriel.hrworker.repositories;

import br.com.gabriel.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
