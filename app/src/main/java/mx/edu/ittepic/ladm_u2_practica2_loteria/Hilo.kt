package mx.edu.ittepic.ladm_u2_practica2_loteria

import android.view.View

class Hilo(este: MainActivity,voz:Int):Thread() {
    var este= este
    var Revisar=0
    var sound=0
    var voz=voz
    lateinit var arregloPos: Array<Int>
    private var ejecutar = true
    private var pausar = false

    override fun run() {
        super.run()
        while (true) {
            sleep(1800L)
        }
    }

    fun pausarHilo() {
        pausar = true

    }

    fun despausarHilo() {
        pausar = false

    }

    fun estaPausado(): Boolean {
        return pausar
    }

    fun terminar() {
        ejecutar = false
    }

}