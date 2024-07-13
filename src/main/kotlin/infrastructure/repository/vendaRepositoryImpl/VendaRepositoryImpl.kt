package org.example.infrastructure.repository.vendaRepositoryImpl

import org.example.domain.entity.Venda.Venda
import org.example.domain.repository.vendaRepository.VendaRepository
import org.springframework.stereotype.Repository

@Repository
class VendaRepositoryImpl : VendaRepository {

    private val vendas = mutableListOf<Venda>()

    override fun save(venda: Venda): Venda {
        val novaVenda = venda.copy(id = (vendas.size + 1).toLong())
        vendas.add(novaVenda)
        return novaVenda
    }

    override fun update(venda: Venda): Venda {
        val index = vendas.indexOfFirst { it.id == venda.id }
        if (index != -1) {
            vendas[index] = venda
        }
        return venda
    }

    override fun findAll(): List<Venda> = vendas

    override fun findByCodigoPagamento(codigoPagamento: String): Venda? {
        return vendas.find { it.codigoPagamento == codigoPagamento }
    }
}