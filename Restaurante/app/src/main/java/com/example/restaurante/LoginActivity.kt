package com.example.restaurante // Declaração do pacote onde esta classe está localizada.

import android.content.Intent // Importa a classe Intent para navegação entre atividades.
import android.os.Bundle // Importa a classe Bundle para passar dados entre componentes do Android.
import android.widget.Toast // Importa a classe Toast para exibir mensagens curtas na tela.
import androidx.appcompat.app.AppCompatActivity // Importa a classe AppCompatActivity para criar atividades no estilo moderno do Android.
import com.example.restaurante.databinding.ActivityLoginBinding // Importa a classe gerada automaticamente pelo data binding para a atividade de login.

class LoginActivity : AppCompatActivity() { // Declaração da classe LoginActivity, que estende AppCompatActivity, indicando que é uma atividade do Android.

    private lateinit var binding: ActivityLoginBinding // Declaração de uma variável 'binding' do tipo ActivityLoginBinding, que será usada para acessar os elementos da interface do usuário.

    override fun onCreate(savedInstanceState: Bundle?) { // Sobrescreve o método onCreate, que é chamado quando a atividade é criada.
        super.onCreate(savedInstanceState) // Chama a implementação do método onCreate na superclasse AppCompatActivity.

        binding = ActivityLoginBinding.inflate(layoutInflater) // Usa o método inflate da classe ActivityLoginBinding para inflar o layout da atividade.
        setContentView(binding.root) // Define o layout inflado como o layout da atividade.

        binding.buttonEntrar.setOnClickListener { // Define um ouvinte de clique para o botão "buttonEntrar" usando uma expressão lambda.

            val username = binding.editUsername.text.toString().trim() // Obtém o texto digitado no campo de usuário e remove espaços em branco desnecessários.
            val password = binding.editPassword.text.toString().trim() // Obtém o texto digitado no campo de senha e remove espaços em branco desnecessários.

            if (username.equals("abc") && password.equals("123")) { // Verifica se o nome de usuário e a senha correspondem aos valores esperados.
                val i = Intent(this, MainActivity::class.java) // Cria uma nova intenção para iniciar a atividade MainActivity.
                i.putExtra("username", username) // Adiciona um extra à intenção para passar o nome de usuário para a próxima atividade.
                startActivity(i) // Inicia a atividade MainActivity.
                finish() // Finaliza a atividade atual para que o usuário não possa voltar para ela pressionando o botão "Voltar".
            } else {
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show() // Exibe uma mensagem curta informando ao usuário que ocorreu um erro durante o login.
            }
        }
    }
}
