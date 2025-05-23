package com.bananahrm.hrms.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="performance_reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class PerformanceReview {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    Long employee_id;

    Long byEmployee_id;

    Date reviewDate;

    int score;

    String comment;
}
