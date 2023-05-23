package course_mgmt.course_details.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import course_mgmt.course_details.model.details.LMSCourseDetails;
import course_mgmt.course_details.model.details.LMSCourseDetailsPK;
import course_mgmt.course_details.model.dto.LMSCourseDetailsDTO;
import course_mgmt.course_details.model.repo.LMSCourseDetailsRepo;

@Service("subjectMediaDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSCourseDetailsService implements I_LMSCourseDetailsService {

	@Autowired
	private LMSCourseDetailsRepo subjectMediaDetailsRepo;

	public LMSCourseDetailsDTO newLMSCourseDetails(LMSCourseDetailsDTO lMasters) 
	{
		LMSCourseDetailsPK lmsCourseDetailsPK = new LMSCourseDetailsPK();
		lmsCourseDetailsPK.setCourse_seq_no(lMasters.getCourseSeqNo());
		lmsCourseDetailsPK.setSubject_Seq_no(lMasters.getSubjectSeqNo());
		LMSCourseDetails lmsCourseDetails = null;
		LMSCourseDetailsDTO lmsCourseDetailsDTO=null;
		
		if(!subjectMediaDetailsRepo.existsById(lmsCourseDetailsPK))
		{	
		lmsCourseDetails = setLMSCourseDetails(lMasters);
		lmsCourseDetails.setId(lmsCourseDetailsPK);
		lmsCourseDetailsDTO = getLMSCourseDetailsDTO(subjectMediaDetailsRepo.save(lmsCourseDetails));		
		}
		return lmsCourseDetailsDTO;
	}

	public ArrayList<LMSCourseDetailsDTO> getAllCourseDetails() {
		ArrayList<LMSCourseDetails> subjectList = (ArrayList<LMSCourseDetails>) subjectMediaDetailsRepo.findAll();
		ArrayList<LMSCourseDetailsDTO> lMasterss = new ArrayList<LMSCourseDetailsDTO>();
		lMasterss = subjectList != null ? this.getLMSCourseDetailsDTOs(subjectList) : null;
		return lMasterss;
	}

	public ArrayList<LMSCourseDetailsDTO> getSelectSubjectsByCourse(ArrayList<Long> ids)
	{
		ArrayList<LMSCourseDetails> lMasters = subjectMediaDetailsRepo.getSelectSubjectsByCourse(ids);
		ArrayList<LMSCourseDetailsDTO> LMSCourseDetailsDTOs = new ArrayList<LMSCourseDetailsDTO>();
		
		if (lMasters != null) 
		{
		LMSCourseDetailsDTOs = getLMSCourseDetailsDTOs(lMasters);			
		}
		return LMSCourseDetailsDTOs;
	}
	
	public ArrayList<LMSCourseDetailsDTO> getSelectCoursesBySubject(ArrayList<Long> ids)
	{
		ArrayList<LMSCourseDetails> lMasters = subjectMediaDetailsRepo.getSelectCoursesBySubject(ids);
		ArrayList<LMSCourseDetailsDTO> LMSCourseDetailsDTOs = new ArrayList<LMSCourseDetailsDTO>();
		
		if (lMasters != null) 
		{
		LMSCourseDetailsDTOs = getLMSCourseDetailsDTOs(lMasters);			
		}
		return LMSCourseDetailsDTOs;
	}
	
	public void updLMSCourseDetails(LMSCourseDetailsDTO lMaster) 
	{
		LMSCourseDetailsPK lmsCourseDetailsPK = new LMSCourseDetailsPK();
		lmsCourseDetailsPK.setCourse_seq_no(lMaster.getCourseSeqNo());
		lmsCourseDetailsPK.setSubject_Seq_no(lMaster.getSubjectSeqNo());
		LMSCourseDetails lmsCourseDetails = null;
		LMSCourseDetailsDTO lmsCourseDetailsDTO=null;
		
		if (subjectMediaDetailsRepo.existsById(lmsCourseDetailsPK)) 
		{
			lmsCourseDetails = setLMSCourseDetails(lMaster);
			lmsCourseDetails.setId(lmsCourseDetailsPK);			
			subjectMediaDetailsRepo.save(lmsCourseDetails);
		}
		return;
	}

	public void delSelectLMSCourses(ArrayList<Long> DocumentSeqNos)
	{
		subjectMediaDetailsRepo.delSelectLMSCourse(DocumentSeqNos);
		return;
	}

	
	public void delAllCourses() {
		subjectMediaDetailsRepo.deleteAll();
	}

	
	private ArrayList<LMSCourseDetailsDTO> getLMSCourseDetailsDTOs(ArrayList<LMSCourseDetails> lMasters) {
		LMSCourseDetailsDTO lDTO = null;
		ArrayList<LMSCourseDetailsDTO> lMasterDTOs = new ArrayList<LMSCourseDetailsDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSCourseDetailsDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSCourseDetailsDTO getLMSCourseDetailsDTO(LMSCourseDetails lMaster) {
		LMSCourseDetailsDTO lDTO = new LMSCourseDetailsDTO();
		lDTO.setCourseSeqNo(lMaster.getId().getCourse_seq_no());
		lDTO.setSubjectSeqNo(lMaster.getId().getSubject_Seq_no());		
		return lDTO;
	}

	private LMSCourseDetails setLMSCourseDetails(LMSCourseDetailsDTO lDTO) 
	{
		LMSCourseDetails lMaster = new LMSCourseDetails();		
		return lMaster;
	}
}