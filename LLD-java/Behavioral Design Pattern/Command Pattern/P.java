import java.util.*;

class Bulb {
    public void on() {
        System.out.println("Bulb turned on");
    }
    public void off() {
        System.out.println("Bulb turned off");
    }
    public void dim() {
        System.out.println("Bulb dimmed");
    }
    public void brighten() {
        System.out.println("Bulb brightened");
    }
    public void flipColor() {
        System.out.println("Bulb color flipped");
    }
    public void changeMode() {
        System.out.println("Bulb mode changed");
    }
}


// command interface
interface Command{
    void execute();
    void undo();
    void redo();
}

class BulbOnCommand implements Command{
    Bulb bulb;
    public BulbOnCommand(Bulb bulb){
        this.bulb = bulb;
    }
    public void execute(){
        bulb.on();
    }
    public void undo(){
        bulb.off();
    }
    public void redo(){
        bulb.on();
    }
}

class BulbOffCommand implements Command{
    private Bulb bulb;
    public BulbOffCommand(Bulb bulb){
        this.bulb = bulb;
    }
    public void execute(){
        bulb.off();
    }
    public void undo(){
        bulb.on();
    }
    public void redo(){
        bulb.off();
    }
}

class BulbDimCommand implements Command{
    private Bulb bulb;
    public BulbDimCommand(Bulb bulb){
        this.bulb = bulb;
    }
    public void execute(){
        bulb.dim();
    }
    public void undo(){
        bulb.brighten();
    }
    public void redo(){
        bulb.dim();
    }
}

class BulbBrightenCommand implements Command{
    private Bulb bulb;
    public BulbBrightenCommand(Bulb bulb){
        this.bulb = bulb;
    }
    public void execute(){
        bulb.brighten();
    }
    public void undo(){
        bulb.dim();
    }
    public void redo(){
        bulb.brighten();
    }
}

class BulbFlipColorCommand implements Command{
    private Bulb bulb;
    public BulbFlipColorCommand(Bulb bulb){
        this.bulb = bulb;
    }
    public void execute(){
        bulb.flipColor();
    }
    public void undo(){
        bulb.changeMode();
    }
    public void redo(){
        bulb.flipColor();
    }
}

// invoker
class RemoteControl{
    private Command[] buttons = new Command[5];
    private Stack<Command> history = new Stack<>();

    public void setCommand(int slot, Command command){
        buttons[slot] = command;
    }
    void pressButton(int slot){
        if(buttons[slot] != null){
            buttons[slot].execute();
            history.push(buttons[slot]);
        }else {
            System.out.println("No command assigned to this button");
        }
    }
    void pressUndo(){
        if(!history.isEmpty()){
            Command lastCommand = history.pop();
            lastCommand.undo();
        }else {
            System.out.println("No command to undo");
        }
    }
    void pressRedo(Command command){
        if(command != null){
            command.redo();
            history.push(command);
        }else {
            System.out.println("No command to redo");
        }
    }
}

public class P {
    public static void main(String[] args) {
        System.out.println("===== Command Pattern ======");
        Bulb bulb = new Bulb();
        RemoteControl remote = new RemoteControl();
        remote.setCommand(0, new BulbOnCommand(bulb));
        remote.setCommand(1, new BulbOffCommand(bulb)); 
        remote.setCommand(2, new BulbDimCommand(bulb));
        remote.setCommand(3, new BulbBrightenCommand(bulb));
        remote.setCommand(4, new BulbFlipColorCommand(bulb));
        remote.pressButton(0); // Bulb turned on
        remote.pressButton(2); // Bulb dimmed
        remote.pressUndo();   // Bulb brightened
        remote.pressButton(4); // Bulb color flipped
        remote.pressRedo(new BulbFlipColorCommand(bulb)); // Bulb color flipped
    }
}
