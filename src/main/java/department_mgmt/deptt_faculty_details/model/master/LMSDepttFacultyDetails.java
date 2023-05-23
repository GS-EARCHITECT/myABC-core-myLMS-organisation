package department_mgmt.deptt_faculty_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_DEPTT_FACULTY_DETAILS database table.
 * 
 */
@Entity
@Table(name = "LMS_DEPTT_FACULTY_DETAILS")
public class LMSDepttFacultyDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSDepttFacultyDetailsPK id;

	public LMSDepttFacultyDetails() {
	}

	public LMSDepttFacultyDetailsPK getId() {
		return this.id;
	}

	public void setId(LMSDepttFacultyDetailsPK id) {
		this.id = id;
	}

	public LMSDepttFacultyDetails(LMSDepttFacultyDetailsPK id) {
		super();
		this.id = id;
	}

}