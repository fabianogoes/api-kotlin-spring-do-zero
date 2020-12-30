package com.eprogramar.bank.service

import com.eprogramar.bank.model.Account
import com.eprogramar.bank.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.util.Assert
import java.util.*

@Service
class AccountServiceImpl(private val repository: AccountRepository) : AccountService {
    override fun create(account: Account): Account {
        Assert.hasLength(account.name, "[nome] não pode estar em branco!")
        Assert.isTrue(account.name.length >= 5, "[nome] deve ter no minimo 5 caracteres!")

        Assert.hasLength(account.document, "[document] não pode estar em branco!")
        Assert.isTrue(account.document.length >= 5, "[document] deve ter no 11 caracteres!")

        Assert.hasLength(account.phone, "[phone] não pode estar em branco!")
        Assert.isTrue(account.phone.length >= 5, "[phone] deve ter no 11 caracteres!")

        return repository.save(account)
    }

    override fun getAll(): List<Account> {
        return repository.findAll()
    }

    override fun getById(id: Long): Optional<Account> {
        return repository.findById(id)
    }

    override fun update(id: Long, account: Account): Optional<Account> {
        val optional = getById(id)
        if (optional.isEmpty) {
            return optional
        }

        return optional.map {
            val accountToUpdate = it.copy(
                name = account.name,
                document = account.document,
                phone = account.phone
            )
            repository.save(accountToUpdate)
        }
    }

    override fun delete(id: Long) {
        repository.findById(id).map {
            repository.delete(it)
        }.orElseThrow { throw RuntimeException("Id not found $id") }

    }
}