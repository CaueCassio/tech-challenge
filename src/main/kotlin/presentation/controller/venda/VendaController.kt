package org.example.presentation.controller.venda

import org.example.application.useCase.venda.EfetuarVendaUseCase
import org.example.application.useCase.venda.ListarVendasUseCase
import org.example.domain.entity.Venda.Venda
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vendas")
class VendaController(
    private val efetuarVendaUseCase: EfetuarVendaUseCase,
    private val listarVendasuseCase: ListarVendasUseCase
) {

    @PostMapping
    fun efetuarVenda(@RequestBody venda: Venda): ResponseEntity<Venda> {
        val novaVenda = efetuarVendaUseCase.execute(venda)
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda)
    }

    @GetMapping()
    fun listarVendas(): ResponseEntity<List<Venda>> {
        val vendas = listarVendasuseCase.execute()
        return ResponseEntity.ok(vendas)
    }
}