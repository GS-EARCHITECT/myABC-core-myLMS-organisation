package course_mgmt.course_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SALES_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_COURSE_MASTER")
public class LMSCourseMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 815837623673728898L;

	@Id
	@Column(name = "COURSE_SEQ_NO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_lms_course_seq_gen")
	@SequenceGenerator(name = "my_lms_course_seq_gen", sequenceName = "LMS_COURSE_SEQ_NO", allocationSize = 1)
	private Long course_seq_no;

	@Column(name = "COURSE")
	private String course;

	@Column(name = "INTERNAL_REF_NO")
	private String internal_refno;

	@Column(name = "INSTITUTION_SEQ_NO")
	private Long instituteSeqNo;

	public Long getCourse_seq_no() {
		return course_seq_no;
	}

	public void setCourse_seq_no(Long course_seq_no) {
		this.course_seq_no = course_seq_no;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getInternal_refno() {
		return internal_refno;
	}

	public void setInternal_refno(String internal_refno) {
		this.internal_refno = internal_refno;
	}

	public Long getInstituteSeqNo() {
		return instituteSeqNo;
	}

	public void setInstituteSeqNo(Long instituteSeqNo) {
		this.instituteSeqNo = instituteSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((course_seq_no == null) ? 0 : course_seq_no.hashCode());
		result = prime * result + ((instituteSeqNo == null) ? 0 : instituteSeqNo.hashCode());
		result = prime * result + ((internal_refno == null) ? 0 : internal_refno.hashCode());
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
		LMSCourseMaster other = (LMSCourseMaster) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (course_seq_no == null) {
			if (other.course_seq_no != null)
				return false;
		} else if (!course_seq_no.equals(other.course_seq_no))
			return false;
		if (instituteSeqNo == null) {
			if (other.instituteSeqNo != null)
				return false;
		} else if (!instituteSeqNo.equals(other.instituteSeqNo))
			return false;
		if (internal_refno == null) {
			if (other.internal_refno != null)
				return false;
		} else if (!internal_refno.equals(other.internal_refno))
			return false;
		return true;
	}

	public LMSCourseMaster(Long course_seq_no, String course, String internal_refno, Long instituteSeqNo) {
		super();
		this.course_seq_no = course_seq_no;
		this.course = course;
		this.internal_refno = internal_refno;
		this.instituteSeqNo = instituteSeqNo;
	}

	public LMSCourseMaster() {
		super();
	}

}