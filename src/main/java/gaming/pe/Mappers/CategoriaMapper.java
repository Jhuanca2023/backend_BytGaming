package gaming.pe.Mappers;

import gaming.pe.DTO.CategoriaDTO;
import gaming.pe.Entity.Category;
import gaming.pe.config.CommonMapperConfig;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = CommonMapperConfig.class)
public interface CategoriaMapper {
    CategoriaDTO toDto(Category category);
    Category toEntity(CategoriaDTO category);

    List<CategoriaDTO> toDtoList(List<Category> category);
}
