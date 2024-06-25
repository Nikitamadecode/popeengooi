package me.kiryakov.popeengooi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CheckSiteDTO {
    private Long siteId;
    private LocalDateTime checkDate;
    private Long duration;
    private String status;
}
