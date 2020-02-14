package salazar.armenta.lumbrerasmarquezcalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Define si es el numero1 o el 2
    var cNum=1
    var num1=""
    var num2=""
    var oper=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener(){
            agregarNumero(btn_0.text.toString())
        }
        btn_1.setOnClickListener(){
            agregarNumero(btn_1.text.toString())
        }
        btn_2.setOnClickListener(){
            agregarNumero(btn_2.text.toString())
        }
        btn_3.setOnClickListener(){
            agregarNumero(btn_3.text.toString())
        }
        btn_4.setOnClickListener(){
            agregarNumero(btn_4.text.toString())
        }
        btn_5.setOnClickListener(){
            agregarNumero(btn_5.text.toString())
        }
        btn_6.setOnClickListener(){
            agregarNumero(btn_6.text.toString())
        }
        btn_7.setOnClickListener(){
            agregarNumero(btn_7.text.toString())
        }
        btn_8.setOnClickListener(){
            agregarNumero(btn_8.text.toString())
        }
        btn_9.setOnClickListener(){
            agregarNumero(btn_9.text.toString())
        }


        btn_mas.setOnClickListener(){
            defineOperacion(btn_mas.text.toString())
        }

        btn_menos.setOnClickListener(){
            defineOperacion(btn_menos.text.toString())
        }

        btn_multi.setOnClickListener(){
            defineOperacion(btn_multi.text.toString())
        }

        btn_dividir.setOnClickListener(){
            defineOperacion(btn_dividir.text.toString())
        }

        btn_resultado.setOnClickListener(){
            resultado()
        }

        btn_borrar.setOnClickListener(){
            borrarNum()
        }


    }

    fun agregarNumero(num:String){
        if(cNum==1){
            num1=num1+num
            tx_Numero2.setText(num1)
        }
        else{
            num2=num2+num
            tx_Numero2.setText(num2)
        }
    }

    fun defineOperacion(operacion:String){
        if(cNum==1)
        {
            //Suma
            if(operacion=="+"){
                tx_Numero1.setText("${tx_Numero2.text.toString()}+")
                oper=1
            }
            if(operacion=="-"){
                tx_Numero1.setText("${tx_Numero2.text.toString()}-")
                oper=2
            }
            if(operacion=="*"){
                tx_Numero1.setText("${tx_Numero2.text.toString()}*")
                oper=3
            }
            if(operacion=="/"){
                tx_Numero1.setText("${tx_Numero2.text.toString()}/")
                oper=4
            }
            cNum=2
            tx_Numero2.setText("0")
        }
    }

    fun borrarNum(){
        cNum=1
        num1=""
        num2=""
        oper=0
        tx_Numero1.setText("")
        tx_Numero2.setText("")
    }

    fun resultado(){
        var resultado=0.0
        if(cNum==2){
            when(oper){
                1 -> resultado=(num1.toDouble()+num2.toDouble())
                2 -> resultado=(num1.toDouble()-num2.toDouble())
                3 -> resultado=(num1.toDouble()*num2.toDouble())
                else->{
                    if(num2.toDouble() != 0.0){
                        resultado=num1.toDouble()/num2.toDouble()
                    }else{
                        Toast.makeText(this,"Error: Division por cero", Toast.LENGTH_LONG).show()
                    }
                }
            }

            tx_Numero1.setText("")
            tx_Numero2.setText("$resultado")
            num1="$resultado"
            num2=""
            oper=0
            cNum=1

        }
    }
}
