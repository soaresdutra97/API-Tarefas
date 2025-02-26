package com.developer.tarefas_api.adapters.out.repositories;

import com.developer.tarefas_api.application.domain.UserDomain;
import com.developer.tarefas_api.ports.out.IUserRepository;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements IUserRepository {
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
