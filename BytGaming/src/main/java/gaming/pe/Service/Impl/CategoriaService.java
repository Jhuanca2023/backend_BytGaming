package gaming.pe.Service.Impl;

import gaming.pe.DTO.CategoriaDTO;
import gaming.pe.Entity.Category;
import gaming.pe.Mappers.CategoriaMapper;
import gaming.pe.Repository.CategoryRepository;
import gaming.pe.Service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoriaService implements ICategoriaService {

    private final CategoryRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaDTO> listar() {
        List<Category> categorias = categoriaRepository.findAll();
        return categoriaMapper.toDtoList(categorias);
    }

    @Override
    public Optional<CategoriaDTO> listarPorId(Long id) {
        return categoriaRepository.findById(id)
                .map(categoriaMapper::toDto);
    }

    @Override
    public CategoriaDTO crear(CategoriaDTO categoriaDTO) {
        // Convertir de DTO a entidad
        Category entidad = categoriaMapper.toEntity(categoriaDTO);
        Category guardada = categoriaRepository.save(entidad);
        return categoriaMapper.toDto(guardada);
    }


    @Override
    public CategoriaDTO editar(CategoriaDTO categoriaDTO) {
        Category entidad = categoriaMapper.toEntity(categoriaDTO);
        Category editada = categoriaRepository.save(entidad);
        return categoriaMapper.toDto(editada);
    }

    @Override
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}