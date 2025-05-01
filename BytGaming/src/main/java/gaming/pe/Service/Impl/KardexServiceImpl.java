package gaming.pe.Service.Impl;

import gaming.pe.DTO.KardexDTO;
import gaming.pe.Entity.Kardex;
import gaming.pe.Entity.Supplier;
import gaming.pe.Mappers.KardexMapper;
import gaming.pe.Repository.KardexRepository;
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
    private final SupplierRepository supplierRepository;
    private final KardexMapper mapper;



    @Override
    public List<Kardex> findAll() {
        return kardexRepository.findAll();
    }

    @Override
    public Optional<Kardex> FindById(Long id) {
        return kardexRepository.findById(id);
    }

    @Override
    public Kardex create(KardexDTO dto) {
        Supplier supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        Kardex kardex = mapper.toEntity(dto);

        kardex.setSupplier(supplier);

        return kardexRepository.save(kardex);
    }

    @Override
    public Kardex update(Long id, KardexDTO dto) {
        Kardex existing = kardexRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kardex no encontrado con ID: " + id));

        existing.setDateOperation(dto.getDateOperation());
        existing.setExpirationDate(dto.getExpirationDate());
        existing.setCount(dto.getCount());
        existing.setDescription(dto.getDescription());
        existing.setProductName(dto.getProductName());

        Supplier supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + dto.getSupplierId()));
        existing.setSupplier(supplier);

        return kardexRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Kardex kardex = kardexRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kardex no encontrado con ID: " + id));

        kardexRepository.delete(kardex);
    }
}
