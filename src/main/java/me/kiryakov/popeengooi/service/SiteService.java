package me.kiryakov.popeengooi.service;

import lombok.extern.slf4j.Slf4j;
import me.kiryakov.popeengooi.domain.Site;
import me.kiryakov.popeengooi.dto.CheckSiteDTO;
import me.kiryakov.popeengooi.dto.SiteDTO;
import me.kiryakov.popeengooi.exception.EntityNotFoundException;
import me.kiryakov.popeengooi.repository.SiteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class SiteService {
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RestTemplate restTemplate;

    public CheckSiteDTO checkSite(Site site) {
        log.info("Checking site " + site.getUrl());
        ResponseEntity<String> result = restTemplate.exchange(site.getUrl(), HttpMethod.GET, null, String.class);
        if (result.getStatusCode().is2xxSuccessful()) {
            log.info("successful check " + site.getUrl() + " - " + result.getStatusCode());
            CheckSiteDTO checkDTO = new CheckSiteDTO(site.getId(), LocalDateTime.now(), 0L, "OK");
            return checkDTO;
        } else {
            log.error("failed check " + site.getUrl() + " - " + result.getStatusCode());
            CheckSiteDTO checkDTO = new CheckSiteDTO(site.getId(), LocalDateTime.now(), 0L, "ERROR");
            return checkDTO;
        }
    }

    public SiteDTO createSite (SiteDTO siteDTO) {
        Site site = modelMapper.map(siteDTO, Site.class);
        site = siteRepository.save(site);
        return modelMapper.map(site, SiteDTO.class);
    }

    public SiteDTO updateSite (Long siteId, SiteDTO siteDTO) {
        Site site = siteRepository.findById(siteDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Site not found"));
        modelMapper.map(siteDTO, site);
        site = siteRepository.save(site);
        return modelMapper.map(site, SiteDTO.class);
    }

    public void deleteSite (Long id) {
        Site site = siteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Site not found"));
        siteRepository.delete(site);
    }
}
