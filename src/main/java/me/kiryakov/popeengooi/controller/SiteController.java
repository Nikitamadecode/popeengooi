package me.kiryakov.popeengooi.controller;

import me.kiryakov.popeengooi.dto.SiteDTO;
import me.kiryakov.popeengooi.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sites")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @PostMapping
    public SiteDTO createSite(@RequestBody SiteDTO siteDTO) {
        return siteService.createSite(siteDTO);
    }

    @PutMapping(path = "/{siteId}")
    public SiteDTO updateSite(@PathVariable Long siteId, @RequestBody SiteDTO siteDTO) {
        return siteService.updateSite(siteId, siteDTO);
    }

    @DeleteMapping(path = "/{siteId")
    public void deleteSite(@PathVariable Long siteId) {
        siteService.deleteSite(siteId);
    }

}
