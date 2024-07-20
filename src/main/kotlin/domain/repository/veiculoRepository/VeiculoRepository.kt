package org.example.domain.repository.veiculoRepository

import org.example.domain.entity.Veiculo.Veiculo

interface VeiculoRepository {
    fun save(veiculo: Veiculo): Veiculo
    fun update(veiculo: Veiculo): Veiculo
    fun findById(id: Long): Veiculo?
    fun findAllByVendido(vendido: Boolean): List<Veiculo>
}