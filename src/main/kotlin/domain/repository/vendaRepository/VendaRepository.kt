package org.example.domain.repository.vendaRepository

import org.example.domain.entity.Venda.Venda

interface VendaRepository {
    fun save(venda: Venda): Venda
    fun update(venda: Venda): Venda
    fun findAll(): List<Venda>
    fun findByCodigoPagamento(codigoPagamento: String): Venda?
}