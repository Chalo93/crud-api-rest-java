package com.gonzalo.apirest.apirest.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gonzalo.apirest.apirest.Entities.Usuario;
import com.gonzalo.apirest.apirest.Repositories.UsuarioRepository;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getAllUsuario(){
        return usuarioRepository.findAll();
    }

    @GetMapping ("/{id}")
    public Usuario usuarioPorId(@PathVariable Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro por "+id));
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);

    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario detallesUsuario){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro por "+id));
        usuario.setDocumento(detallesUsuario.getDocumento());
        usuario.setNombre(detallesUsuario.getNombre());
        usuario.setApellido(detallesUsuario.getApellido());
        usuario.setEmail(detallesUsuario.getEmail());
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public String borrarUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro por "+id));
        usuarioRepository.delete(usuario);
        return "El usuario "+usuario.getNombre()+" "+usuario.getApellido()+" con id "+id+" fue eliminado";
    }

}
