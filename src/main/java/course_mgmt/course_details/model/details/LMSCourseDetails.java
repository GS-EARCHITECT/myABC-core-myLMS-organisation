package course_mgmt.course_details.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SALES_MASTER database table.
 * 
 */
@Entity
@Table(name="LMS_COURSE_DETAILS")
public class LMSCourseDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSCourseDetailsPK id;
	
	public LMSCourseDetailsPK getId() {
		return id;
	}

	public void setId(LMSCourseDetailsPK id) {
		this.id = id;
	}

	public LMSCourseDetails(LMSCourseDetailsPK id) {
		super();
		this.id = id;
	}

	public LMSCourseDetails() {
		super();
	}

}