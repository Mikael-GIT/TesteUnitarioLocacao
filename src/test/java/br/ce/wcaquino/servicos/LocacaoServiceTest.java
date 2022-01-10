package br.ce.wcaquino.servicos;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;


public class LocacaoServiceTest {
    
    private LocacaoService locacaoService;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup(){
        locacaoService = new LocacaoService();
    }

    @After
    public void tearDown(){
        System.out.println("After");
    }
    @Test
    public void teste() throws Exception{

        //cenário
        Usuario usuario = new Usuario("Mikael");
        Filme filme = new Filme("A culpa é das estrelas", 2, 40.00);
        //ação
        Locacao locacao = locacaoService.alugarFilme(usuario, filme);

        //verificação
        Assert.assertTrue(locacao.getValor() == 40.00);
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
    }


    @Test(expected = Exception.class)
    public void verificaSeEstaSemOFilmeNoEstoqueFormaElegante() throws Exception{

        //cenário
        Usuario usuario = new Usuario("Mikael");
        Filme filme = new Filme("A culpa é das estrelas", 0, 40.00);

        //ação
        Locacao locacao = locacaoService.alugarFilme(usuario, filme);
    }

    @Test(expected = Exception.class)
    public void verificaSeEstaSemOFilmeNoEstoqueNovaForma() throws Exception{

        //cenário
        Usuario usuario = new Usuario("Mikael");
        Filme filme = new Filme("A culpa é das estrelas", 0, 40.00);
    

        //ação
        Locacao locacao = locacaoService.alugarFilme(usuario, filme);
        exception.expect(Exception.class);
        exception.expectMessage("Filme sem estoque");
        //verificação

    }

}