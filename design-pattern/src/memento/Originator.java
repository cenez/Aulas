package memento;

public class Originator {
    private String atributo;
    public void setAtributo(String atributo) {
        this.atributo = atributo;
        System.out.println("Originator: gravando atributo " + atributo);
    }
    public String getAtributo() {
    	return this.atributo;
    }
    public Memento saveToMemento() {
        System.out.println("Originator: salvando o Memento.");
        return new Memento(this.atributo);
    }
    public void restoreFromMemento(Memento memento) {
        this.atributo = memento.getSavedAtributo();
        System.out.println("Originator: Atributo depois de restaura do Memento: " + atributo);
    } 
    public static class Memento {
        private final String atritutoState;
        public Memento(String atritutoToSave) {
            atritutoState = atritutoToSave;
        } 
        private String getSavedAtributo() {
            return atritutoState;
        }
    }
}
