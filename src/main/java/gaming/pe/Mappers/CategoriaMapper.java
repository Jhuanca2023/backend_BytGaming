package gaming.pe.Mappers;

import gaming.pe.DTO.CategoriaDTO;
import gaming.pe.Entity.Categorias;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaDTO toDto(Categorias categoria);
    Categorias toEntity(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> toDtoList(List<Categorias> categorias);
}
