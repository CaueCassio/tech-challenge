package org.example.application.useCase.WebhookPagamento

import org.example.domain.entity.Venda.StatusPagamento
import org.example.domain.repository.vendaRepository.VendaRepository
import org.springframework.stereotype.Service


@Service
class WebhookPagamentoUseCase(private val vendaRepository: VendaRepository) {

    fun execute(codigoPagamento: String, status: String) {
        val venda = vendaRepository.findByCodigoPagamento(codigoPagamento)
            ?: throw IllegalArgumentException("Venda não encontrada para o código de pagamento: $codigoPagamento")

        val novoStatus = when (status.lowercase()) {
            "efetuado" -> StatusPagamento.EFETUADO
            "cancelado" -> StatusPagamento.CANCELADO
            else -> throw IllegalArgumentException("Status de pagamento inválido: $status")
        }

        val vendaAtualizada = venda.copy(statusPagamento = novoStatus)
        vendaRepository.update(vendaAtualizada)
    }

}