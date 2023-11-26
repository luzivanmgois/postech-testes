package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class CalculadoraTest {

    //injeta a classe Calculadora
    private Calculadora calculadora;


    @BeforeEach // Esse bean garante que o objeto será instanciado do zero para cada método seguinte
    void setup(){
        calculadora = new Calculadora();
    } //Instancia um novo objeto Calculadora que poderá ser utilizado pelos métodos seguintes sem precisar ser instanciado novamente

    @Test
    void deveSomar(){
        int resultadoSoma = calculadora.somar(4, 2);
        //Assertions.assertEquals(6, resultadoSoma);
        assertThat(resultadoSoma).isEqualTo(6); // Realizando o teste usando a lib assertj
    }

    @Test
    void deveSubtrair(){
        int resultadoSubtracao = calculadora.subtrair (4, 2);
        Assertions.assertEquals(2, resultadoSubtracao);
    }

    @Test
    void deveMultiplicar(){
        int resultadoMultiplicacao = calculadora.multiplicar (4, 2);
        Assertions.assertEquals(8, resultadoMultiplicacao);
    }

    @Test
    void deveDividir(){
        int resultadoDivisao = calculadora.dividir (4, 2);
        Assertions.assertEquals(2, resultadoDivisao);
    }

    @Test
    void deveGerarExcecaoQuandoDividirPorZero(){

        /***
        assertThrows(ArithmeticException.class, () ->{
            calculadora.dividir(4,0);
        });
         ***/
        //capturando a execeção e tratando com a lib assertj
        Throwable e = catchThrowable(() -> calculadora.dividir(4, 0));
        assertThat(e).isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero");
    }




}
