package department_mgmt.deptt_faculty_details.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import department_mgmt.deptt_faculty_details.model.dto.LMSDepttFacultyDetailsDTO;
import department_mgmt.deptt_faculty_details.model.master.LMSDepttFacultyDetails;
import department_mgmt.deptt_faculty_details.model.master.LMSDepttFacultyDetailsPK;
import department_mgmt.deptt_faculty_details.model.repo.LMSDepttFacultyDetailsRepo;

@Service("depttFacultyDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSDepttFacultyDetailsService implements I_LMSDepttFacultyDetailsService 
{
	private static final Logger logger = LoggerFactory.getLogger(LMSDepttFacultyDetailsService.class);
	
	@Autowired
	private LMSDepttFacultyDetailsRepo depttFacultyDetailsRepo;

	public LMSDepttFacultyDetailsDTO newDepttFacultyDetails(LMSDepttFacultyDetailsDTO lMaster) 
	{
		LMSDepttFacultyDetailsPK lmsdepttFacultyDetailsPK = new LMSDepttFacultyDetailsPK();
		lmsdepttFacultyDetailsPK.setDepttSeqNo(lMaster.getDepttSeqNo());
		lmsdepttFacultyDetailsPK.setFacultySeqNo(lMaster.getFacultySeqNo());		
		LMSDepttFacultyDetails lmsdepttFacultyDetails = null;

		if (!depttFacultyDetailsRepo.existsById(lmsdepttFacultyDetailsPK)) 
		{
			lmsdepttFacultyDetails = this.setDepttFacultyDetails(lMaster);
			lmsdepttFacultyDetails.setId(lmsdepttFacultyDetailsPK);
			lMaster = getDepttFacultyDetailsDTO(depttFacultyDetailsRepo.save(lmsdepttFacultyDetails));
		}

		return lMaster;
	}

	public ArrayList<LMSDepttFacultyDetailsDTO> getAllDepttFacultyDetails() 
	{
		ArrayList<LMSDepttFacultyDetails> depttFacultyDetailsList = (ArrayList<LMSDepttFacultyDetails>) depttFacultyDetailsRepo.findAll();
		ArrayList<LMSDepttFacultyDetailsDTO> lMasters = new ArrayList<LMSDepttFacultyDetailsDTO>();
		lMasters = depttFacultyDetailsList != null ? this.getDepttFacultyDetailsDTOs(depttFacultyDetailsList) : null;
		return lMasters;
	}

	public ArrayList<LMSDepttFacultyDetailsDTO> getSelectFaculties(ArrayList<Long> ids) {
		ArrayList<LMSDepttFacultyDetails> lMasters = depttFacultyDetailsRepo.delSelectLMSFaculties(ids);
		ArrayList<LMSDepttFacultyDetailsDTO> LMSDepttFacultyDetailsDTOs = new ArrayList<LMSDepttFacultyDetailsDTO>();
		LMSDepttFacultyDetailsDTO LMSDepttFacultyDetailsDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSDepttFacultyDetailsDTO = this.getDepttFacultyDetailsDTO(lMasters.get(i));
				LMSDepttFacultyDetailsDTOs.add(LMSDepttFacultyDetailsDTO);
			}
		}
		return LMSDepttFacultyDetailsDTOs;
	}

	public ArrayList<LMSDepttFacultyDetailsDTO> getFacultiesForDeptt(Long id) 
	{
		ArrayList<LMSDepttFacultyDetails> lMasters = depttFacultyDetailsRepo.getFacultiesForDeptt(id);
		ArrayList<LMSDepttFacultyDetailsDTO> LMSDepttFacultyDetailsDTOs = new ArrayList<LMSDepttFacultyDetailsDTO>();
		LMSDepttFacultyDetailsDTO LMSDepttFacultyDetailsDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSDepttFacultyDetailsDTO = this.getDepttFacultyDetailsDTO(lMasters.get(i));
				LMSDepttFacultyDetailsDTOs.add(LMSDepttFacultyDetailsDTO);
			}
		}
		return LMSDepttFacultyDetailsDTOs;
	}

	public ArrayList<LMSDepttFacultyDetailsDTO> getDepttForFaculties(Long id) 
	{
		ArrayList<LMSDepttFacultyDetails> lMasters = depttFacultyDetailsRepo.getDepttForFaculties(id);
		ArrayList<LMSDepttFacultyDetailsDTO> LMSDepttFacultyDetailsDTOs = new ArrayList<LMSDepttFacultyDetailsDTO>();
		LMSDepttFacultyDetailsDTO LMSDepttFacultyDetailsDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSDepttFacultyDetailsDTO = this.getDepttFacultyDetailsDTO(lMasters.get(i));
				LMSDepttFacultyDetailsDTOs.add(LMSDepttFacultyDetailsDTO);
			}
		}
		return LMSDepttFacultyDetailsDTOs;
	}
	
	public void updDepttFacultyDetails(LMSDepttFacultyDetailsDTO lMaster) 
	{
		LMSDepttFacultyDetailsPK lmsdepttFacultyDetailsPK = new LMSDepttFacultyDetailsPK();
		lmsdepttFacultyDetailsPK.setDepttSeqNo(lMaster.getDepttSeqNo());
		lmsdepttFacultyDetailsPK.setFacultySeqNo(lMaster.getFacultySeqNo());		
		LMSDepttFacultyDetails lmsdepttFacultyDetails = null;
		
		if (depttFacultyDetailsRepo.existsById(lmsdepttFacultyDetailsPK)) 
		{
			lmsdepttFacultyDetails = setDepttFacultyDetails(lMaster);
			lmsdepttFacultyDetails.setId(lmsdepttFacultyDetailsPK);
			depttFacultyDetailsRepo.save(lmsdepttFacultyDetails);
		}
		return;
	}

	public void delDepttFacultyDetails(LMSDepttFacultyDetailsDTO lMaster) 
	{
		LMSDepttFacultyDetailsPK lmsdepttFacultyDetailsPK = new LMSDepttFacultyDetailsPK();
		lmsdepttFacultyDetailsPK.setDepttSeqNo(lMaster.getDepttSeqNo());
		lmsdepttFacultyDetailsPK.setFacultySeqNo(lMaster.getFacultySeqNo());
		
		if (depttFacultyDetailsRepo.existsById(lmsdepttFacultyDetailsPK)) {
			depttFacultyDetailsRepo.deleteById(lmsdepttFacultyDetailsPK);
		}
		return;
	}

	public void delSelectDepttFaculties(ArrayList<Long> facultySeqNos) 
	{
		depttFacultyDetailsRepo.delSelectLMSFaculties(facultySeqNos);
		return;
	}

	
	
	public void delAllDepttFaculties() {
		depttFacultyDetailsRepo.deleteAll();
	}

	private ArrayList<LMSDepttFacultyDetailsDTO> getDepttFacultyDetailsDTOs(ArrayList<LMSDepttFacultyDetails> lMasters) {
		LMSDepttFacultyDetailsDTO lDTO = null;
		ArrayList<LMSDepttFacultyDetailsDTO> lMasterDTOs = new ArrayList<LMSDepttFacultyDetailsDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getDepttFacultyDetailsDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSDepttFacultyDetailsDTO getDepttFacultyDetailsDTO(LMSDepttFacultyDetails lMaster) 
	{
		LMSDepttFacultyDetailsDTO lDTO = new LMSDepttFacultyDetailsDTO();
		lDTO.setDepttSeqNo(lMaster.getId().getDepttSeqNo());
		lDTO.setFacultySeqNo(lMaster.getId().getFacultySeqNo());				
		return lDTO;
	}

	private LMSDepttFacultyDetails setDepttFacultyDetails(LMSDepttFacultyDetailsDTO lDTO) 
	{
		LMSDepttFacultyDetails lMaster = new LMSDepttFacultyDetails();
		LMSDepttFacultyDetailsPK lmsdepttFacultyDetailsPK = new LMSDepttFacultyDetailsPK();
		lmsdepttFacultyDetailsPK.setDepttSeqNo(lDTO.getDepttSeqNo());
		lmsdepttFacultyDetailsPK.setFacultySeqNo(lDTO.getFacultySeqNo());		
		lMaster.setId(lmsdepttFacultyDetailsPK);			
		return lMaster;
	}
}