package mx.edu.ittepic.ladm_u2_practica2_loteria

import android.media.MediaPlayer
import android.view.View

class Hilo(este: MainActivity,voz:Int):Thread() {
    var este= este
    var corroborar=0
    var sound=0
    var voz=voz
    lateinit var arregloPos: Array<Int>
    private var ejecutar = true
    private var pausar = false

    override fun run() {
        super.run()
        while (ejecutar) {
            if (!pausar) {
                if (sound == -1) {

                    if (sound == 1) {
                        var mp = MediaPlayer.create(este, voz)
                        mp.start()
                        sound = 0
                    }


                }
            }
        }
    }

    fun corre() {
        sound = -1
    }

    fun cambio() {
        sound = 1
    }

    fun terminarHilo() {
        ejecutar = false
    }

    fun pausarHilo() {
        pausar = true
    }

    fun faltaron(falt: Int) {
        var mp = MediaPlayer.create(este, falt)
        mp.start()
    }
}