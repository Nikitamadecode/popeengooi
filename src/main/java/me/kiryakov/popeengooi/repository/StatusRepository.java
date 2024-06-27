package me.kiryakov.popeengooi.repository;

import me.kiryakov.popeengooi.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.JavaBean;
import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    List<Status> findAllBySiteId(Long siteId);

}
