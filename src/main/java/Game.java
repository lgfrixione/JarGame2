public class Game {
    public static void main(String[] args) {
        JarLogic jarLogic =new JarLogic();
        Prompter prompter = new Prompter(jarLogic);
        prompter.play();

    }
}
