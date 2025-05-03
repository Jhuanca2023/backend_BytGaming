package gaming.pe.Service.Impl;

import gaming.pe.DTO.KardexDTO;
import gaming.pe.Entity.Kardex;
import gaming.pe.Entity.Product;
import gaming.pe.Entity.Staff;
import gaming.pe.Entity.Supplier;
import gaming.pe.Mappers.KardexMapper;
import gaming.pe.Repository.KardexRepository;
import gaming.pe.Repository.ProductRepository;
import gaming.pe.Repository.StaffRepository;
import gaming.pe.Repository.SupplierRepository;
import gaming.pe.Service.IKardexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KardexServiceImpl implements IKardexService {

    private final KardexRepository kardexRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final StaffRepository staffRepository;
    private final KardexMapper kardexMapper;



    @Override
    public List<Kardex> findAll() {
        return kardexRepository.findAll();
    }

    @Override
    public Optional<Kardex> FindById(Long id) {
        return kardexRepository.findById(id);
    }

    @Override
    public KardexDTO create(KardexDTO dto) {
        Kardex kardex = kardexMapper.toEntity(dto);
        kardex.setProduct(getProductById(dto.getProductId()));
        kardex.setProvider(getSupplierById(dto.getSupplierId()));
        kardex.setStaff(getStaffById(dto.getStaffId()));

        Kardex saved = kardexRepository.save(kardex);
        return kardexMapper.toDto(saved);
    }


    @Override
    public KardexDTO update(Long id, KardexDTO dto) {
        Kardex existing = kardexRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kardex no encontrado"));

        // Actualizar campos desde el DTO
        kardexMapper.updateFromDto(dto, existing);

        // Actualizar relaciones
        existing.setProduct(getProductById(dto.getProductId()));
        existing.setProvider(getSupplierById(dto.getSupplierId()));
        existing.setStaff(getStaffById(dto.getStaffId()));

        Kardex updated = kardexRepository.save(existing);
        return kardexMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        Kardex kardex = kardexRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kardex no encontrado con ID: " + id));

        kardexRepository.delete(kardex);
    }
    private Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    private Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    private Staff getStaffById(Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff no encontrado"));
    }
}
