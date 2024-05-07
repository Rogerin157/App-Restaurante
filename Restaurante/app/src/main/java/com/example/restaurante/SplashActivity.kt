package com.example.restaurante // Declaração do pacote onde esta classe está localizada.

import android.content.Intent // Importa a classe Intent para navegação entre atividades.
import androidx.appcompat.app.AppCompatActivity // Importa a classe AppCompatActivity para criar atividades no estilo moderno do Android.
import android.os.Bundle // Importa a classe Bundle para passar dados entre componentes do Android.
import android.os.Handler // Importa a classe Handler para programar a execução de código em um momento específico.
import android.os.Looper // Importa a classe Looper para fornecer a fila de mensagens associada a um thread.

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // Sobrescreve o método onCreate, que é chamado quando a atividade é criada.
        super.onCreate(savedInstanceState) // Chama a implementação do método onCreate na superclasse AppCompatActivity.
        setContentView(R.layout.activity_splash) // Define o layout da atividade de splash.

        Handler(Looper.getMainLooper()).postDelayed({ // Cria um Handler associado ao Looper principal para postar uma ação com atraso.
            val i = intent // Obtém a intenção que iniciou esta atividade.
            val j = Intent(this, PedidoActivity::class.java) // Cria uma nova intenção para iniciar a atividade PedidoActivity.
            j.putExtras(i) // Adiciona todos os extras da intenção atual à nova intenção.
            startActivity(j) // Inicia a atividade PedidoActivity.
        }, 2000) // Define um atraso de 2000 milissegundos (2 segundos) antes de executar a ação.
    }
}
