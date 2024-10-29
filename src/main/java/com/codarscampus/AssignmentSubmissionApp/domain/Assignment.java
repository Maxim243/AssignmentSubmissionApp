package com.codarscampus.AssignmentSubmissionApp.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "assignment")
public class Assignment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String gitHubUrl;
    private String branch;
    private String codeReviewVideoUrl;
    @ManyToOne(optional = false)
    private User user;
}
