package br.com.fipgati.eventos.domain.repositorio;

import br.com.fipgati.eventos.domain.model.Usuario;

public interface UsuarioRepositorio extends Repositorio<Usuario> {

    public boolean existeUsuario(Usuario usuario);

    public Usuario carrega(Usuario usuario);

}
