package institution_mgmt.institution_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_INSTITUTION_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_INSTITUTION_MASTER")
public class LMSInstitutionMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "INSTITUTION_SEQ_NO")
	private Long institutionSeqNo;

	@Column(name = "LOCATION_SEQ_NO")
	private Long locationSeqNo;

	@Column(name = "STATUS_SEQ_NO")
	private Long statusSeqNo;

	@Column(name = "INSTITUTION")
	private String institution;

	public LMSInstitutionMaster() {
	}

	public Long getInstitutionSeqNo() {
		return institutionSeqNo;
	}

	public void setInstitutionSeqNo(Long institutionSeqNo) {
		this.institutionSeqNo = institutionSeqNo;
	}

	public Long getLocationSeqNo() {
		return locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public Long getStatusSeqNo() {
		return statusSeqNo;
	}

	public void setStatusSeqNo(Long statusSeqNo) {
		this.statusSeqNo = statusSeqNo;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((institution == null) ? 0 : institution.hashCode());
		result = prime * result + ((institutionSeqNo == null) ? 0 : institutionSeqNo.hashCode());
		result = prime * result + ((locationSeqNo == null) ? 0 : locationSeqNo.hashCode());
		result = prime * result + ((statusSeqNo == null) ? 0 : statusSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LMSInstitutionMaster other = (LMSInstitutionMaster) obj;
		if (institution == null) {
			if (other.institution != null)
				return false;
		} else if (!institution.equals(other.institution))
			return false;
		if (institutionSeqNo == null) {
			if (other.institutionSeqNo != null)
				return false;
		} else if (!institutionSeqNo.equals(other.institutionSeqNo))
			return false;
		if (locationSeqNo == null) {
			if (other.locationSeqNo != null)
				return false;
		} else if (!locationSeqNo.equals(other.locationSeqNo))
			return false;
		if (statusSeqNo == null) {
			if (other.statusSeqNo != null)
				return false;
		} else if (!statusSeqNo.equals(other.statusSeqNo))
			return false;
		return true;
	}

	public LMSInstitutionMaster(Long institutionSeqNo, Long locationSeqNo, Long statusSeqNo, String institution) {
		super();
		this.institutionSeqNo = institutionSeqNo;
		this.locationSeqNo = locationSeqNo;
		this.statusSeqNo = statusSeqNo;
		this.institution = institution;
	}

}