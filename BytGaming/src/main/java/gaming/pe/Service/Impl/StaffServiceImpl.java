package gaming.pe.Service.Impl;

import gaming.pe.Entity.Staff;
import gaming.pe.Repository.StaffRepository;
import gaming.pe.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff update(Long id, Staff staff) {
        if (staffRepository.existsById(id)) {
            staff.setId(id);
            return staffRepository.save(staff);
        }
        return null; // O lanzar una excepción, dependiendo del caso
    }

    @Override
    public void delete(Long id) {
        if (staffRepository.existsById(id)) {
            staffRepository.deleteById(id);
        }
    }
}
