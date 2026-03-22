package com.example.basketapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private var pontuacaoTimeA: Int = 0
    private var pontuacaoTimeB: Int = 0

    private lateinit var pTimeA: TextView
    private lateinit var pTimeB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configurarTelaPrincipal()
    }

    private fun configurarTelaPrincipal() {
        setContentView(R.layout.layout_main)

        pTimeA = findViewById(R.id.placarTimeA)
        pTimeB = findViewById(R.id.placarTimeB)

        val bTresPontosTimeA: Button = findViewById(R.id.tresPontosA)
        val bDoisPontosTimeA: Button = findViewById(R.id.doisPontosA)
        val bTLivreTimeA: Button = findViewById(R.id.tiroLivreA)
        val bTresPontosTimeB: Button = findViewById(R.id.tresPontosB)
        val bDoisPontosTimeB: Button = findViewById(R.id.doisPontosB)
        val bTLivreTimeB: Button = findViewById(R.id.tiroLivreB)
        val bReiniciarPartida: Button = findViewById(R.id.reiniciarPartida)

        bTresPontosTimeA.setOnClickListener { tentarJogada(3, "A") }
        bDoisPontosTimeA.setOnClickListener { tentarJogada(2, "A") }
        bTLivreTimeA.setOnClickListener { tentarJogada(1, "A") }
        bTresPontosTimeB.setOnClickListener { tentarJogada(3, "B") }
        bDoisPontosTimeB.setOnClickListener { tentarJogada(2, "B") }
        bTLivreTimeB.setOnClickListener { tentarJogada(1, "B") }
        bReiniciarPartida.setOnClickListener { reiniciarPartida() }

        renderPlacar()
    }

    fun tentarJogada(pontuacao: Int, time: String) {
        setContentView(R.layout.diceroll)

        val bRoll: Button = findViewById(R.id.rolar)
        val imgDado: ImageView = findViewById(R.id.dado)

        bRoll.setOnClickListener {
            val result = (1..6).random()
            val imageResource = when (result) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            imgDado.setImageResource(imageResource)
            imgDado.contentDescription = result.toString()

            val toastTxt: String
            // Lógica de entrar: O dado precisará estar no intervalo [1, 6 - pontuação_da_jogada]
            // Dessa forma a cesta de 3 pontos terá 1/2 chance, a de 2 2/3 e o tiro livre 5/6
            if (result in 1..(6 - pontuacao)) {
                adicionarPontos(pontuacao, time)
                toastTxt = "Valor do dado: $result. Dentro."
            } else {
                toastTxt = "Valor do dado: $result. Fora."
            }

            Toast.makeText(this, toastTxt, Toast.LENGTH_SHORT).show()

            Handler(Looper.getMainLooper()).postDelayed({
                configurarTelaPrincipal()
            }, 1000)
        }
    }

    fun adicionarPontos(pontos: Int, time: String) {
        if (time == "A") {
            pontuacaoTimeA += pontos
        } else {
            pontuacaoTimeB += pontos
        }
        renderPlacar()
    }

    private fun renderPlacar() {
        pTimeA.text = pontuacaoTimeA.toString()
        pTimeB.text = pontuacaoTimeB.toString()
    }

    fun reiniciarPartida() {
        pontuacaoTimeA = 0
        pontuacaoTimeB = 0
        renderPlacar()
        Toast.makeText(this, "Placar reiniciado", Toast.LENGTH_SHORT).show()
    }
}
