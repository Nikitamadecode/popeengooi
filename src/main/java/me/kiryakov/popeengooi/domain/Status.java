package me.kiryakov.popeengooi.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "status")
@SequenceGenerator(name = "StatusSequenceGenerator", sequenceName = "status_seq", allocationSize = 1)
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StatusSequenceGenerator")
    @Column(name = "id")
    private Long id;
    @Column(name = "check_time")
    private LocalDateTime checkTime;
    @Column(name = "status")
    private StatusEnum statusEnum;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;


}
