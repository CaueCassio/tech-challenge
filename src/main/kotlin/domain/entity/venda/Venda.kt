package org.example.domain.entity.Venda

import java.time.LocalDateTime

data class Venda(
    val id: Long?,
    val veiculoId: Long,
    val cpfComprador: String,
    val dataVenda: LocalDateTime,
    val precoVenda: Double,
    val codigoPagamento: String,
    val statusPagamento: StatusPagamento = StatusPagamento.PENDENTE
)

enum class StatusPagamento {
    PENDENTE,
    EFETUADO,
    CANCELADO
}