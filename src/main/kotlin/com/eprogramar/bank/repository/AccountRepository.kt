package com.eprogramar.bank.repository

import com.eprogramar.bank.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long> {
}