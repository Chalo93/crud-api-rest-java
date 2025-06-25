package com.gonzalo.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gonzalo.apirest.apirest.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
