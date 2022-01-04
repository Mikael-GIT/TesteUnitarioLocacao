package br.ce.wcaquino.servicos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;


public class LocacaoServiceTest {
    
    @Test
    public void teste(){

        //cenário
        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("Mikael");
        Filme filme = new Filme("A culpa é das estrelas", 4, 40.00);
        //ação
        Locacao locacao = locacaoService.alugarFilme(usuario, filme);

        //verificação
        Assert.assertEquals(40.00, locacao.getValor(), 0.01);
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
    }
}