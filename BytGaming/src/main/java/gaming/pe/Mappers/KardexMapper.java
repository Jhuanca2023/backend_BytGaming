package gaming.pe.Mappers;


import gaming.pe.DTO.KardexDTO;
import gaming.pe.Entity.Kardex;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface KardexMapper {
    KardexDTO toDto(Kardex category);
    Kardex toEntity(KardexDTO category);

    void updateFromDto(KardexDTO dto, @MappingTarget Kardex entity);
}
