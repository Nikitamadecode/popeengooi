package me.kiryakov.popeengooi.scheduler;

import me.kiryakov.popeengooi.domain.Site;
import me.kiryakov.popeengooi.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CheckSiteScheduler {

    @Autowired
    private SiteService siteService;

    @Scheduled(cron = "*/10 * * * * *")
    public void scheduleCheckSite() {
        Site site = new Site();
        site.setId(1L);
        site.setUrl("https://moneza.ru/status/ping");
        siteService.checkSite(site);
    }
}
