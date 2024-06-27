package me.kiryakov.popeengooi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sites")
@SequenceGenerator(name = "SiteSequenceGen", sequenceName = "site_seq", allocationSize = 1)

public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SiteSequenceGen")
    private Long id;
    @Column(name = "check_url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "site")
    private List<Status> statusList = new ArrayList<>();



}
