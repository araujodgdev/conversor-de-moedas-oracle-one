import utils.Interaction;

public class Main {
    public static void main(String[] args) {
        Interaction interaction = new Interaction();

        interaction.welcome();
        interaction.showMenu();
        int userOption = interaction.readOption();


    }
}