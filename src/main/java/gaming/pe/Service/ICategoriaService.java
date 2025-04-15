package gaming.pe.Service;


import gaming.pe.DTO.CategoriaDTO;
import gaming.pe.Entity.Categorias;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    List<CategoriaDTO> listar();
    Optional<CategoriaDTO> listarPorId(Integer id);
    CategoriaDTO crear(CategoriaDTO categoriaDTO);
    CategoriaDTO editar(CategoriaDTO categoriaDTO);
    void eliminar(Integer id);
}
