package com.example.comunicalablogin.ui.model

data class User(
    val createdAt: String,
    val email: String,
    val emailVerified: Boolean,
    val lastLoginAt: String,
    val lastRefreshAt: String,
    val localId: String,
    val passwordHash: String,
    val passwordUpdatedAt: Long,
    val providerUserInfo: List<ProviderUserInfo>,
    val validSince: String
)