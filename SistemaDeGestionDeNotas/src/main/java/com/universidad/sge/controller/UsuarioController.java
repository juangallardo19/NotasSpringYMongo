package com.universidad.sge.controller;

import com.universidad.sge.dto.LoginRequest;
import com.universidad.sge.model.entity.Usuario;
import com.universidad.sge.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Usuario usuario = usuarioService.login(request.getUsername(), request.getPassword());
        
        if (usuario != null) {
            String descripcion = usuarioService.obtenerDescripcion(usuario);
            
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Login exitoso");
            response.put("usuario", usuario);
            response.put("rolDescripcion", descripcion);
            
            return ResponseEntity.ok(response);
        }
        
        return ResponseEntity.status(401).body("Credenciales incorrectas");
    }
    
    @GetMapping("/perfil/{id}")
    public ResponseEntity<Usuario> obtenerPerfil(@PathVariable String id) {
        return usuarioService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}