package com.portifoliodharan.dharanportifolio.models;

import com.portifoliodharan.dharanportifolio.enums.StatusEmail;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="db_email")
public class EmailModel implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emailId;
    private String ownerRef;
    private final String emailFrom = "dharis.contato@gmail.com";
    private String emailTo = "dharancosta@gmail.com";
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

}
