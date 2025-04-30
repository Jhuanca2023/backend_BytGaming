package gaming.pe.Mappers;

import gaming.pe.DTO.ProductCreateDTO;
import gaming.pe.Entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductCreateDTO toDto(Product product);

    Product toEntity(ProductCreateDTO productCreateDTO);

    void updateFromDto(ProductCreateDTO dto, @MappingTarget Product entity);
}
