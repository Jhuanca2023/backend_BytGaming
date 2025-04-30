package gaming.pe.Mappers;

import gaming.pe.DTO.SupplierDTO;
import gaming.pe.Entity.Supplier;
import gaming.pe.config.CommonMapperConfig;
import org.mapstruct.Mapper;


@Mapper(config = CommonMapperConfig.class)
public interface SupplierMapper {
    SupplierDTO toDTO(Supplier entity);
    Supplier toEntity(SupplierDTO dto);
}
