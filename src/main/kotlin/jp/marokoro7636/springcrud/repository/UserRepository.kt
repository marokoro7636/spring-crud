package jp.marokoro7636.springcrud.repository

import jp.marokoro7636.springcrud.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, Int>