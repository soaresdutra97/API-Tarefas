package com.developer.tarefas_api.adapters.in;

import com.developer.tarefas_api.application.domain.UserDomain;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    UserDomain criarUsuario (UserDomain userDomain);
    List<UserDomain> buscarTodosUsuarios ();
    Optional<UserDomain> buscarUsuarioPorId (Long id);
    UserDomain atualizarUsuarioPorId (Long id, UserDomain domain);
    void excluirUsuario (Long id);

}