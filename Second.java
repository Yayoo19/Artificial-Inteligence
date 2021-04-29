
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.Agent;
import javax.swing.JOptionPane;

//Agente Receptor
public class Second extends Agent{
    
    @Override
    protected void setup(){
        addBehaviour(new CyclicBehaviour(){

            @Override
            public void action() {
                ACLMessage msg = receive();
                if(msg!= null){
                 JOptionPane.showMessageDialog(null, "Prediction received: "+ msg.getContent());
                   double M = Integer.parseInt(msg.getContent());
                   //System.out.print(M);
                   SimpleLinearRegression ds = new SimpleLinearRegression(M);
                    ds.LR();
                }else {
                    block();
                }
            }
        });
    }
}