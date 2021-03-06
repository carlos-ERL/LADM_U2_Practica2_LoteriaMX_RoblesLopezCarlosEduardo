package mx.edu.ittepic.ladm_u2_practica2_loteria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.coroutines.CoroutineScope
import mx.edu.ittepic.ladm_u2_practica2_loteria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var binding: ActivityMainBinding

        lateinit var globalscope: CoroutineScope
        lateinit var baraja: CartaLoteria
        var falt=0

        var imagenesCartas = arrayOf(
            R.drawable.elgallo,
            R.drawable.eldiablito,
            R.drawable.ladama,
            R.drawable.elcatrin,
            R.drawable.elparaguas,
            R.drawable.lasirena,
            R.drawable.laescalera,
            R.drawable.labotella,
            R.drawable.elbarril,
            R.drawable.elarbol,
            R.drawable.elmelon,
            R.drawable.elvaliente,
            R.drawable.elgorrito,
            R.drawable.lamuerte,
            R.drawable.lapera,
            R.drawable.labandera,
            R.drawable.elbandolon,
            R.drawable.elvioloncello,
            R.drawable.lagarza,
            R.drawable.elpajaro,
            R.drawable.lamano,
            R.drawable.labota,
            R.drawable.laluna,
            R.drawable.elcotorro,
            R.drawable.elborracho,
            R.drawable.elnegrito,
            R.drawable.elcorazon,
            R.drawable.lasandia,
            R.drawable.eltambor,
            R.drawable.elcamaron,
            R.drawable.lasjaras,
            R.drawable.elmusico,
            R.drawable.laarana,
            R.drawable.elsoldado,
            R.drawable.laestrella,
            R.drawable.elcazo,
            R.drawable.elmundo,
            R.drawable.elapache,
            R.drawable.elnopal,
            R.drawable.elalacran,
            R.drawable.larosa,
            R.drawable.lacalavera,
            R.drawable.lacampana,
            R.drawable.elcantarito,
            R.drawable.elvenado,
            R.drawable.elsol,
            R.drawable.lacorona,
            R.drawable.lachalupa,
            R.drawable.elpino,
            R.drawable.elpescado,
            R.drawable.lapalma,
            R.drawable.lamaceta,
            R.drawable.elarpa,
            R.drawable.larana
        )
        var sonidos = arrayOf(R.raw.elgallo, R.raw.eldiablito, R.raw.ladama, R.raw.elcatrin, R.raw.elparaguas,
            R.raw.lasirena, R.raw.laescalera, R.raw.labotella, R.raw.elbarril, R.raw.elarbol, R.raw.elmelon,
            R.raw.elvaliente, R.raw.elgorrito, R.raw.lamuerte, R.raw.lapera, R.raw.labandera, R.raw.elbandolon,
            R.raw.elvioloncello, R.raw.lagarza, R.raw.elpajaro, R.raw.lamano, R.raw.labota, R.raw.laluna,
            R.raw.elcotorro, R.raw.elborracho, R.raw.elnegrito, R.raw.elcorazon, R.raw.lasandia, R.raw.eltambor,
            R.raw.elcamaron, R.raw.lasjaras, R.raw.elmusico, R.raw.laarana, R.raw.elsoldado, R.raw.laestrella,
            R.raw.elcazo, R.raw.elmundo, R.raw.elapache, R.raw.elnopal, R.raw.elalacran, R.raw.larosa,
            R.raw.lacalavera, R.raw.lacampana, R.raw.elcantarito, R.raw.elvenado, R.raw.elsol, R.raw.lacorona,
            R.raw.lachalupa, R.raw.elpino, R.raw.elpescado, R.raw.lapalma, R.raw.lamaceta, R.raw.elarpa,
            R.raw.larana)

        var arregloPos = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
            43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53
        )
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var revHilo=Hilo(this,R.raw.faltantes)

        revHilo.start()
        binding.btnFaltantes.visibility = View.GONE
        binding.btnReiniciar.visibility = View.GONE

        binding.btnIniciar.setOnClickListener {
            binding.btnIniciar.visibility = View.GONE
            binding.btnGanador.visibility = View.VISIBLE
            baraja= CartaLoteria(this,binding.CartaActual,imagenesCartas,sonidos)
            arregloPos= baraja.mezclar(arregloPos)
            baraja.correr(arregloPos)
            revHilo.corre()
        }
        binding.btnGanador.setOnClickListener {
            binding.btnFaltantes.visibility = View.VISIBLE
            baraja.parar()
        }
        binding.btnFaltantes.setOnClickListener {
            binding.btnFaltantes.visibility = View.GONE
            binding.btnGanador.visibility = View.GONE
            binding.btnReiniciar.visibility = View.VISIBLE
            revHilo.cambio()
            baraja.corroborarCartas(arregloPos)
        }
        binding.btnReiniciar.setOnClickListener {
            baraja.terminar()
            binding.btnIniciar.visibility = View.VISIBLE
            binding.btnReiniciar.visibility = View.GONE
            binding.CartaActual.setImageResource(R.drawable.tablaloteria)
        }
    }
}