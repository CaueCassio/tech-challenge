package org.example.presentation.controller.webhook

import org.example.application.useCase.WebhookPagamento.WebhookPagamentoUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/webhook")
class WebHookController( private val webhookPagamentoUseCase: WebhookPagamentoUseCase){

       @PostMapping("/pagamento")
       fun processarPagamento(@RequestParam codigo: String, @RequestParam status: String): ResponseEntity<Void>{
           webhookPagamentoUseCase.execute(codigo,status)
           return ResponseEntity.ok().build()
       }
}