package org.example.application.useCase.venda

import org.example.domain.entity.Venda.Venda
import org.example.domain.repository.veiculoRepository.VeiculoRepository
import org.example.domain.repository.vendaRepository.VendaRepository
import org.springframework.stereotype.Service


@Service
class EfetuarVendaUseCase(
    private val veiculoRepository: VeiculoRepository,
    private val vendaRepository: VendaRepository
){
    fun execute(venda: Venda): Venda {
        val veiculo = veiculoRepository.findById(venda.veiculoId)
            ?: throw IllegalArgumentException("Veículo com ID ${venda.veiculoId} não encontrado")

        if (veiculo.vendido) {
            throw IllegalArgumentException("Veículo com ID ${venda.veiculoId} já foi vendido")
        }


        veiculo.vendido = true
        veiculoRepository.update(veiculo)

        return vendaRepository.save(venda)
    }
}