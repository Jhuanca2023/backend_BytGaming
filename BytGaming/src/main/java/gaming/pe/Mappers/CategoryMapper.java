package gaming.pe.Mappers;

import gaming.pe.DTO.CategoryDTO;
import gaming.pe.Entity.Category;
import gaming.pe.config.CommonMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDto(Category category);
    Category toEntity(CategoryDTO category);

    void updateFromDto(CategoryDTO dto, @MappingTarget Category entity);
}
