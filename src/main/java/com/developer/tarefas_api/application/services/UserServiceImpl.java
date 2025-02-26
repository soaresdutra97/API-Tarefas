package com.developer.tarefas_api.application.services;

import com.developer.tarefas_api.adapters.in.IUserService;
import com.developer.tarefas_api.application.domain.UserDomain;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements IUserService {


    @Override
    public UserDomain criarUsuario(UserDomain userDomain) {
        return null;
    }

    @Override
    public List<UserDomain> buscarTodosUsuarios() {
        return List.of();
    }

    @Override
    public Optional<UserDomain> buscarUsuarioPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public UserDomain atualizarUsuarioPorId(Long id, UserDomain domain) {
        return null;
    }

    @Override
    public void excluirUsuario(Long id) {

    }
}
