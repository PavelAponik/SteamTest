package framework.elements;

import org.openqa.selenium.By;

public class Button extends BaseElement{

    public Button(String locator) {
        super(By.id(locator));
    }
}
