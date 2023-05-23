package batch_mgmt.batch_student_details.model.details;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LMS_BATCH_DETAILS database table.
 * 
 */
@Entity
@Table(name="LMS_BATCH_DETAILS")
public class LMSBatchDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSBatchDetailsPK id;

	public LMSBatchDetails() {
	}

	public LMSBatchDetailsPK getId() {
		return this.id;
	}

	public void setId(LMSBatchDetailsPK id) {
		this.id = id;
	}

}