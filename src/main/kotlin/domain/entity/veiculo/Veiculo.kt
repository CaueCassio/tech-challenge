package org.example.domain.entity.Veiculo

data class Veiculo(
    val id: Long?,
    val marca: String,
    val modelo: String,
    val ano: Int,
    val cor: String,
    val preco: Double,
    val vendido: Boolean = false

)
