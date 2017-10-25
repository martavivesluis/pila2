package edu.upc.data;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;
public class CuaTest {

    final static Logger logger= Logger.getLogger(CuaTest.class);
    private Cua<String> micua;

    @Before
    public void before() {
        micua = new CuaImpl<String>(10);
        micua.push("Marta");//afegim primer element
        logger.info("test iniciat");
        }

    @After
    public void after() {
        logger.info("test completat");
    }

    @Test
    public void size1() throws Exception {
        Assert.assertEquals(1,micua.size());
    }
    @Test
    public void size2() throws Exception {
        micua.push("Toni");
        Assert.assertEquals(2, micua.size());
    }

    @Test
    public void sizepop() throws Exception {
        micua.pop();
        Assert.assertEquals(0, micua.size());
    }

    @Test
    public void sizepushpop() throws Exception {
        micua.push("Toni");
        micua.pop();
        Assert.assertEquals(1, micua.size());
    }

    @Test
    public void popcontent() throws Exception {
        String answer= micua.pop();
        Assert.assertEquals("Marta", answer);
    }

    @Test
    public void popcontentEmptyStackhouldThrowException() throws Exception {
        String answer= micua.pop();
        Assert.assertEquals("Marta", answer);
        try{
            String answer2= micua.pop();
        }catch(Exception e){
            return;
        }
        Assert.fail();
    }

    @Test
    public void popcontentFterPushAfterPop() throws Exception {
        String answer= micua.pop();
        Assert.assertEquals("Marta", answer);
        micua.push("Miguel");
        answer= micua.pop();
        Assert.assertEquals("Miguel", answer);

    }

    public void fifoTest() throws Exception {
        micua.push("Miguel");
        micua.push("Anna");
        micua.push("Veronica");
        String answer= micua.pop();
        Assert.assertEquals("Marta", answer);
        answer= micua.pop();
        Assert.assertEquals("Miguel", answer);

    }
    /*@Test
    public void testCuaPlena() throws Exception {
       // Assert.assertEquals(0, o.suma(-10,10));
    }

    @Test (expected = PilaBuidaException.class)
    public void testCuaBuida() throws Exception {
        Assert.assertEquals(c.size(), 2);
        String r = c.pop();

        String s=c.pop();
    }*/
}

/// fifo 1 ->
//          8am      9am      10am
//First = Marta -> Miguel -> Anna
//hem de fer pop, sera de Marta perque first in first pout
// Fisrt un cop acabat el pop a que haura d'apuntar?
            //Resposta : First = Miguel -> Anna
// Llavors hem de igualar First a que ?
            // First (Marta es ***sobreecriu***)= First.next (Miguel)
// Ara només hem de retornar l'element Marta , com ho fem?
//Pista: que sera first.e?
            // Miguel, no ens val
// Hem de fer un auxiliar abans de ***sobreescciure***
/* el codi queda:
        Node aux = first;
        first = fierst.next
        return aux.element


        AIXO ES QUAN LA CUA ES AIXIS
        //mes aviat, mes aprop del first
        // 8am      9am      10am
//First = Marta -> Miguel -> Anna



QUAN LA CUA ES AIXIS?
        //mes aviat, mes aprop del first
        // 10am      9am      8am
//First = Anna -> Miguel -> Marta

// el pop, com sera?

// Node ultim (Marta) = getUltim();

 */