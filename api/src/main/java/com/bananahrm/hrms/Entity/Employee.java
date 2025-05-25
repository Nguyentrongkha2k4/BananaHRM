package com.bananahrm.hrms.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    @Column(name="job_title_id")
    Long jobTitleId;

    @Column(name="department_id")
    Long departmentId;

    @Column(name="last_name")
    String lastName;

    @Column(name="first_name")
    String firstName;

    @Past(message="DOB_INVALID")
    Date dob;

    @Email(message="EMAIL_INVALID")
    String email;

    @Size(min=10, max=10, message="NUMBER_ERROR")
    String phone;

    String address;

    @Pattern(regexp="VALID|INVALID", message="STATUS_INVALID")
    String status;
}
