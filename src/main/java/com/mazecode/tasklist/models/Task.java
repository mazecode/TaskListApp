package com.mazecode.tasklist.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * Class Task
 *
 * @author Diego Feliú <diego.feliud@gmail.com> @DFELIU
 */
@Entity
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "tasks")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Task ID", name = "id", required = true, value = "1L", dataType = "Long")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Task Title", name = "title", required = true, value = "First Task Title")
    private String title;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Task Description", name = "description", required = true, value = "This is an example of task description")
    private String description;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Task State", name = "state", required = true, value = "PENDING")
    private TaskState state;

    @CreationTimestamp
    @DateTimeFormat
    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @ApiModelProperty(notes = "Task Created date of", name = "created_at", value = "2021-07-03T12:43:02.985+00:00")
    private Date createdAt;

    @UpdateTimestamp
    @DateTimeFormat
    @Column(name = "updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @ApiModelProperty(notes = "Task Updated date of", name = "updated_at", value = "2021-07-03T12:43:02.985+00:00")
    private Date updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Task task = (Task) o;

        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return 1976597858;
    }
}
