package me.kiryakov.popeengooi.repository;

import me.kiryakov.popeengooi.domain.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
}
