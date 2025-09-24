interface Button {
    void paint();
}
interface Checkbox {
    void paint();
}
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

class WinButton implements Button {
    public void paint() {
        System.out.println("Rendering a Windows button.");
    }
}

class WinCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a Windows checkbox.");
    }
}

public class AbstractPattern {
    public static void main(String[] args) {
        GUIFactory factory = new WinFactory();
        Button button = factory.createButton();
        button.paint();
        Checkbox checkbox = factory.createCheckbox();
        checkbox.paint();
    }
}
