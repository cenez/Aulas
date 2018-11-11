package memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker { //cuidador, zelador, armazenador
    public static void main(String[] args) {
        List<Originator.Memento> savedAtributos = new ArrayList<Originator.Memento>();
 
        Originator originator = new Originator();
        originator.setAtributo("Valor1");
        originator.setAtributo("Valor2");
        
        savedAtributos.add(originator.saveToMemento());
        originator.setAtributo("Valor3");

        savedAtributos.add(originator.saveToMemento());
        originator.setAtributo("Valor4");
 
        originator.restoreFromMemento(savedAtributos.get(1));
    }
}
