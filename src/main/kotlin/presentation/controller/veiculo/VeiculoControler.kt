package org.example.presentation.controller.veiculo


import org.example.application.useCase.veiculos.CadastrarVeiculoUseCase
import org.example.application.useCase.veiculos.EditarVeiculoUseCase
import org.example.application.useCase.veiculos.EfetuarVendaUseCase
import org.example.application.useCase.veiculos.ListaVeiculosUseCase
import org.example.domain.entity.Veiculo.Veiculo
import org.example.domain.entity.Venda.Venda
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/veiculos")
class VeiculoController (

    private val cadastrarVeiculoUseCase: CadastrarVeiculoUseCase,
    private val editarVeiculoUseCase: EditarVeiculoUseCase,
    private val listarVeiculosUseCase: ListaVeiculosUseCase,
    private val efetuarVendaUseCase: EfetuarVendaUseCase

) {

    @PostMapping
    fun cadastraVeiculo(@RequestBody veiculo: Veiculo): ResponseEntity<Veiculo> {
        val novoVeiculo = cadastrarVeiculoUseCase.execute(veiculo)
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo)
    }

    @PutMapping("/{id}")
    fun editarVeiculo(@PathVariable id: Long, @RequestBody veiculo: Veiculo): ResponseEntity<Veiculo> {
        val veiculo = editarVeiculoUseCase.execute(veiculo.copy(id = id))
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo)
    }

    @GetMapping
    fun listaVeiculos(@RequestParam vendido:Boolean): ResponseEntity<List<Veiculo>> {
        val veiculos = listarVeiculosUseCase.execute(vendido)
        return ResponseEntity.ok(veiculos)
    }

    @PostMapping("/venda")
    fun efetuarVenda(@RequestBody venda: Venda ): ResponseEntity<Venda> {
        val novaVenda = efetuarVendaUseCase.execute(venda)
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda)
    }

}


