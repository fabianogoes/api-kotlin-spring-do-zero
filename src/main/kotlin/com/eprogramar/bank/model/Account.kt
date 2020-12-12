package com.eprogramar.bank.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "accounts")
data class Account(
        @Id @GeneratedValue
        var id: Long? = null,
        val name: String,
        val document: String,
        val phone: String
)