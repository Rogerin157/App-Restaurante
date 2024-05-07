package com.example.restaurante // Declaração do pacote onde esta classe está localizada.

import androidx.appcompat.app.AppCompatActivity // Importa a classe AppCompatActivity para criar atividades no estilo moderno do Android.
import android.os.Bundle // Importa a classe Bundle para passar dados entre componentes do Android.
import com.example.restaurante.databinding.ActivityPedidoBinding // Importa a classe gerada automaticamente pelo data binding para a atividade de pedido.

class PedidoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPedidoBinding // Declaração de uma variável 'binding' do tipo ActivityPedidoBinding, que será usada para acessar os elementos da interface do usuário.

    override fun onCreate(savedInstanceState: Bundle?) { // Sobrescreve o método onCreate, que é chamado quando a atividade é criada.
        binding = ActivityPedidoBinding.inflate(layoutInflater) // Usa o método inflate da classe ActivityPedidoBinding para inflar o layout da atividade.
        super.onCreate(savedInstanceState) // Chama a implementação do método onCreate na superclasse AppCompatActivity.
        setContentView(binding.root) // Define o layout inflado como o layout da atividade.

        val i = intent // Obtém a intenção que iniciou esta atividade.
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt() // Obtém a quantidade de pizza passada como extra da intenção e converte para inteiro.
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt() // Obtém a quantidade de salada passada como extra da intenção e converte para inteiro.
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt() // Obtém a quantidade de hambúrguer passada como extra da intenção e converte para inteiro.

        val texto = "Resumo do Pedido\n" + // Constrói o texto de resumo do pedido.
                "Pizza: $quantidadePizza Preço: ${quantidadePizza*8}\n" + // Adiciona informações sobre a pizza, incluindo quantidade e preço.
                "Salada: $quantidadeSalada Preço: ${quantidadeSalada*10}\n" + // Adiciona informações sobre a salada, incluindo quantidade e preço.
                "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer*12}\n" // Adiciona informações sobre o hambúrguer, incluindo quantidade e preço.

        binding.textResumo.text = texto // Define o texto de resumo do pedido no elemento TextView da interface do usuário.
    }
}
