package org.example.application.useCase.veiculos

import org.example.domain.entity.Veiculo.Veiculo
import org.example.domain.repository.veiculoRepository.VeiculoRepository
import org.springframework.stereotype.Service


@Service
class CadastrarVeiculoUseCase(private val veiculoRepository: VeiculoRepository) {
    fun execute(veiculo: Veiculo): Veiculo {
        return veiculoRepository.save(veiculo)
    }
}