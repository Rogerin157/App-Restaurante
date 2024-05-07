package com.example.restaurante // Declaração do pacote onde esta classe está localizada.

import android.content.Intent // Importa a classe Intent para navegação entre atividades.
import android.os.Bundle // Importa a classe Bundle para passar dados entre componentes do Android.
import android.view.View // Importa a classe View para manipulação de elementos da interface do usuário.
import androidx.appcompat.app.AppCompatActivity // Importa a classe AppCompatActivity para criar atividades no estilo moderno do Android.
import com.example.restaurante.databinding.ActivityMainBinding // Importa a classe gerada automaticamente pelo data binding para a atividade principal.

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // Declaração de uma variável 'binding' do tipo ActivityMainBinding, que será usada para acessar os elementos da interface do usuário.

    override fun onCreate(savedInstanceState: Bundle?) { // Sobrescreve o método onCreate, que é chamado quando a atividade é criada.
        super.onCreate(savedInstanceState) // Chama a implementação do método onCreate na superclasse AppCompatActivity.

        binding = ActivityMainBinding.inflate(layoutInflater) // Usa o método inflate da classe ActivityMainBinding para inflar o layout da atividade.
        setContentView(binding.root) // Define o layout inflado como o layout da atividade.

        val username = intent.extras?.getString("username") // Obtém o nome de usuário passado como extra da intenção.

        if (!username.isNullOrEmpty()) { // Verifica se o nome de usuário não é nulo ou vazio.
            binding.textOla.setText("Olá $username") // Define o texto de saudação com o nome de usuário.
        }

        binding.buttonFechar.setOnClickListener { // Define um ouvinte de clique para o botão "buttonFechar".
            finishAffinity() // Finaliza a atividade atual e todas as atividades associadas.
        }

        binding.buttonPedir.setOnClickListener { // Define um ouvinte de clique para o botão "buttonPedir".
            val i = Intent(this, SplashActivity::class.java) // Cria uma nova intenção para iniciar a atividade SplashActivity.
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString()) // Adiciona a quantidade de pizza como extra à intenção.
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString()) // Adiciona a quantidade de salada como extra à intenção.
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString()) // Adiciona a quantidade de hambúrguer como extra à intenção.
            startActivity(i) // Inicia a atividade SplashActivity.
            finish() // Finaliza a atividade atual.
        }

        binding.checkPizza.setOnClickListener { // Define um ouvinte de clique para o checkbox "checkPizza".
            if (binding.checkPizza.isChecked()) { // Verifica se o checkbox está marcado.
                binding.editQuantidadePizza.setText("1") // Define a quantidade de pizza como 1.
                binding.textPrecoPizza.visibility = View.VISIBLE // Torna o preço da pizza visível.
            } else {
                binding.editQuantidadePizza.setText("0") // Define a quantidade de pizza como 0.
                binding.textPrecoPizza.visibility = View.GONE // Torna o preço da pizza invisível.
            }
        }

        binding.checkSalada.setOnClickListener { // Define um ouvinte de clique para o checkbox "checkSalada".
            if (binding.checkSalada.isChecked()) { // Verifica se o checkbox está marcado.
                binding.editQuantidadeSalada.setText("1") // Define a quantidade de salada como 1.
                binding.textPrecoSalada.visibility = View.VISIBLE // Torna o preço da salada visível.
            } else {
                binding.editQuantidadeSalada.setText("0") // Define a quantidade de salada como 0.
                binding.textPrecoSalada.visibility = View.GONE // Torna o preço da salada invisível.
            }
        }

        binding.checkHamburger.setOnClickListener { // Define um ouvinte de clique para o checkbox "checkHamburger".
            if (binding.checkHamburger.isChecked()) { // Verifica se o checkbox está marcado.
                binding.editQuantidadeHamburguer.setText("1") // Define a quantidade de hambúrguer como 1.
                binding.textPrecoHamburguer.visibility = View.VISIBLE // Torna o preço do hambúrguer visível.
            } else {
                binding.editQuantidadeHamburguer.setText("0") // Define a quantidade de hambúrguer como 0.
                binding.textPrecoHamburguer.visibility = View.GONE // Torna o preço do hambúrguer invisível.
            }
        }
    }
}
