package org.example.infrastructure.repository.veiculoImpl

import org.example.domain.entity.Veiculo.Veiculo
import org.example.domain.repository.veiculoRepository.VeiculoRepository
import org.springframework.stereotype.Repository

@Repository
class VeiculoRepositoryImpl: VeiculoRepository {

    private val veiculos = mutableListOf<Veiculo>()

    override fun save(veiculo: Veiculo): Veiculo {
        val novoVeiculo = veiculo.copy(id = (veiculos.size + 1).toLong())
        veiculos.add(novoVeiculo)
        return novoVeiculo
    }

    override fun update(veiculo: Veiculo): Veiculo {
        val index = veiculos.indexOfFirst { it.id == veiculo.id }
        if (index != -1) {
            veiculos[index] = veiculo
        }
        return veiculo
    }

    override fun findById(id: Long): Veiculo? {
        return veiculos.find { it.id == id }
    }

    override fun findAllByVendido(vendido: Boolean): List<Veiculo> {
        return veiculos.filter { it.vendido == vendido }
    }

}