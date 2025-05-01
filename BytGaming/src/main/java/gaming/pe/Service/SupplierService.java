package gaming.pe.Service;

import gaming.pe.DTO.SupplierDTO;
import gaming.pe.Entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<Supplier> findAll();

    Supplier findById(Long id);

    SupplierDTO save(SupplierDTO supplierDTO);

    Supplier update(Long id, Supplier supplier);

    void delete(Long id);
}
