package br.ce.wcaquino.servicos;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {
    
    @Test
    public void teste(){
        Assert.assertTrue(true); //Verifica se o booleano passado é verdadeiro
        Assert.assertFalse(false); //Verifica se o booleano passado é falso
        Assert.assertEquals(1, 1); //Verifica se o primeiro parâmetro paramêtro passado é igual ao segundo passado,
        //sendo o primeiro o esperado e o segundo o atual
        //Assert.assertEquals(0.51, 0.51); //AssertEquals comparando duas intâncias de double está deprecated com dois parâmtros
        //então é necessário passar 3 parâmetros sendo o terceiro a margem de erro com um número do tipo double também

        Assert.assertEquals(0.51, 0.51, 0.1);

        int i1 = 1;
        Integer i2 = 1;
        //O assertEquals não consegue fazer boxing e unboxing de tipos primitivos e wrapers, para comparar é necessário:
        Assert.assertEquals(i1, i2.intValue());

        Assert.assertEquals("bola", "bola"); //Validando strings

        //Validando o contrário de Equals, se Não é IGUAL
        Assert.assertNotEquals("casa", "telhado"); //Se os dois valores forem iguais, o teste não passará




        //Assert.assertEquals("bola", "Bola"); //Vai dar erro por estar comparando com uma string de letra maiuscula
        //Deve ser feito da seguinte forma:

        Assert.assertTrue("bola".equalsIgnoreCase("Bola"));

        Assert.assertTrue("bola".startsWith("bo"));

        Usuario u1 = new Usuario("Usuario1");
        Usuario u2 = new Usuario("Usuario2");

        //Validando comparação entre dois objetos
        //Assert.assertEquals(u1, u2); //Dará erro pois são duas instâncias com alocações diferentes na memória
        //Para que funcione, é necessário implementar o método equals do objeto, para que ele compare os valores do objeto
        //mas não sua alocação em memória

        Assert.assertEquals(u1, u1);


        //Verificando se dois objetos possuem a mesma instância
        Assert.assertSame(u1, u1);

        Assert.assertNotSame(u1, u2); //Verifica se são instâncias diferentes, se forem passa, se não não passa

        Usuario u3 = null;

        //Verificando se um objeto é nulo
        Assert.assertTrue(u3 == null);
        //OU
        Assert.assertNull(u3);

        //Verifica se um objeto não é nulo
        Assert.assertNotNull(u1);
    }
}