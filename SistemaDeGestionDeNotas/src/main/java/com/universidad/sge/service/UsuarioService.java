package com.universidad.sge.service;

import com.universidad.sge.model.entity.Usuario;
import com.universidad.sge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario login(String username, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(username);
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            
            if (usuario.getPassword().equals(password) && usuario.getActivo()) {
                return usuario;
            }
        }
        
        return null;
    }
    
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public String obtenerDescripcion(Usuario usuario) {
        return usuario.getDescripcionRol();
    }
}