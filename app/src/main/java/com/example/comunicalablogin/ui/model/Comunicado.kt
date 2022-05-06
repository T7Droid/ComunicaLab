package com.example.comunicalablogin.ui.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Comunicado(val title: String, val content: String)
