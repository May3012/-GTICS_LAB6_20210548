package com.example.labdejavier.repository;

import com.example.labdejavier.entity.Usuario;

public interface UsuarioRepository {

    Usuario findUsuarioByCorreo(String correo);
}
