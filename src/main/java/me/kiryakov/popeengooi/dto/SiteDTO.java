package me.kiryakov.popeengooi.dto;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteDTO {
    private Long id;
    private String url;
}
