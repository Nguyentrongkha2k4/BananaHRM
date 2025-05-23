package com.bananahrm.hrms.Entity;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="attendances")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Attendance {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    Long employee_id;

    @Past(message="DATE_ATTENDANCE_INVALID")
    Date date;

    LocalTime clockIn;

    LocalTime clockOut;
}
