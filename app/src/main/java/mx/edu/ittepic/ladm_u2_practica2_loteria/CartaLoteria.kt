package mx.edu.ittepic.ladm_u2_practica2_loteria

import android.media.MediaPlayer
import android.widget.ImageView
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.random.Random

class CartaLoteria(este:MainActivity, iview: ImageView, imagen:Array<Int>, sonido:Array<Int>) {
    var este= este
    var view = iview
    var imagen= imagen
    var sonido= sonido
    var index = 0
    var corroborar = -1
    var idsonido=0
    lateinit var checkHilo:Hilo
    lateinit var globalscope: CoroutineScope
    lateinit var voz : CoroutineContext
    lateinit var check : CoroutineContext
    private var prim = true
    lateinit var imageCard : Array<Int>
    lateinit var imageSound : Array<Int>



    init {
        globalscope = CoroutineScope(Job() + Dispatchers.Main)
        imageCard=imagen
        imageSound=sonido
    }

    fun mezclar(pos: Array<Int>):Array<Int>{
        var aux = 0
        for (i in 0 until pos.size ) {
            index = Random.nextInt(pos.size - 1)
            aux = pos[i]
            pos[i] = pos[index]
            pos[index] = aux
        }
        return pos
    }
    fun correr(pos: Array<Int>) {
        corroborar=-1
        voz=globalscope.launch(EmptyCoroutineContext, CoroutineStart.LAZY){
            delay(3000)
            for (i in 0 until pos.size ) {
                view.setImageResource(imageCard[pos[i]])
                idsonido=imageSound[pos[i]]
                var mp= MediaPlayer.create(este,idsonido)
                mp.start()
                corroborar++
                delay(2000)
                mp.release()
            }
            view.setImageResource(0)
        }
        (voz as Job).start()
    }
    fun parar(){
        voz.cancel()
    }
    fun corroborarCartas(pos: Array<Int>){
        check=globalscope.launch(EmptyCoroutineContext,CoroutineStart.LAZY){
            delay(2000)
            if(corroborar+1!=pos.size-1)
                corroborar++
            for (i in corroborar until pos.size) {
                idsonido=imageSound[pos[i]]
                var mp=MediaPlayer.create(este,idsonido)
                mp.start()
                view.setImageResource(imageCard[pos[i]])

                delay(2000)
            }
            view.setImageResource(0)
        }
        (check as Job).start()
    }

    fun terminar(){
        check.cancel()
    }

}