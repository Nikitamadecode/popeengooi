package me.kiryakov.popeengooi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.kiryakov.popeengooi.domain.StatusEnum;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDTO {
    private Long id;
    private LocalDateTime checkDate;
    private StatusEnum statusEnum;
}
