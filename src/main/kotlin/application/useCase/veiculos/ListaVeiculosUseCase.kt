package org.example.application.useCase.veiculos

import org.example.domain.entity.Veiculo.Veiculo
import org.example.domain.repository.veiculoRepository.VeiculoRepository
import org.springframework.stereotype.Service


@Service
class ListaVeiculosUseCase(private val veiculoRepository: VeiculoRepository) {
    fun execute (vendidos: Boolean): List<Veiculo> {
        return veiculoRepository.findAllByVendido(vendidos).sortedBy { it.preco }
    }
}
