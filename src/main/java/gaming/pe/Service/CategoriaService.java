package gaming.pe.Service;

import gaming.pe.DTO.CategoriaDTO;
import gaming.pe.Entity.Categorias;
import gaming.pe.Mappers.CategoriaMapper;
import gaming.pe.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoriaService implements ICategoriaService{

    private final CategoryRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaDTO> listar() {
        List<Categorias> categorias = categoriaRepository.findAll();
        return categoriaMapper.toDtoList(categorias);
    }

    @Override
    public Optional<CategoriaDTO> listarPorId(Integer id) {
        return categoriaRepository.findById(id)
                .map(categoriaMapper::toDto);
    }

    @Override
    public CategoriaDTO crear(CategoriaDTO categoriaDTO) {
        // Convertir de DTO a entidad
        Categorias entidad = categoriaMapper.toEntity(categoriaDTO);
        Categorias guardada = categoriaRepository.save(entidad);
        return categoriaMapper.toDto(guardada);
    }

    @Override
    public CategoriaDTO editar(CategoriaDTO categoriaDTO) {
        Categorias entidad = categoriaMapper.toEntity(categoriaDTO);
        Categorias editada = categoriaRepository.save(entidad);
        return categoriaMapper.toDto(editada);
    }

    @Override
    public void eliminar(Integer id) {
        categoriaRepository.deleteById(id);
    }
}