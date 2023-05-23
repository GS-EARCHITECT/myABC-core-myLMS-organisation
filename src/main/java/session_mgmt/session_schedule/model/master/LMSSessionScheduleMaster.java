package session_mgmt.session_schedule.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LMS_SESSION_SCHEDULE_MASTER database table.
 * 
 */
@Entity
@Table(name="LMS_SESSION_SCHEDULE_MASTER")
public class LMSSessionScheduleMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSSessionScheduleMasterPK id;
	
	@Column(name="FR_DTTM")
	private String frDttm;

	@Column(name="TO_DTTM")
	private String toDttm;

	public LMSSessionScheduleMaster() {
	}

	public LMSSessionScheduleMasterPK getId() {
		return id;
	}

	public void setId(LMSSessionScheduleMasterPK id) {
		this.id = id;
	}

	public String getFrDttm() {
		return frDttm;
	}

	public void setFrDttm(String frDttm) {
		this.frDttm = frDttm;
	}

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public LMSSessionScheduleMaster(LMSSessionScheduleMasterPK id, String frDttm, String toDttm) {
		super();
		this.id = id;
		this.frDttm = frDttm;
		this.toDttm = toDttm;
	}


	
}