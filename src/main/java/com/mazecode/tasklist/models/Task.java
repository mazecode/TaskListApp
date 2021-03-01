package com.mazecode.tasklist.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Class Task
 *
 * @author Diego Feliú <dfeliu@siga98.net> @DFELIU
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
@Data
@Table(name = "tasks")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	@Builder.Default
	@Column(name = "is_done", nullable = false)
	private boolean isDone = false;
	@Builder.Default
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	@Column(name = "created_at", nullable = false)
	private Date createdAt = new Date();
	@Builder.Default
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	@Column(name = "updated_at")
	@Nullable
	private Date updatedAt = null;
}
