package br.com.bravi;

import br.com.bravi.controller.BalancedController;
import br.com.bravi.service.BalancedService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BraviApplicationTests {

    private static final String valid = "is valid";
    private static final String notValid = "is not valid";
    private static final String objectNotValid = "Text is empty";
    private static final String objectMax = "Ops, text is very long";

    @Autowired
    private BalancedService braviService;

    @Autowired
    private BalancedController braviController;


    @Test
    void balancedController() {
        Assert.assertEquals(braviController.balanced(object("{}")), valid);
        Assert.assertEquals(braviController.balanced(object("[]")), valid);
        Assert.assertEquals(braviController.balanced(object("()")), valid);
        Assert.assertEquals(braviController.balanced(object("{[()]()[][{}]()}")), valid);

        Assert.assertEquals(braviController.balanced(object("{[()]()][{}]()}")), notValid);
        Assert.assertEquals(braviController.balanced(object("{")), notValid);

        Assert.assertEquals(braviController.balanced(null), objectNotValid);
        Assert.assertEquals(braviController.balanced(object(null)), objectNotValid);
        Assert.assertEquals(braviController.balanced(object("")), objectNotValid);
        Assert.assertEquals(braviController.balanced(textMax()), objectMax);
    }

    @Test
    void balancedService() {

        Assert.assertEquals(braviService.balanced("{}"), valid);
        Assert.assertEquals(braviService.balanced("[]"), valid);
        Assert.assertEquals(braviService.balanced("()"), valid);
        Assert.assertEquals(braviService.balanced("{[()]()[][{}]()}"), valid);
        Assert.assertEquals(braviService.balanced("{[]}"), valid);
        Assert.assertEquals(braviService.balanced("(){}[]"), valid);
        Assert.assertEquals(braviService.balanced("[{()}](){}"), valid);

        Assert.assertEquals(braviService.balanced("{"), notValid);
        Assert.assertEquals(braviService.balanced("{[]"), notValid);
        Assert.assertEquals(braviService.balanced("{[()]()][{}]()}"), notValid);
        Assert.assertEquals(braviService.balanced("[]{()"), notValid);
        Assert.assertEquals(braviService.balanced("[{)]"), notValid);
        Assert.assertEquals(braviService.balanced("{[()]()[10][{}]()}"), notValid);
        Assert.assertEquals(braviService.balanced("{[()]()[1][{}]()}T"), notValid);

    }

    private TextObject object(String text) {
        TextObject ob = new TextObject();
        ob.setText(text);
        return ob;
    }

    private TextObject textMax() {
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            x.append("(");
        }
        return object(x.toString());
    }

}
